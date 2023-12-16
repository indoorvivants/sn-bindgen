package bindgen

import _root_.libclang.structs.*
import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.functions.*
import _root_.libclang.fluent.*

import java.io.FileWriter
import java.nio.file.Files
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*
import scala.scalanative.runtime.libc
import libclang.fluent.string
import scala.util.boundary, boundary.break, boundary.Label

extension [A, B](e: Either[BindingError, A])
  def ?(using Label[Either[BindingError, B]]): A =
    e match
      case Left(value)  => break(Left(value))
      case Right(value) => value

def analyse(file: String)(using Zone)(using
    config: Config
): Either[BindingError, Binding] =
  boundary:
    val clang = clangInfo(config.systemPathDetection).?

    val systemDetector = SystemHeaderDetector(clang)

    val index = clang_createIndex(0, 0)

    val unit =
      ClangTranslationUnit.create(index, file, clang).?

    val (cxClientData, memory) =
      Captured.unsafe(systemDetector -> BindingBuilder())

    val translationUnitCursor = ClangTranslationUnit.getCursor(unit).?

    val visitor = ClangVisitor.visitor

    try
      libclang.fluent.clang_visitChildren(
        translationUnitCursor,
        visitor,
        CXClientData.wrap(cxClientData)
      )

      val binding: BindingBuilder = (!cxClientData)._1._2

      trace(
        "Binding information before adding system aliases:",
        binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
          k.toString -> v
        }
      )

      addBuiltInAliases(binding)

      trace(
        "Binding information after adding system alises:",
        binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
          k.toString -> v
        }
      )
      val closure = computeClosure(binding.named.filter { n =>
        val name = n._1.n

        if config.exclusivePrefix.isEmpty then true
        else config.exclusivePrefix.exists(ep => name.startsWith(ep.value))
      }.toMap)

      trace(s"Defined or used in main file: ${closure}")

      binding.named.filterInPlace((k, _) => closure.contains(k.n))
      binding.unnamed.filterInPlace(_.location.shouldBeIncluded)

      trace(
        "Binding information after computing closure:",
        binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
          k.toString -> v
        }
      )

      Right(binding.build)
    finally
      memory.deallocate()
      clang_disposeTranslationUnit(unit)
      clang_disposeIndex(index)

    end try

end analyse

def addBuiltInAliases(binding: BindingBuilder)(using
    LoggingConfig
): BindingBuilder =
  val replaceTypes = DefTag.all - DefTag.Function
  BuiltinType.all.foreach { tpe =>
    val al = Def.Alias(
      name = tpe.short,
      underlying = CType.Reference(Name.BuiltIn(tpe)),
      meta = Meta.empty
    )
    replaceTypes.foreach { tg =>

      val annoyingBastards =
        Set("__gnuc_va_list", "__builtin_va_list", "__darwin_va_list")

      binding.named.get(DefName(tpe.short, tg)).collect {
        case BindingDefinition(
              Def.Alias(
                "va_list",
                CType.Reference(
                  Name.Model(ref, _)
                ),
                _
              ),
              _
            ) if annoyingBastards(ref) =>
          binding.remove(DefName(tpe.short, DefTag.Alias))
          annoyingBastards.foreach { b =>
            binding.remove(DefName(b, DefTag.Alias))
          }

          binding.add(al, location = Location.systemHeader)

        case bd =>
          if bd.location.isFromSystemHeader then
            binding.remove(DefName(tpe.short, tg))
            binding.add(al, location = Location.systemHeader)
      }
    }
  }
  binding
end addBuiltInAliases

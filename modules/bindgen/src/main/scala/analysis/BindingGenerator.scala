package bindgen

import libclang.*

import fluent.*
import scalanative.unsafe.*

object BindingGenerator:
  def run(context: Context, environment: ConfiguredEnvironment)(using
      Zone
  )(using
      config: Config
  ): Either[BindingError, Binding] =
    val index = clang_createIndex(0, 0)

    ClangTranslationUnit
      .create(index, context.headerFile.value, environment.clang)
      .flatMap: translationUnit =>

        val (cxClientData, memory) =
          Captured.unsafe(environment.systemHeaderDetector -> BindingBuilder())

        ClangTranslationUnit
          .getCursor(translationUnit)
          .flatMap: translationUnitCursor =>
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
                else
                  config.exclusivePrefix.exists(ep => name.startsWith(ep.value))
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
              clang_disposeTranslationUnit(translationUnit)
              clang_disposeIndex(index)
            end try

  end run
end BindingGenerator

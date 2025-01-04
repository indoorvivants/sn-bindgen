package bindgen

import java.io.FileWriter
import java.nio.file.Files
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*
import libclang.fluent.string

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

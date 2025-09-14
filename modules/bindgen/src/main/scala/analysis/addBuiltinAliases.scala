package bindgen

def addBuiltInAliases(binding: BindingBuilder)(using
    LoggingConfig
): BindingBuilder =
  val replaceTypes = CDefinitionTag.all - CDefinitionTag.Function
  BuiltinType.all.foreach { tpe =>
    val al = CDefinition.Alias(
      name = tpe.short,
      underlying = CType.Reference(Name.BuiltIn(tpe)),
      meta = Metadata.empty
    )
    replaceTypes.foreach { tg =>

      val annoyingBastards =
        Set("__gnuc_va_list", "__builtin_va_list", "__darwin_va_list")

      binding.named.get(DefName(tpe.short, tg)).collect {
        case BindingDefinition(
              CDefinition.Alias(
                "va_list",
                CType.Reference(
                  Name.Model(ref, _)
                ),
                _
              ),
              _
            ) if annoyingBastards(ref) =>
          binding.remove(DefName(tpe.short, CDefinitionTag.Alias))
          annoyingBastards.foreach { b =>
            binding.remove(DefName(b, CDefinitionTag.Alias))
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

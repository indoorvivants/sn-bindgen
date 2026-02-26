package bindgen
package rendering

class AnonymousNameGenerator(
    private var unions: Int = 0,
    private var structs: Int = 0,
    private var enums: Int = 0
):
  def genStructName(hint: Option[String]) =
    StructName(
      hint
        .map(_.smartCapitalize)
        .getOrElse({
          val res = s"Struct$structs"
          structs += 1
          res
        })
    )

  def genUnionName(hint: Option[String]) =
    UnionName(
      hint
        .map(_.smartCapitalize)
        .getOrElse({
          val res = s"Union$unions"
          unions += 1
          res
        })
    )

  def genEnumName(hint: Option[String]) =
    EnumName(
      hint
        .map(_.smartCapitalize)
        .getOrElse({
          val res = s"Enum$enums"
          enums += 1
          res
        })
    )
end AnonymousNameGenerator

extension (s: String)
  def smartCapitalize: String =
    if s == null || s.length == 0 then s
    else
      val lowerIdx = s.indexWhere(_.isLower)
      if lowerIdx >= 0 then s.updated(lowerIdx, s.charAt(lowerIdx).toUpper)
      else s

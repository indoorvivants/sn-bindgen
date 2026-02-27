package bindgen
package rendering

def struct(struct: ResolvedStruct, line: Appender)(using
    c: Config,
    ctx: Context,
    ar: AliasResolver
): Exported =
  StructRenderer(struct, line).render()

private val alignMethod =
  """
def align(offset: Int, alignment: Int) = {
  val alignmentMask = alignment - 1
  val padding =
    if ((offset & alignmentMask) == 0) 0
    else alignment - (offset & alignmentMask)
  offset + padding
}
""".trim().linesIterator.toList

package bindgen

transparent inline def compileErrors(inline code: String): String =
  val errors = scala.compiletime.testing.typeCheckErrors(code)
  errors
    .map { error =>
      val indent = " " * (error.column - 1)
      val trimMessage = error.message.linesIterator
        .map(line => if line.matches(" +") then "" else line)
        .mkString("\n")
      val separator = if error.message.contains('\n') then "\n" else " "
      s"error:$separator$trimMessage\n${error.lineContent}\n$indent^"
    }
    .mkString("\n")
    .trim
end compileErrors

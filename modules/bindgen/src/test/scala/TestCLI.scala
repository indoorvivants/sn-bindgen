package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestCLI:

  def parse(cmd: String*) = bindgen.CLI.command.parse(cmd)
  def parseRight(cmd: Seq[String]) = bindgen.CLI.command
    .parse(cmd)
    .fold(h => throw new RuntimeException(h.errors.mkString(", ")), identity)

  def parseExtra(cmd: String*) = parseRight(MINIMUM ++ cmd)

  val MINIMUM = Seq("--package", "helloworld", "--header", "test.h")

  @Test def test_minimum() =
    assertEquals("helloworld", parseRight(MINIMUM).packageName.value)
    assertEquals("test.h", parseRight(MINIMUM).headerFile.value)

  @Test def `test_render.no-constructor`() =
    assertEquals(
      Set("StructA", "StructB"),
      parseExtra(
        "--render.no-constructor",
        "StructA,StructB"
      ).rendering.noConstructor
    )

  @Test def test_langs() =
    assertEquals(Lang.Scala, parseExtra("--scala").lang)
    assertEquals(Lang.C, parseExtra("--c").lang)

  @Test def test_out() =
    assertEquals(
      Some("test.scala"),
      parseExtra("--out", "test.scala").outputFile.map(_.value)
    )

  @Test def test_linkName() =
    assertEquals(
      Some("mylib"),
      parseExtra("--link-name", "mylib").linkName.map(_.value)
    )

end TestCLI

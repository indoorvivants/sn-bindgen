package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import java.nio.file.Files

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
    import RenderingConfig.*
    assertEquals(
      Set(
        NameFilter.Single("StructA"),
        NameFilter.Single("StructB"),
        NameFilter.Wildcard("nk_style*")
      ),
      parseExtra(
        "--render.no-constructor",
        "StructA,StructB,nk_style*"
      ).rendering.noConstructor
    )
  end `test_render.no-constructor`

  @Test def `test_render.opaque-structs`() =
    import RenderingConfig.*
    assertEquals(
      Set(
        NameFilter.Single("StructA"),
        NameFilter.Single("StructB"),
        NameFilter.Wildcard("nk_style*")
      ),
      parseExtra(
        "--render.opaque-structs",
        "StructA,StructB,nk_style*"
      ).rendering.opaqueStruct
    )
  end `test_render.opaque-structs`

  @Test def test_langs() =
    assertEquals(Lang.Scala, parseExtra("--scala").lang)
    assertEquals(Lang.C, parseExtra("--c").lang)

  @Test def test_out() =
    assertEquals(
      OutputMode.SingleFile(OutputFile("test.scala")),
      parseExtra("--out", "test.scala").outputMode
    )

    assertEquals(
      OutputMode.StdOut,
      parseRight(MINIMUM).outputMode
    )

    val tmpDir = Files.createTempDirectory("bindgen")

    tmpDir.toFile.deleteOnExit()

    assertEquals(
      OutputMode.MultiFile(OutputDirectory(tmpDir.toString)),
      parseExtra("--out", tmpDir.toString, "--multi-file").outputMode
    )
  end test_out

  @Test def test_print_files() =
    assertTrue(parseExtra("--print-files").printFiles == PrintFiles.Yes)

  @Test def test_linkName() =
    assertEquals(
      Some("mylib"),
      parseExtra("--link-name", "mylib").linkName.map(_.value)
    )

end TestCLI

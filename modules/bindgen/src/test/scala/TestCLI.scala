package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import java.nio.file.Files
import bindgen.RenderingConfig.NameFilter

class TestCLI:

  def parse(cmd: String*) = bindgen.CLI.command.parse(cmd)
  def parseRight(args: Seq[String]) =
    val arguments = args.takeWhile(_ != "--")
    val rest = args.drop(arguments.length + 1)
    bindgen.CLI.command
      .parse(arguments)
      .fold(
        h => throw new RuntimeException(h.errors.mkString(", ")),
        sp => sp.build(rest)
      )

  def parseExtra(cmd: String*) = parseRight(MINIMUM ++ cmd)

  val MINIMUM = Seq("--package", "helloworld", "--header", "test.h")

  @Test def test_minimum() =
    assertEquals("helloworld", parseRight(MINIMUM).context.packageName.value)
    assertEquals("test.h", parseRight(MINIMUM).context.headerFile.value)

  @Test def `test_render.no-constructor`() =
    import RenderingConfig.*
    assertEquals(
      Set(
        NameFilter.Single(FilterSpec("StructA")),
        NameFilter.Single(FilterSpec("StructB")),
        NameFilter.Wildcard(FilterSpec("nk_style*"))
      ),
      parseExtra(
        "--render.no-constructor",
        "StructA,StructB,nk_style*"
      ).config.rendering.noConstructor
    )
  end `test_render.no-constructor`

  @Test def `test_render.no-comments`() =
    import RenderingConfig.*
    assertEquals(
      false,
      parseExtra(
        "--render.no-comments"
      ).config.rendering.comments.value
    )
    assertEquals(
      true,
      parseExtra().config.rendering.comments.value
    )
  end `test_render.no-comments`

  @Test def `test_render.no-location`() =
    import RenderingConfig.*
    assertEquals(
      false,
      parseExtra(
        "--render.no-location"
      ).config.rendering.location.value
    )
    assertEquals(
      true,
      parseExtra().config.rendering.location.value
    )
  end `test_render.no-location`

  @Test def `test_render.opaque-structs`() =
    import RenderingConfig.*
    assertEquals(
      Set(
        NameFilter.Single(FilterSpec("StructA")),
        NameFilter.Single(FilterSpec("StructB")),
        NameFilter.Wildcard(FilterSpec("nk_style*"))
      ),
      parseExtra(
        "--render.opaque-structs",
        "StructA,StructB,nk_style*"
      ).config.rendering.opaqueStruct
    )
  end `test_render.opaque-structs`

  @Test def test_langs() =
    assertEquals(Lang.Scala, parseExtra("--scala").context.lang)
    assertEquals(Lang.C, parseExtra("--c").context.lang)

  @Test def test_out() =
    assertEquals(
      OutputMode.SingleFile(OutputFile("test.scala")),
      parseExtra("--out", "test.scala").config.outputMode
    )

    assertEquals(
      OutputMode.StdOut,
      parseRight(MINIMUM).config.outputMode
    )

    val tmpDir = Files.createTempDirectory("bindgen")

    tmpDir.toFile.deleteOnExit()

    assertEquals(
      OutputMode.MultiFile(OutputDirectory(tmpDir.toString)),
      parseExtra("--out", tmpDir.toString, "--multi-file").config.outputMode
    )
  end test_out

  @Test def test_print_files() =
    assertTrue(parseExtra("--print-files").config.printFiles == PrintFiles.Yes)

  @Test def test_externalPaths() =
    assertEquals(
      Map(
        NameFilter("*glib-2.0*") -> PackageName("glib"),
        NameFilter("test.h") -> PackageName("gobject")
      ),
      parseExtra(
        "--render.external-path",
        "*glib-2.0*=glib",
        "--render.external-path",
        "test.h=gobject"
      ).config.rendering.externalPaths
    )

  @Test def test_externalNames() =
    assertEquals(
      Map(
        NameFilter("Gtk*") -> PackageName("gtk"),
        NameFilter("G*") -> PackageName("glib")
      ),
      parseExtra(
        "--render.external-name",
        "Gtk*=gtk",
        "--render.external-name",
        "G*=glib"
      ).config.rendering.externalNames
    )

  @Test def test_clang_flags() =
    assertEquals(
      Seq("-Ibla", "-Ihello", "-x", "c++"),
      parseExtra(
        "--clang",
        "-Ihello",
        "--clang-include",
        "bla",
        "--",
        "-x",
        "c++"
      ).config.clangFlags.map(_.value)
    )

end TestCLI

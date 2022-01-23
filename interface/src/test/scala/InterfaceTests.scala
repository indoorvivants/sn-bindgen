package bindgen.interface

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.nio.file.Files
import Utils.*
import scala.util.Try
import scala.util.Success

class TestFunctions {
  private def builder = new BindingBuilder(new File(sys.env("BINARY")))

  val c_code = """
      | unsigned run(int i, float h);
      | typedef struct Hello {
      |   int bla; 
      |} Hello;
      |
      | void naughty(Hello st);
      """.stripMargin.trim

  @Test def checks_binary_path(): Unit = isolate { probe =>
    // passing a folder
    assertTrue(Try(new BindingBuilder(probe.scalaFiles)).isFailure)
    // passing a non-existent path
    assertTrue(
      Try(new BindingBuilder(probe.scalaFiles / "asdasdasd.exe")).isFailure
    )
  }

  @Test def writes_scala_file(): Unit = isolate { probe =>
    builder
      .define(headerFile, "lib_check")
      .generate(probe.scalaFiles, BindingLang.Scala)

    assertTrue(exists(probe.scalaFiles / "lib_check.scala"))
  }

  @Test def writes_c_file(): Unit = isolate { probe =>
    builder
      .define(headerFile, "lib_check")
      .generate(probe.cFiles, BindingLang.C)

    assertTrue(exists(probe.cFiles / "lib_check.c"))
  }

  @Test def checks_header_file_exists(): Unit = isolate { probe =>
    def invoke = builder
      .define(probe.cFiles / scala.util.Random.nextInt.toString, "bla")
      .generate(probe.cFiles, BindingLang.C)

    assertTrue(Try(invoke).isFailure)
  }
  @Test def checks_header_is_a_file(): Unit = isolate { probe =>
    def invoke = builder
      .define(probe.cFiles, "bla")
      .generate(probe.cFiles, BindingLang.C)

    assertTrue(Try(invoke).isFailure)
  }

  @Test def adds_c_imports(): Unit = isolate { probe =>
    builder
      .define(headerFile, "lib_check", cImports = List("my_cool_library.h"))
      .generate(probe.cFiles, BindingLang.C)

    assertEquals(
      lines(probe.cFiles / "lib_check.c")
        .filter(_.startsWith("#include"))
        .toSet,
      Set(
        "#include \"my_cool_library.h\"",
        "#include <string.h>"
      )
    )
  }

  @Test def adds_link_name(): Unit = isolate { probe =>
    builder
      .define(headerFile, "lib_check", linkName = Some("my-awesome-library"))
      .generate(probe.scalaFiles, BindingLang.Scala)

    assertEquals(
      lines(probe.scalaFiles / "lib_check.scala")
        .filter(_.contains("@link"))
        .map(_.trim),
      List("@link(\"my-awesome-library\")")
    )
  }

  @Test def adds_package_name(): Unit = isolate { probe =>
    builder
      .define(headerFile, "lib_my_awesome_library")
      .generate(probe.scalaFiles, BindingLang.Scala)

    assertEquals(
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").head,
      "package lib_my_awesome_library"
    )
  }

  @Test def adds_clang_flags(): Unit = isolate { probe =>
    // Explanation: we test a file which references our global headers file
    val customCFile = probe.cFiles / "test.h"
    fileWriter(customCFile) { fw =>
      fw.write("#include \"headers.h\"")
    }

    // without any clang flags, this file won't be found and clang will fail
    val opt = Try(
      builder
        .define(customCFile, "lib_check")
        .generate(probe.scalaFiles, BindingLang.Scala)
    )

    assertTrue(opt.isFailure)

    // if we add additional `-I` flag with correct location, it should succeed
    val optFixed = Try(
      builder
        .define(
          customCFile,
          "lib_check",
          clangFlags = List(s"-I${headerFile.getParentFile()}")
        )
        .generate(probe.scalaFiles, BindingLang.Scala)
    )

    assertEquals(Success(Seq(probe.scalaFiles / "lib_check.scala")), optFixed)
  }

  private def exists(f: File) = Files.exists(f.toPath())
  private def lines(f: File) = io.Source.fromFile(f).getLines().toList
  private case class Probe(scalaFiles: File, cFiles: File)
  private def isolate(f: Probe => Unit) = {
    f(
      Probe(
        cFiles = Files.createTempDirectory("c-files").toFile,
        scalaFiles = Files.createTempDirectory("scala-files").toFile
      )
    )
  }

  private val headerFile = {
    val dir = Files.createTempDirectory("bla").toFile
    val file = dir / "headers.h"

    fileWriter(file) { fw =>
      fw.write(c_code)
    }
    file
  }

  private def createFile(content: String, ext: String = "c") = {
    val file = File.createTempFile("test", s".$ext")

    fileWriter(file) { fw =>
      fw.write(content)
    }
    file
  }

}

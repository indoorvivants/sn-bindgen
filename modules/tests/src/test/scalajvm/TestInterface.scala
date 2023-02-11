package bindgen.interface

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.nio.file.Files
import Utils.*
import scala.util.Try
import scala.util.Success
import java.nio.file.Paths

class TestInterface {
  val plat = sys.env.get("BINDGEN_CLANG_PATH").map(Paths.get(_))

  val c_code = """
      | union Test {int x; char y;};
      | enum Bla {A, B};
      | typedef float Howdy;
      | typedef struct Hello {
      |   int bla; 
      |   Howdy yes;
      |} Hello;
      |
      | typedef Hello HelloAlias;
      |
      | unsigned run(int i, float h, HelloAlias test, union Test verify);
      | void naughty(Hello st);
      | void nice(char st);
      | enum {Constant1, Constant2};
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
    probe.builder
      .generate(
        Seq(Binding(headerFile, "lib_check")),
        probe.scalaFiles,
        BindingLang.Scala,
        plat
      )

    assertTrue(exists(probe.scalaFiles / "lib_check.scala"))
  }

  @Test def writes_c_file(): Unit = isolate { probe =>
    probe.builder
      .generate(
        Seq(Binding(headerFile, "lib_check")),
        probe.cFiles,
        BindingLang.C,
        plat
      )

    assertTrue(exists(probe.cFiles / "lib_check.c"))
  }

  @Test def checks_header_file_exists(): Unit = isolate { probe =>
    val bind = Binding(probe.cFiles / scala.util.Random.nextInt.toString, "bla")

    def invoke = probe.builder
      .generate(Seq(bind), probe.cFiles, BindingLang.C, plat)

    assertTrue(Try(invoke).isFailure)
  }
  @Test def checks_header_is_a_file(): Unit = isolate { probe =>
    val bind = Binding(probe.cFiles, "bla")
    def invoke = probe.builder
      .generate(Seq(bind), probe.cFiles, BindingLang.C, plat)

    assertTrue(Try(invoke).isFailure)
  }

  @Test def adds_c_imports(): Unit = isolate { probe =>
    val bind =
      Binding(headerFile, "lib_check", cImports = List("my_cool_library.h"))

    probe.builder
      .generate(Seq(bind), probe.cFiles, BindingLang.C, plat)

    assertEquals(
      Set(
        "#include \"my_cool_library.h\"",
        "#include <string.h>"
      ),
      lines(probe.cFiles / "lib_check.c")
        .filter(_.startsWith("#include"))
        .toSet
    )
  }

  @Test def adds_link_name(): Unit = isolate { probe =>
    val bind =
      Binding(headerFile, "lib_check", linkName = Some("my-awesome-library"))

    probe.builder
      .generate(Seq(bind), probe.scalaFiles, BindingLang.Scala, plat)

    assertEquals(
      List("@link(\"my-awesome-library\")"),
      lines(probe.scalaFiles / "lib_check.scala")
        .filter(_.contains("@link"))
        .map(_.trim)
    )
  }

  @Test def multi_file(): Unit = isolate { probe =>
    val bind =
      Binding(
        headerFile,
        "lib_check",
        linkName = Some("my-awesome-library"),
        multiFile = true
      )

    val allFiles = probe.builder
      .generate(Seq(bind), probe.scalaFiles, BindingLang.Scala, plat)

    assertTrue(exists(probe.scalaFiles / "lib_check" / "enumerations.scala"))
    assertTrue(exists(probe.scalaFiles / "lib_check" / "structs.scala"))
    assertTrue(exists(probe.scalaFiles / "lib_check" / "unions.scala"))
    assertTrue(exists(probe.scalaFiles / "lib_check" / "functions.scala"))
    assertTrue(exists(probe.scalaFiles / "lib_check" / "aliases.scala"))

  }

  @Test def print_file(): Unit = isolate { probe =>
    def bind(multi: Boolean) =
      Binding(
        headerFile,
        "lib_check",
        linkName = Some("my-awesome-library"),
        multiFile = multi
      )

    val allFilesScala = probe.builder
      .generate(Seq(bind(false)), probe.scalaFiles, BindingLang.Scala, plat)

    assertEquals(Seq(probe.scalaFiles / "lib_check.scala"), allFilesScala)

    val allFilesC = probe.builder
      .generate(Seq(bind(false)), probe.cFiles, BindingLang.C, plat)

    assertEquals(Seq(probe.cFiles / "lib_check.c"), allFilesC)

    val allFilesMultiScala = probe.builder
      .generate(Seq(bind(true)), probe.scalaFiles, BindingLang.Scala, plat)

    assertEquals(
      Set(
        probe.scalaFiles / "lib_check" / "enumerations.scala",
        probe.scalaFiles / "lib_check" / "constants.scala",
        probe.scalaFiles / "lib_check" / "aliases.scala",
        probe.scalaFiles / "lib_check" / "structs.scala",
        probe.scalaFiles / "lib_check" / "functions.scala",
        probe.scalaFiles / "lib_check" / "all.unions.scala",
        probe.scalaFiles / "lib_check" / "all.structs.scala",
        probe.scalaFiles / "lib_check" / "all.functions.scala",
        probe.scalaFiles / "lib_check" / "all.aliases.scala",
        probe.scalaFiles / "lib_check" / "all.enumerations.scala",
        probe.scalaFiles / "lib_check" / "unions.scala"
      ),
      allFilesMultiScala.toSet
    )
  }

  @Test def adds_package_name(): Unit = isolate { probe =>
    val bind =
      Binding(headerFile, "lib_my_awesome_library")
    probe.builder
      .generate(Seq(bind), probe.scalaFiles, BindingLang.Scala, plat)

    assertEquals(
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").head,
      "package lib_my_awesome_library"
    )
  }

  @Test def test_rendering_opaque_structs(): Unit = isolate { probe =>
    val customCFile = probe.cFiles / "test.h"
    fileWriter(customCFile) { fw =>
      val contents =
        """ 
        | struct Hello {int helloParam;};
        | struct World {int worldParam;};
        | struct StructA {int structAPAram;};
        | struct StructB {int structBPAram;};
        """.stripMargin
      fw.write(contents)
    }

    val binding =
      Binding(
        customCFile,
        "lib_my_awesome_library",
        opaqueStructs = Set("StructA", "StructB")
      )

    probe.builder
      .generate(Seq(binding), probe.scalaFiles, BindingLang.Scala, plat)

    // this is very crude

    assertEquals(
      Nil,
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").filter { l =>
        val line =
          l.replace(" ", "")

        line.contains("StructA=CStruct") || line.contains("StructB=CStruct")
      }
    )

    assertNotEquals(
      Nil,
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").filter { l =>
        val line =
          l.replace(" ", "")

        line.contains("StructA=CArray") || line.contains("StructB=CArray") ||
        line.contains("Hello=CStruct") || line.contains("World=CStruct")
      }
    )
  }
  @Test def test_rendering_no_constructor(): Unit = isolate { probe =>
    val customCFile = probe.cFiles / "test.h"
    fileWriter(customCFile) { fw =>
      val contents =
        """ 
        | struct Hello {int helloParam;};
        | struct World {int worldParam;};
        | struct StructA {int structAPAram;};
        | struct StructB {int structBPAram;};
        """.stripMargin
      fw.write(contents)
    }

    val binding =
      Binding(
        customCFile,
        "lib_my_awesome_library",
        noConstructor = Set("StructA", "StructB")
      )

    probe.builder
      .generate(Seq(binding), probe.scalaFiles, BindingLang.Scala, plat)

    // this is very crude

    assertEquals(
      Nil,
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").filter { l =>
        val line =
          l.replace(" ", "")
        line.contains("defapply") && (line.contains(
          "structAPAram:CInt"
        ) || line.contains("structBParam:CInt"))
      }
    )

    assertNotEquals(
      Nil,
      lines(probe.scalaFiles / "lib_my_awesome_library.scala").filter { l =>
        val line =
          l.replace(" ", "")
        line.contains("defapply") && (line.contains("helloParam:CInt") || line
          .contains("worldParam:CInt"))
      }
    )
  }

  @Test def adds_clang_flags(): Unit = isolate { probe =>
    // Explanation: we test a file which references our global headers file
    val customCFile = probe.cFiles / "test.h"
    fileWriter(customCFile) { fw =>
      fw.write("#include \"headers.h\"")
    }

    val noFlags = Binding(customCFile, "lib_check")

    // without any clang flags, this file won't be found and clang will fail
    val opt = Try(
      probe.builder
        .generate(Seq(noFlags), probe.scalaFiles, BindingLang.Scala, plat)
    )

    assertTrue(opt.isFailure)

    val withFlags =
      Binding(
        customCFile,
        "lib_check",
        clangFlags = List(s"-I${headerFile.getParentFile()}")
      )
    // if we add additional `-I` flag with correct location, it should succeed
    val optFixed = Try(
      probe.builder
        .generate(Seq(withFlags), probe.scalaFiles, BindingLang.Scala, plat)
    )

    assertEquals(Success(Seq(probe.scalaFiles / "lib_check.scala")), optFixed)
  }

  private def exists(f: File) = Files.exists(f.toPath())
  private def lines(f: File) = io.Source.fromFile(f).getLines().toList
  private case class Probe(
      scalaFiles: File,
      cFiles: File,
      builder: BindingBuilder
  )
  private def isolate(f: Probe => Unit) = {
    val logs = Vector.newBuilder[String]
    val str = (s: String) => { logs += s; () }
    val builder =
      new BindingBuilder(new File(sys.env("BINARY")), errPrintln = str)
    try {
      f(
        Probe(
          cFiles = Files.createTempDirectory("c-files").toFile,
          scalaFiles = Files.createTempDirectory("scala-files").toFile,
          builder = builder
        )
      )
    } catch {
      case scala.util.control.NonFatal(exc) =>
        logs.result().foreach(println)
        throw exc
    }
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

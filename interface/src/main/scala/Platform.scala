package bindgen.interface

import java.util.Properties
import java.io.File
import java.nio.file.Paths
import scala.sys.process.ProcessLogger
import java.nio.file.Path

object Platform {
  sealed abstract class OS(val string: String) extends Product with Serializable
  object OS {
    case object Windows extends OS("windows")
    case object MacOS extends OS("osx")
    case object Linux extends OS("linux")
    case object Unknown extends OS("unknown")
  }
  sealed abstract class Arch(val string: String)
      extends Product
      with Serializable
  object Arch {
    case object x86_64 extends Arch("x86_64")
    case object aarch64 extends Arch("aarch_64")
  }

  case class Target(os: OS, arch: Arch) {
    def string = os.string + "_" + arch.string
    def fallback = (os, arch) match {
      case (OS.MacOS, Arch.aarch64) => Some(Target(os, Arch.x86_64))
      case _                        => None
    }
  }

  case class Toolchain(
      clang: Path,
      clangPP: Path,
      llvmInclude: Path,
      llvmLib: Path,
      clangInclude: Path,
      clangVersion: String
  )

  // object Toolchain{
  //   def detectGlobal: Toolchain = {

  //   }
  // }

  object BuildInfo {
    def version: String =
      props.getProperty("sn-bindgen.version")

    private lazy val props: Properties = {
      val props = new Properties()
      val path = "sn-bindgen.properties"
      val classloader = this.getClass.getClassLoader
      Option(classloader.getResourceAsStream(path)) match {
        case Some(stream) =>
          props.load(stream)
        case None =>
          println(s"error: failed to load $path")
      }
      props
    }
  }

  lazy val clang = sys.env.get("CUSTOM_LLVM_PATH").map { p =>
    val path = Paths.get(p)
    val clang = Paths.get(p, "bin", "clang")

    val clangPP = Paths.get(p, "bin", "clang++")
    val llvmInclude = Paths.get(p, "include")
    val llvmLib = Paths.get(p, "lib")

    import scala.sys.process.Process
    val sb = new StringBuilder
    val logger = ProcessLogger.apply(str => sb.append(str + "\n"))
    val proc = Process(Seq(clang.toString(), "--version"))
      .run(logger)
      .exitValue()

    val rgx = raw"^clang version ((\d+).(\d+).(\d+)).*".r
    var version: Option[String] = None

    sb.result().linesIterator.toList.find { l =>
      val matches = rgx.findAllIn(l)
      if (matches.groupCount >= 1)
        version = Some(matches.group(1))

      matches.groupCount >= 1
    }

    assert(
      version.nonEmpty,
      s"Failed to parse clang version from the output. Lines: ${sb.result().linesIterator.toList}"
    )
    val clangVersion = version.get

    val clangInclude =
      Paths.get(p, "lib", "clang", clangVersion, "include")

    assert(clang.toFile.exists(), s"Clang binary not found ($clang)")
    assert(clangPP.toFile.exists(), s"Clang++ binary not found ($clangPP)")
    assert(
      llvmInclude.toFile.exists(),
      s"LLVM Include folder not found ($llvmInclude)"
    )
    assert(
      clangInclude.toFile.exists(),
      s"Clang Include folder not found ($clangInclude)"
    )
    assert(
      llvmLib.toFile.exists(),
      s"LLVM lib folder not found ($llvmLib)"
    )
    Toolchain(clang, clangPP, llvmInclude, llvmLib, clangInclude, clangVersion)
  } // .getOrElse(Toolchain.detectGlobal)

  lazy val os = normalise(sys.props.getOrElse("os.name", "")) match {
    case p if p.startsWith("linux")                         => OS.Linux
    case p if p.startsWith("osx") || p.startsWith("macosx") => OS.MacOS
    case _                                                  => OS.Unknown
  }

  lazy val arch = normalise(sys.props.getOrElse("os.arch", "")) match {
    case "amd64" | "x64" | "x8664" => Arch.x86_64
    case "aarch64"                 => Arch.aarch64
  }

  lazy val target = Target(os, arch)

  private def normalise(s: String) =
    s.toLowerCase(java.util.Locale.US).replaceAll("[^a-z0-9]+", "")
}

object Test extends App {

  println(Platform.target)
  println(Platform.clang)
}

package bindgen.interface

import java.util.Properties
import scala.sys.process.ProcessLogger
import java.nio.file.Path
import java.nio.file.Paths

object Platform {
  sealed abstract class OS(val string: String) extends Product with Serializable
  object OS {
    case object Windows extends OS("windows")
    case object MacOS extends OS("osx")
    case object Linux extends OS("linux")
    case object Unknown extends OS("unknown")

    val all = List(Windows, MacOS, Linux, Unknown)
  }
  sealed abstract class Arch(val string: String)
      extends Product
      with Serializable
  object Arch {
    case object x86_64 extends Arch("x86_64")
    case object aarch64 extends Arch("aarch_64")

    val all = List(x86_64, aarch64)
  }

  case class Target(os: OS, arch: Arch) {
    def string = os.string + "-" + arch.string
    def fallback = (os, arch) match {
      case (OS.MacOS, Arch.aarch64) => Some(Target(os, Arch.x86_64))
      case _                        => None
    }
  }

  case class ClangInfo(includePaths: List[String])

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

  def detectOs(osNameProp: String): OS = normalise(osNameProp) match {
    case p if p.startsWith("linux")                         => OS.Linux
    case p if p.startsWith("osx") || p.startsWith("macosx") => OS.MacOS
    case _                                                  => OS.Unknown
  }

  def detectArch(osArchProp: String): Arch = normalise(osArchProp) match {
    case "amd64" | "x64" | "x8664" => Arch.x86_64
    case "aarch64"                 => Arch.aarch64
  }

  lazy val os = detectOs(sys.props.getOrElse("os.name", ""))

  lazy val arch = detectArch(sys.props.getOrElse("os.arch", ""))

  lazy val target = Target(os, arch)
  lazy val clangInfo = ClangDetector.detect(Paths.get("clang"))

  private def normalise(s: String) =
    s.toLowerCase(java.util.Locale.US).replaceAll("[^a-z0-9]+", "")

}

object ClangDetector {

  def detect(path: Path): Platform.ClangInfo = {
    val destination =
      if (Platform.os == Platform.OS.Windows) "nul" else "/dev/null"
    val cmd = List(path.toString(), "-v", "-c", "-xc++", destination)

    val stderr = List.newBuilder[String]
    val stdout = List.newBuilder[String]

    val logger = ProcessLogger.apply(
      (o: String) => stdout += o,
      (e: String) => stderr += e
    )

    scala.sys.process.Process(cmd).run(logger).exitValue()

    Platform.ClangInfo(extractSearchPaths(stderr.result()))
  }

  def extractSearchPaths(lines: List[String]) = {
    val start1 = "#include <...> search starts here:"
    val start2 = """#include "..." search starts here:"""
    val end = "End of search list."

    var currentState: String = null

    val searchPaths = List.newBuilder[String]

    lines.foreach { str =>
      val trimmed = str.trim()
      if (trimmed.equalsIgnoreCase(start1)) currentState = start1
      else if (trimmed.equalsIgnoreCase(start2)) currentState = start2
      else if (trimmed.equalsIgnoreCase(end)) currentState = end
      else {
        if (currentState == start1 || currentState == start2)
          searchPaths += trimmed
      }
    }

    searchPaths.result()

  }
}

package bindgen.interface

import java.util.Properties
import scala.sys.process.ProcessLogger
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.LinkOption
import bindgen.interface.Platform.OS.Windows
import bindgen.interface.Platform.OS.MacOS
import bindgen.interface.Platform.OS.Linux
import bindgen.interface.Platform.OS.Unknown
import java.nio.file.Files

object Platform {
  sealed trait OS extends Product with Serializable {
    def string: String = this match {
      case Windows => "windows"
      case MacOS   => "osx"
      case Linux   => "linux"
      case Unknown => "unknown"
    }
    def coursierString: String = this match {
      case Windows => "pc-win32"
      case MacOS   => "apple-darwin"
      case Linux   => "pc-linux"
      case Unknown => "unknown"
    }
  }
  object OS {
    case object Windows extends OS
    case object MacOS extends OS
    case object Linux extends OS
    case object Unknown extends OS

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
    def string: String = os.string + "-" + arch.string
    def coursierString: String = arch.string + "-" + os.coursierString

    def fallback = (os, arch) match {
      case (OS.MacOS, Arch.aarch64) => Some(Target(os, Arch.x86_64))
      case _                        => None
    }
  }

  case class ClangInfo(
      includePaths: List[String],
      llvmInclude: List[String],
      llvmLib: List[String]
  )

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
    case p if p.startsWith("windows")                       => OS.Windows
    case p if p.startsWith("osx") || p.startsWith("macosx") => OS.MacOS
    case _                                                  => OS.Unknown
  }

  def detectArch(osArchProp: String): Arch = normalise(osArchProp) match {
    case "amd64" | "x64" | "x8664" => Arch.x86_64
    case "aarch64"                 => Arch.aarch64
  }

  def detectClangInfo(path: Path) = ClangDetector.detect(path)

  lazy val os = detectOs(sys.props.getOrElse("os.name", ""))
  lazy val arch = detectArch(sys.props.getOrElse("os.arch", ""))
  lazy val target = Target(os, arch)
  lazy val clangInfo = detectClangInfo(Paths.get("clang"))

  private def normalise(s: String) =
    s.toLowerCase(java.util.Locale.US).replaceAll("[^a-z0-9]+", "")

}

object ClangDetector {

  def detect(path: Path): Platform.ClangInfo = {
    val tempFolder = Files.createTempDirectory("sn-bindgen-clang")
    val destination = tempFolder.resolve("output.o").toString
    val tempC = Files.createTempFile(tempFolder, "test", ".c").toString()

    val cmd =
      List(path.toString(), tempC, "-v", "-c", "-xc++", "-o", destination)

    val stderr = List.newBuilder[String]
    val stdout = List.newBuilder[String]

    val logger = ProcessLogger.apply(
      (o: String) => stdout += o,
      (e: String) => stderr += e
    )

    val exitCode = scala.sys.process.Process(cmd).run(logger).exitValue()

    if (exitCode != 0) {
      stderr.result().foreach(println)
    }

    def addLLVMFolders(conf: Platform.ClangInfo) = Platform.os match {
      case MacOS =>
        conf
          .copy(
            llvmInclude = List(
              "/opt/homebrew/opt/llvm/include",
              "/usr/local/opt/llvm/include"
            ),
            llvmLib =
              List("/usr/local/opt/llvm/lib", "/opt/homebrew/opt/llvm/lib")
          )
      case Linux | Windows =>
        // <llvm-path>/bin/clang
        val realPath = path.toRealPath()
        val binFolder = realPath.getParent()
        val llvmFolder = binFolder.getParent()

        if (llvmFolder.toFile.exists())
          conf.copy(
            llvmInclude = List(llvmFolder.resolve("include").toString),
            llvmLib = List(llvmFolder.resolve("lib").toString)
          )
        else conf
      case Unknown => conf
    }

    addLLVMFolders(
      Platform.ClangInfo(
        includePaths = extractSearchPaths(stderr.result()),
        llvmInclude = Nil,
        llvmLib = Nil
      )
    )
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

    searchPaths.result().filter { s =>
      Paths.get(s).toFile().exists()
    }

  }
}

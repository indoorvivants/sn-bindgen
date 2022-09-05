package bindgen.interface

import java.util.Properties
import scala.sys.process.ProcessLogger
import java.nio.file.*
// import com.indoorvivants.detective.Platform

// object Platform {

// sealed trait OS extends Product with Serializable {
//   def string: String = this match {
//     case Windows => "windows"
//     case MacOS   => "osx"
//     case Linux   => "linux"
//     case Unknown => "unknown"
//   }
//   def coursierString: String = this match {
//     case Windows => "pc-win32"
//     case MacOS   => "apple-darwin"
//     case Linux   => "pc-linux"
//     case Unknown => "unknown"
//   }
// }
// object OS {
//   case object Windows extends OS
//   case object MacOS extends OS
//   case object Linux extends OS
//   case object Unknown extends OS

//   val all = List(Windows, MacOS, Linux, Unknown)
// }
// sealed abstract class Arch(val string: String)
//     extends Product
//     with Serializable
// object Arch {
//   case object x86_64 extends Arch("x86_64")
//   case object aarch64 extends Arch("aarch_64")

//   val all = List(x86_64, aarch64)
// }

// case class Target(os: OS, arch: Arch) {
//   def string: String = os.string + "-" + arch.string

//   def fallback = (os, arch) match {
//     case (OS.MacOS, Arch.aarch64) => Some(Target(os, Arch.x86_64))
//     case _                        => None
//   }
// }

// def detectOs(osNameProp: String): OS = normalise(osNameProp) match {
//   case p if p.startsWith("linux")                         => OS.Linux
//   case p if p.startsWith("windows")                       => OS.Windows
//   case p if p.startsWith("osx") || p.startsWith("macosx") => OS.MacOS
//   case _                                                  => OS.Unknown
// }

// def detectArch(osArchProp: String): Arch = normalise(osArchProp) match {
//   case "amd64" | "x64" | "x8664" => Arch.x86_64
//   case "aarch64"                 => Arch.aarch64
// }

// def detectClangInfo(path: Path) = ClangDetector.detect(path)

// lazy val os = detectOs(sys.props.getOrElse("os.name", ""))
// lazy val arch = detectArch(sys.props.getOrElse("os.arch", ""))
// lazy val target = Target(os, arch)
// lazy val clangInfo = detectClangInfo(Paths.get("clang"))

// private def normalise(s: String) =
//   s.toLowerCase(java.util.Locale.US).replaceAll("[^a-z0-9]+", "")

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

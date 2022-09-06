package bindgen.interface

import com.indoorvivants.detective.Platform
import Platform.*

object ArtifactNames {
  def jarString(os: Platform.OS): String = {
    import Platform.OS.*
    os match {
      case Windows => "windows"
      case MacOS   => "osx"
      case Linux   => "linux"
      case Unknown => "unknown"
    }
  }

  def jarString(bits: Platform.Bits, arch: Platform.Arch): String = {
    (bits, arch) match {
      case (Bits.x64, Arch.Intel) => "x86_64"
      case (Bits.x64, Arch.Arm)   => "aarch_64"
      case (Bits.x32, Arch.Intel) => "x86_32"
      case (Bits.x32, Arch.Arm)   => "aarch_32"
    }
  }

  def jarString(target: Platform.Target): String = {
    jarString(target.bits, target.arch) + "-" + jarString(target.os)
  }

  def coursierString(os: Platform.OS): String = {
    import Platform.OS.*
    os match {
      case Windows => "pc-win32"
      case MacOS   => "apple-darwin"
      case Linux   => "pc-linux"
      case Unknown => "unknown"
    }
  }

  def coursierString(target: Platform.Target): String = {
    jarString(target.bits, target.arch) + "-" + coursierString(target.os)
  }

}

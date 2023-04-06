package bindgen.interface

import org.junit.Assert.*
import org.junit.Test

import com.indoorvivants.detective.Platform.*

import ArtifactNames.*

class TestPlatform {

  @Test def platform_string(): Unit = {
    assertEquals(
      "x86_64-apple-darwin",
      coursierString(Target(OS.MacOS, Arch.Intel, Bits.x64))
    )
    assertEquals(
      "aarch64-apple-darwin",
      coursierString(Target(OS.MacOS, Arch.Arm, Bits.x64))
    )
    assertEquals(
      "x86_64-pc-linux",
      coursierString(Target(OS.Linux, Arch.Intel, Bits.x64))
    )
    assertEquals(
      "x86_64-pc-win32",
      coursierString(Target(OS.Windows, Arch.Intel, Bits.x64))
    )
  }

}

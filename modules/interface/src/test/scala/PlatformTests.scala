package bindgen.interface

import org.junit.Assert.*
import org.junit.Test

import Platform.*

class TestPlatform {

  @Test def platform_string(): Unit = {
    assertEquals(
      "x86_64-apple-darwin",
      Target(OS.MacOS, Arch.x86_64).coursierString
    )
    assertEquals(
      "x86_64-pc-linux",
      Target(OS.Linux, Arch.x86_64).coursierString
    )
    assertEquals(
      "x86_64-pc-win32",
      Target(OS.Windows, Arch.x86_64).coursierString
    )
  }
}

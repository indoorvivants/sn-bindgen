import org.junit.Assert.*
import org.junit.Test

import testbindings.functions.*

class MyTest {
  @Test def superComplicatedTest(): Unit = {
    assertTrue(hello(42, 0.05f))
  }
}

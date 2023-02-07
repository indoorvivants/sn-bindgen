package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import java.nio.file.Files

class TestRenderingConfig:
  @Test def test_NameFilter() =
    import RenderingConfig.NameFilter.apply as nc

    assertEquals(Some("hello"), nc("hello").matches("hello"))
    assertEquals(None, nc("hello").matches("hello1"))

    assertEquals(None, nc("hello*").matches("1hello1"))
    assertEquals(Some("hello*"), nc("hello*").matches("hello1"))
    assertEquals(
      Some("hello*world*"),
      nc("hello*world*").matches("hello1asdasdworldasdasd")
    )
  end test_NameFilter
end TestRenderingConfig

package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestDocstrings:
  import lib_test_comments.structs.*
  @Test def test_comments(): Unit =
    val hasDoc =
      docOf[HasComment].map(_.linesIterator.map(_.trim).mkString("\n"))

    val expected =
      """
    |/**
    |* hello this is a comment
    |* It's rendered correctly
    |* @a is an integer
    |*/
    """.trim.stripMargin

    assertEquals(hasDoc, Some(expected))
  end test_comments
end TestDocstrings

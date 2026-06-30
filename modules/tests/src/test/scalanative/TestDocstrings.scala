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

    assertEquals(
      hasDoc,
      Some(
        """
    |/**
    |* hello this is a comment
    |* It's rendered correctly
    |* @a is an integer
    |*/
    """.trim.stripMargin
      )
    )

    val hasTripleSlashDoc =
      docOf[HasTripleSlashComment].map(
        _.linesIterator.map(_.trim).mkString("\n")
      )

    assertEquals(
      hasTripleSlashDoc,
      Some("""
    |/**
    |* hello
    |* this is a doxygen support comment
    |*/
    """.trim.stripMargin)
    )

    val hasWeirdComment =
      docOf[HasWeirdComment].map(
        _.linesIterator.map(_.trim).mkString("\n")
      )

    assertEquals(
      hasWeirdComment,
      Some("""
    |/**
    |* hello
    |* this is a doxygen support comment
    |*/
    """.trim.stripMargin)
    )
  end test_comments
end TestDocstrings

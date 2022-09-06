package bindgen

import java.util.Properties
import java.nio.file.*
import com.indoorvivants.detective.Platform

import Platform.OS.*
import java.lang.ProcessBuilder.Redirect
import scala.sys.process.ProcessLogger

case class ClangInfo(
    includePaths: List[String]
)

object ClangDetector:

  case class ProcessResult(
      stdout: List[String],
      stderr: List[String],
      exitCode: Int,
      command: List[String]
  )

  def process(cmd: String*) =
    val stderr = List.newBuilder[String]
    val stdout = List.newBuilder[String]

    val logger = ProcessLogger.apply(
      (o: String) => stdout += o,
      (e: String) => stderr += e
    )

    val proces = new java.lang.ProcessBuilder(cmd*)
      .start()

    io.Source
      .fromInputStream(proces.getErrorStream())
      .getLines
      .foreach(logger.err(_))

    io.Source
      .fromInputStream(proces.getInputStream())
      .getLines
      .foreach(logger.out(_))

    val exitCode = proces.waitFor()

    ProcessResult(stdout.result(), stderr.result(), exitCode, cmd.toList)
  end process

  def detect(path: Path, args: String*): Either[ProcessResult, ClangInfo] =
    val tempFolder = Files.createTempDirectory("sn-bindgen-clang")
    val destination = tempFolder.resolve("output.o").toString
    val tempC = Files.createTempFile(tempFolder, "test", ".c").toString()

    val cmd =
      List(path.toString(), tempC, "-v", "-c", "-xc++", "-o", destination)

    val a @ ProcessResult(stdout, stderr, exitCode, _) = process(cmd*)

    if exitCode != 0 then Left(a)
    else
      Right(
        ClangInfo(
          includePaths = extractSearchPaths(stderr)
        )
      )
    end if
  end detect

  def extractSearchPaths(lines: List[String]) =
    val start1 = "#include <...> search starts here:"
    val start2 = """#include "..." search starts here:"""
    val end = "End of search list."

    var currentState: String = null

    val searchPaths = List.newBuilder[String]

    lines.foreach { str =>
      val trimmed = str.trim()
      if trimmed.equalsIgnoreCase(start1) then currentState = start1
      else if trimmed.equalsIgnoreCase(start2) then currentState = start2
      else if trimmed.equalsIgnoreCase(end) then currentState = end
      else if currentState == start1 || currentState == start2 then
        searchPaths += trimmed
    }

    searchPaths.result().filter { s =>
      Paths.get(s).toFile().exists()
    }
  end extractSearchPaths
end ClangDetector

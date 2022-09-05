package bindgen.interface

import java.util.Properties
import scala.sys.process.ProcessLogger
import java.nio.file.*
import com.indoorvivants.detective.Platform

import Platform.OS.*

case class ClangInfo(
    includePaths: List[String],
    llvmInclude: List[String],
    llvmLib: List[String]
)

object ClangDetector {

  def detect(path: Path): ClangInfo = {
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

    def addLLVMFolders(conf: ClangInfo) = Platform.os match {
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
      ClangInfo(
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

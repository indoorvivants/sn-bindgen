package bindgen

import SystemPathDetection.*
import java.nio.file.Paths

import scala.util.Try

import com.monovore.decline.*
import java.nio.file.Path

def clangInfo(det: SystemPathDetection)(using
    Config
): Either[BindingError, ClangInfo] =
  det match
    case No =>
      info(
        s"Proceeding without any system headers, because --no-system flag was passed"
      )
      Right(ClangInfo(Nil))

    case FromClang(path) =>
      info(
        s"Using Clang location ${path}",
        ClangDetector.process(path.value, "-v").stderr
      )
      handleDetect(Paths.get(path.value))

    case FromLLVM(path) =>
      val llvmBinPath = Paths.get(path.value)
      val clangPath = llvmBinPath.resolve("clang").toString
      info(
        s"Using LLVM bin location ${llvmBinPath}, and clang at ${clangPath}",
        ClangDetector.process(clangPath, "-v").stderr
      )
      handleDetect(Paths.get(clangPath))

    case Auto =>
      val auto = ClangDetector.process("clang", "-v")
      if auto.exitCode == 0 then
        info("Using clang available in PATH, with following info", auto.stderr)
        handleDetect(Paths.get("clang"))
      else
        error(
          "Clang detection mode is Auto, but attempting to use global clang failed",
          auto.stderr
        )
        error(
          s"If you want bindgen to proceed without system headers, please use a --no-system flag"
        )
        Left(
          BindingError.FailedToDetectSystemHeaders(
            "Failed to invoke clang from PATH"
          )
        )
      end if

private def handleDetect(path: Path)(using Config) =
  ClangDetector.detect(path, summon[Config].tempDir.value.toPath) match
    case Left(pr) =>
      val msg =
        s"Command `${pr.command.mkString(" ")}` failed with exit code ${pr.exitCode}"
      error(msg, pr.stderr ++ pr.stdout)
      Left(
        BindingError.FailedToDetectSystemHeaders(
          msg + s"stderr: ${pr.stderr}, stdout: ${pr.stdout}"
        )
      )
    case Right(r) => Right(r)

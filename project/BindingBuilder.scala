import sbt.File
import sbt.*
import sbt.io.Using
import scala.sys.process.ProcessLogger
import BindingLang.Scala
import BindingLang.C

sealed trait BindingLang extends Product with Serializable
object BindingLang {
  case object Scala extends BindingLang
  case object C extends BindingLang
}
class BindingBuilder(binary: File) {

  private val bindings = List.newBuilder[Binding]

  private case class Binding(
      headerFile: File,
      packageName: String,
      scalaFile: String,
      cFile: String,
      linkName: Option[String],
      cImports: List[String],
      clangFlags: List[String]
  ) {
    def toCommand(lang: BindingLang): String = {
      val sb = List.newBuilder[String]
      sb += s"--header $headerFile"
      sb += s"--package $packageName"
      linkName.foreach { link =>
        sb += s"--link-name $link"
      }
      cImports.foreach { cimp =>
        sb += s"--c-import $cimp"
      }
      clangFlags.foreach { clangFlag =>
        sb += s"--clang $clangFlag"
      }

      sb += " --info"
      if (lang == BindingLang.Scala)
        sb += "--scala"
      else
        sb += "--c"

      sb.result.mkString(" ")
    }
  }

  def define(
      headerFile: File,
      packageName: String,
      linkName: Option[String] = None,
      cImports: List[String] = Nil,
      clangFlags: List[String] = Nil
  ) = {
    bindings +=
      Binding(
        headerFile = headerFile,
        packageName = packageName,
        linkName = linkName,
        cFile = s"$packageName.c",
        scalaFile = s"$packageName.scala",
        cImports = cImports,
        clangFlags = clangFlags
      )

    this
  }

  def generate(to: File, lang: BindingLang) = {

    val files = Seq.newBuilder[File]

    bindings.result.foreach { binding =>
      import scala.sys.process.Process

      val destinationFilename = lang match {
        case Scala => binding.scalaFile
        case C     => binding.cFile
      }

      val destination = to / destinationFilename

      val cmd = binary.toString + " " + binding.toCommand(lang)

      System.err.println(s"Executing $cmd")

      Using.fileWriter()(destination) { wr =>
        val logger = ProcessLogger.apply(
          (o: String) => wr.write(o + "\n"),
          (e: String) => println(e)
        )

        val result = Process(cmd).run(logger).exitValue()

        if (result == 0) {
          System.out.println(
            s"Successfully regenerated binding ($lang) for ${binding.packageName}, $result"
          )

          files += destination
        } else
          throw new Exception(s"Process failed with code $result")
      }
    }
    files.result()
  }
}

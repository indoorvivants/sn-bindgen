package bindgen.interface

import java.io.*
import java.nio.file.*
import scala.util.control.NonFatal

private[interface] object Utils {
  private[interface] implicit class FileOps(private val f: File)
      extends AnyVal {
    def /(other: String): File = {
      val result = Paths.get(f.toPath.toString, other).toFile
      Files.createDirectories(f.toPath())
      result
    }
  }
  private[interface] def fileWriter(destination: File)(f: Writer => Unit) = {
    var fw: Option[BufferedWriter] = None
    try {
      fw = Option(
        new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream(destination))
        )
      )

      fw.foreach(f)
    } catch {
      case NonFatal(ex) => fw.foreach(_.close()); throw ex
    } finally {
      fw.foreach(_.close())
    }
  }
}

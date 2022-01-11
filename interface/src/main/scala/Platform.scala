package bindgen.interface

import java.util.Properties

object Platform {
  object BuildInfo {
    def version: String =
      props.getProperty("sn-bindgen.version")

    private lazy val props: Properties = {
      val props = new Properties()
      val path = "sn-bindgen.properties"
      val classloader = this.getClass.getClassLoader
      Option(classloader.getResourceAsStream(path)) match {
        case Some(stream) =>
          props.load(stream)
        case None =>
          println(s"error: failed to load $path")
      }
      props
    }
  }

  lazy val os = normalise(sys.props.getOrElse("os.name", "")) match {
    case p if p.startsWith("linux")                         => "linux"
    case p if p.startsWith("osx") || p.startsWith("macosx") => "osx"
    case _                                                  => "unknown"
  }

  lazy val arch = normalise(sys.props.getOrElse("os.arch", "")) match {
    case "amd64" | "x64" | "x8664" => "x86_64"
    case "aarch64"                 => "aarch_64"
  }

  lazy val artifactSuffix = os + "-" + arch

  def artifactSuffixFallback(suffix: String) = suffix match {
    case "osx_aarch64" => "osx_x86-64"
    case _             => suffix
  }

  private def normalise(s: String) =
    s.toLowerCase(java.util.Locale.US).replaceAll("[^a-z0-9]+", "")
}

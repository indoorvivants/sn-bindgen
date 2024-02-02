package bindgen.plugin
import java.util.Properties

import sbt.Keys.*
import sbt.nio.Keys.*
import sbt.*
import bindgen.interface.*
import scala.util.Try
import scala.scalanative.sbtplugin.ScalaNativePlugin
import sbt.internal.util.ManagedLogger
import sjsonnew.JsonFormat
import bindgen.interface.LogLevel
import bindgen.interface.Includes
import com.indoorvivants.detective.Platform
import ArtifactNames.*
import java.io.InputStream
import java.io.FileOutputStream

sealed trait BindgenMode extends Product with Serializable
object BindgenMode {
  case object ResourceGenerator extends BindgenMode
  case class Manual(scalaDir: File, cDir: File) extends BindgenMode
}

object BindgenPlugin extends AutoPlugin {
  object autoImport {
    val bindgenVersion = settingKey[String](
      s"Version of bindgen to download. Default: ${BuildInfo.version} (matches the plugin version)"
    )
    val bindgenBinary = taskKey[File](
      "Path to bindgen binary. By default it will be downloaded from Maven Central, but you can override it"
    )

    val bindgenBindings = taskKey[Seq[Binding]]("Binding definitions")

    val bindgenGenerateScalaSources =
      taskKey[Seq[File]]("Generate Scala bindings")

    val bindgenGenerateCSources =
      taskKey[Seq[File]]("Generate C glue code for the bindings")

    val bindgenGenerateAll =
      taskKey[Seq[File]]("Generate both Scala bindings and C code")

    val bindgenClangPath = taskKey[java.nio.file.Path](
      "Path to `clang` command, used to figure out the paths to standard C/C++ library." +
        "\nDefault: same as `nativeConfig` from Scala Native plugin"
    )
    val bindgenMode = settingKey[BindgenMode](
      s"Source generation mode. Default: ${BindgenMode.ResourceGenerator}"
    )
  }

  override def requires: Plugins = ScalaNativePlugin
  import ScalaNativePlugin.autoImport.nativeConfig

  import autoImport.*

  private case class Config(version: String, binary: File)

  private val resolveBinaryTask =
    Def.task {
      val res = (dependencyResolution).value

      def download(link: String, to: java.nio.file.Path, report: Int => Unit) =
        Try {
          val url = new URL(link)
          val conn = url.openConnection()
          val contentLength = conn.getContentLength()
          var is = Option.empty[InputStream]
          var out = Option(new FileOutputStream(to.toFile))
          try {
            val inputStream = conn.getInputStream()
            is = Some(inputStream)
            var downloaded = 0
            val buffer = Array.ofDim[Byte](16384)
            var length = 0

            // Looping until server finishes
            var percentage = 0
            while ({ length = inputStream.read(buffer); length } != -1) {
              // Writing data
              out.foreach(_.write(buffer, 0, length))
              downloaded += length
              val newPercentage = (downloaded * 100) / contentLength
              if (newPercentage != percentage) {
                report(newPercentage)
                percentage = newPercentage
              }

            }

            to.toFile()
          } finally {
            is.foreach(_.close())
            out.foreach(_.close())
          }

        }

      def getJars(mid: ModuleID) = {

        val depRes = (update / dependencyResolution).value
        val updc = (update / updateConfiguration).value
        val uwconfig = (update / unresolvedWarningConfiguration).value
        val modDescr = depRes.wrapDependencyInModule(mid)
        val log = (streams).value.log

        depRes
          .update(
            modDescr,
            updc,
            uwconfig,
            log
          )
          .map(_.allFiles)
          .fold(uw => throw uw.resolveException, identity)
      }

      def downloadFromMaven(platform: Platform.Target) = Try {
        getJars(
          ModuleID(
            "com.indoorvivants",
            "bindgen_native0.4_3",
            bindgenVersion.value
          ).intransitive().classifier(jarString(platform))
        ).headOption.getOrElse(
          throw new Exception("Could not download the binary for bindgen")
        )
      }

      downloadFromMaven(Platform.target)
        .orElse {
          val link =
            s"https://github.com/indoorvivants/sn-bindgen/releases/download/v${bindgenVersion.value}/sn-bindgen-${coursierString(Platform.target)}"

          val cacheDir =
            (ThisBuild / streams).value.cacheDirectory / "sn-bindgen-gh-release-binary"

          cacheDir.mkdirs()

          val path = cacheDir / s"v${bindgenVersion.value}"
          if (path.exists() && path.canExecute())
            Try(path)
          else {
            sLog.value.info(
              s"Binary wasn't found on Maven Central, attempting to download from Github releases (to ${path})"
            )

            download(
              link,
              path.toPath(), {
                var prev = 0
                i =>
                  if (i - prev >= 10) {
                    prev = i
                    sLog.value.info(s"Downloaded ${i}%")
                  }
              }
            )
          }
        }
        .map { file =>
          file.setExecutable(true)
          file
        }

    }

  override def projectSettings =
    Seq(
      bindgenVersion := BuildInfo.version,
      bindgenBindings := Seq.empty,
      bindgenMode := BindgenMode.ResourceGenerator,
      bindgenClangPath := nativeConfig.value.clang,
      bindgenBinary := resolveBinaryTask.value.get
    ) ++
      Seq(Compile, Test).flatMap(conf => inConfig(conf)(definedSettings(conf)))

  private def definedSettings(addConf: Configuration) = Seq(
    bindgenGenerateAll := {
      bindgenGenerateScalaSources.value ++ bindgenGenerateCSources.value
    },
    bindgenGenerateScalaSources := {
      val selected = (addConf / bindgenBindings).value

      val managedDestination = sourceManaged.value

      val dest = bindgenMode.value match {
        case BindgenMode.ResourceGenerator   => managedDestination
        case BindgenMode.Manual(scalaDir, _) => scalaDir
      }

      incremental(
        Config(bindgenVersion.value, bindgenBinary.value),
        (selected).distinct,
        dest,
        BindingLang.Scala,
        bindgenClangPath.value,
        streams.value
      )
    },
    bindgenGenerateCSources := {
      val selected = (addConf / bindgenBindings).value

      val managedDestination = (resourceManaged).value / "scala-native"

      val dest = bindgenMode.value match {
        case BindgenMode.ResourceGenerator => managedDestination
        case BindgenMode.Manual(_, cDir)   => cDir
      }
      incremental(
        Config(bindgenVersion.value, bindgenBinary.value),
        (selected).distinct,
        dest,
        BindingLang.C,
        bindgenClangPath.value,
        streams.value
      )
    },
    sourceGenerators ++= {
      if (bindgenMode.value.isInstanceOf[BindgenMode.Manual]) Seq.empty
      else Seq(bindgenGenerateScalaSources.taskValue)
    },
    resourceGenerators ++= {
      if (bindgenMode.value.isInstanceOf[BindgenMode.Manual]) Seq.empty
      else Seq(bindgenGenerateCSources.taskValue)
    }
  )

  implicit object LogLevelFormat extends JsonFormat[LogLevel] {
    override def write[J](x: LogLevel, builder: sjsonnew.Builder[J]): Unit =
      builder.writeString(x.str)
    override def read[J](
        jsOpt: Option[J],
        unbuilder: sjsonnew.Unbuilder[J]
    ): LogLevel =
      jsOpt match {
        case Some(js) =>
          LogLevel(unbuilder.readString(js)).getOrElse(LogLevel.Info)
        case None => LogLevel.Info
      }
  }

  private case class InternalBinding(
      headerFile: File,
      packageName: String,
      scalaFile: String,
      cFile: String,
      linkName: Option[String],
      cImports: List[String],
      clangFlags: List[String],
      logLevel: String,
      multiFile: Boolean
  )

  private object InternalBinding {
    def convert(b: Binding): InternalBinding =
      InternalBinding(
        headerFile = b.headerFile,
        packageName = b.packageName,
        scalaFile = b.scalaFile,
        cFile = b.cFile,
        linkName = b.linkName,
        cImports = b.cImports,
        clangFlags = b.clangFlags,
        logLevel = b.logLevel.str,
        multiFile = b.multiFile
      )
  }

  private def incremental(
      config: Config,
      defined: Seq[Binding],
      destination: File,
      lang: BindingLang,
      clangPath: java.nio.file.Path,
      streams: TaskStreams
  ): Seq[File] = {

    import config.*
    val logger = streams.log
    val builder = new BindingBuilder(binary)
    val cacheFile =
      streams.cacheDirectory / s"sn-bindgen"

    import sjsonnew.*
    import LList.:*:
    import BasicJsonProtocol.*

    implicit val configFormat: JsonFormat[Config] =
      caseClassArray(Config.apply _, Config.unapply _)

    case class Input(
        config: Config,
        hash: FilesInfo[HashFileInfo],
        configs: List[InternalBinding]
    )

    implicit val ibFormat: JsonFormat[InternalBinding] =
      caseClassArray(InternalBinding.apply _, InternalBinding.unapply _)

    implicit val inputFormat: JsonFormat[Input] =
      caseClassArray(Input.apply _, Input.unapply _)

    val tracker = Tracked.inputChanged[Input, Set[File]](cacheFile / "input") {
      (changed: Boolean, in: Input) =>
        Tracked.diffOutputs(cacheFile / "output", FileInfo.exists) {
          (outDiff: ChangeReport[File]) =>
            if (changed || outDiff.modified.nonEmpty) {
              builder
                .generate(defined, destination, lang, Some(clangPath))
                .toSet
            } else outDiff.checked
        }
    }

    val s: FilesInfo[HashFileInfo] =
      FileInfo.hash(defined.map(_.headerFile).toSet)

    tracker(Input(config, s, defined.map(InternalBinding.convert).toList)).toSeq
  }

  def inputs(bindings: Seq[Binding]): Seq[java.nio.file.Path] =
    bindings.map(_.headerFile.toPath)

  def outputs(
      bindings: Seq[Binding],
      destination: java.nio.file.Path,
      lang: bindgen.interface.BindingLang
  ): Seq[java.nio.file.Path] =
    bindings
      .map(bind =>
        destination.resolve {
          if (bind.multiFile && lang == BindingLang.Scala)
            bind.packageName
          else {
            if (lang == BindingLang.C) bind.cFile else bind.scalaFile
          }

        }
      )
}

package bindgen.plugin
import bindgen.interface.{LogLevel, *}
import com.indoorvivants.detective.Platform
import sbt.*
import sbt.Keys.*
import sbtcompat.PluginCompat.*
import sjsonnew.{Builder, JsonFormat, Unbuilder, deserializationError}

import java.io.{FileOutputStream, InputStream}
import java.nio.file.Paths
import scala.scalanative.sbtplugin.ScalaNativePlugin
import scala.util.Try

import ArtifactNames.*
import CacheImplicits.*

sealed trait BindgenMode extends Product with Serializable
object BindgenMode {
  case object ResourceGenerator extends BindgenMode
  case class Manual(scalaDir: File, cDir: File) extends BindgenMode
}

object BindgenPlugin extends AutoPlugin {
  import ScalaNativePlugin.autoImport.nativeConfig
  import ScalaNativePlugin.autoImport.nativeVersion

  object autoImport {
    val bindgenVersion = settingKey[String](
      s"Version of bindgen to download. Default: ${BuildInfo.version} (matches the plugin version)"
    )

    @transient
    val bindgenBinary = taskKey[FileRef](
      "Path to bindgen binary. By default it will be downloaded from Maven Central, but you can override it"
    )

    @transient
    val bindgenBindings = taskKey[Seq[Binding]]("Binding definitions")

    @transient
    val bindgenGenerateScalaSources =
      taskKey[Seq[FileRef]]("Generate Scala bindings")

    @transient
    val bindgenGenerateCSources =
      taskKey[Seq[FileRef]]("Generate C glue code for the bindings")

    @transient
    val bindgenGenerateAll =
      taskKey[Seq[FileRef]]("Generate both Scala bindings and C code")

    @transient
    val bindgenClangPath = taskKey[java.nio.file.Path](
      "Path to `clang` command, used to figure out the paths to standard C/C++ library." +
        "\nDefault: same as `nativeConfig` from Scala Native plugin"
    )
    val bindgenMode = settingKey[BindgenMode](
      s"Source generation mode. Default: ${BindgenMode.ResourceGenerator}"
    )

    val bindgenFlavour = settingKey[Flavour](
      s"Bindgen flavour. Default: ${getBindgenFlavour(nativeVersion)}"
    )

    object BindgenTags {

      /** This tag is applied to the [[bindgenGenerateScalaSources]] and
        * [[bindgenGenerateCSources]] tasks.
        */
      val Generate = Tags.Tag("bindgen-generate")
    }

  }

  private def getBindgenFlavour(ver: String) =
    if (ver.startsWith("0.5")) Flavour.ScalaNative05 else Flavour.ScalaNative04

  override def requires: Plugins = ScalaNativePlugin

  import autoImport.*

  private case class Config(version: String, binary: java.nio.file.Path)

  private val resolveBinaryTask =
    Def.task {
      implicit val conv: xsbti.FileConverter = fileConverter.value
      val res = (dependencyResolution).value

      def download(
          link: String,
          to: java.nio.file.Path,
          report: Int => Unit
      ): Try[FileRef] =
        Try {
          val url = new URI(link).toURL
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

            to.toFile().setExecutable(true)

            toFileRef(to.toFile())
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

      def downloadFromMaven(platform: Platform.Target): Try[FileRef] = Try {
        getJars(
          ModuleID(
            "com.indoorvivants",
            "bindgen_native0.5_3",
            bindgenVersion.value
          ).intransitive()
            .artifacts(
              Artifact(
                name = "bindgen_native0.5_3",
                `type` = "exe",
                extension = "exe",
                classifier = jarString(platform)
              )
            )
        ).headOption
          .map { f => f.setExecutable(true); toFileRef(f) }
          .getOrElse(
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
            Try(toFileRef(path))
          else {
            sLog.value.info(
              s"Binary wasn't found on Maven Central, attempting to download from Github releases (to ${path})"
            )

            val file = download(
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

            file

          }
        }
        .map { file =>
          file
        }

    }

  override def projectSettings =
    Seq(
      bindgenVersion := BuildInfo.version,
      bindgenBindings := Seq.empty,
      bindgenMode := BindgenMode.ResourceGenerator,
      bindgenClangPath := nativeConfig.value.clang,
      bindgenBinary := resolveBinaryTask.value.get,
      bindgenFlavour := getBindgenFlavour(nativeVersion)
    ) ++
      Seq(Compile, Test).flatMap(conf => inConfig(conf)(definedSettings(conf)))

  override def globalSettings: Seq[Setting[?]] = Seq(
    Global / concurrentRestrictions +=
      Tags.limit(BindgenTags.Generate, 1)
  )

  private def definedSettings(addConf: Configuration) = Seq(
    bindgenGenerateAll := {
      bindgenGenerateScalaSources.value ++ bindgenGenerateCSources.value
    },
    bindgenGenerateScalaSources := Def
      .task {
        val selected = (addConf / bindgenBindings).value.map { b =>
          b.flavour match {
            case None =>
              b.withFlavour(bindgenFlavour.value)
                .withBraces(scalacOptions.value.contains("-no-indent"))
            case Some(_) =>
              b.withBraces(scalacOptions.value.contains("-no-indent"))
          }
        }

        val managedDestination = sourceManaged.value

        val dest = bindgenMode.value match {
          case BindgenMode.ResourceGenerator   => managedDestination
          case BindgenMode.Manual(scalaDir, _) => scalaDir
        }

        val targetDir = crossTarget.value / "sn-bindgen"

        implicit val conv: xsbti.FileConverter = fileConverter.value

        incremental(
          Config(bindgenVersion.value, toNioPath(bindgenBinary.value)),
          (selected).distinct,
          dest,
          BindingLang.Scala,
          bindgenClangPath.value,
          streams.value,
          targetDir
        ).map(f => toFileRef(f))
      }
      .tag(BindgenTags.Generate)
      .value,
    bindgenGenerateCSources := Def
      .task {
        val selected = (addConf / bindgenBindings).value.map { b =>
          b.flavour match {
            case None    => b.withFlavour(bindgenFlavour.value)
            case Some(_) => b
          }
        }

        val managedDestination = (resourceManaged).value / "scala-native"
        val targetDir = crossTarget.value / "sn-bindgen"

        implicit val conv: xsbti.FileConverter = fileConverter.value

        val dest = bindgenMode.value match {
          case BindgenMode.ResourceGenerator => managedDestination
          case BindgenMode.Manual(_, cDir)   => cDir
        }
        incremental(
          Config(bindgenVersion.value, toNioPath(bindgenBinary.value)),
          (selected).distinct,
          dest,
          BindingLang.C,
          bindgenClangPath.value,
          streams.value,
          targetDir = targetDir
        ).map(toFileRef(_))
      }
      .tag(BindgenTags.Generate)
      .value,
    sourceGenerators ++= {
      implicit val conv: xsbti.FileConverter = fileConverter.value
      if (bindgenMode.value.isInstanceOf[BindgenMode.Manual]) Seq.empty
      else Seq(bindgenGenerateScalaSources.taskValue.map(_.map(toFile(_))))
    },
    resourceGenerators ++= {
      implicit val conv: xsbti.FileConverter = fileConverter.value
      if (bindgenMode.value.isInstanceOf[BindgenMode.Manual]) Seq.empty
      else Seq(bindgenGenerateCSources.taskValue.map(_.map(toFile(_))))
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

  /** Thrown when a JSON string does not match one of the known wire encodings.
    */
  final class DeserializationError(
      val value: String,
      val expected: Set[String],
      message: String
  ) extends RuntimeException(message)

  object DeserializationError {
    def apply(value: String, expected: Set[String]): Nothing = {
      val msg =
        s"invalid value '$value', expected one of: ${expected.toSeq.sorted.mkString(", ")}"
      throw new DeserializationError(value, expected, msg)
    }
  }

  private implicit val configFormat: JsonFormat[Config] =
    new JsonFormat[Config] {
      override def write[J](obj: Config, builder: Builder[J]): Unit = {
        builder.beginObject()
        builder.addField("version", obj.version)
        builder.addField("binary", obj.binary)
        builder.endObject()
      }

      override def read[J](
          jsOpt: Option[J],
          unbuilder: Unbuilder[J]
      ): Config = {
        val js = jsOpt.getOrElse(
          deserializationError("Expected JSON object when reading Config")
        )
        unbuilder.beginObject(js)
        try
          Config(
            unbuilder.readField[String]("version"),
            Paths.get(unbuilder.readField[String]("binary"))
          )
        finally unbuilder.endObject()
      }
    }

  private def incremental(
      config: Config,
      defined: Seq[Binding],
      destination: File,
      lang: BindingLang,
      clangPath: java.nio.file.Path,
      streams: TaskStreams,
      targetDir: File
  ): Seq[File] = {

    import config.*
    val logger = streams.log
    val builder = new BindingBuilder(binary.toFile)
    val cacheFile =
      streams.cacheDirectory / s"sn-bindgen"

    import sjsonnew.*
    import BasicJsonProtocol.*

    case class Input(
        config: Config,
        hash: FilesInfo[HashFileInfo],
        configs: List[InternalBinding]
    )

    implicit val ibFormat: JsonFormat[InternalBinding] =
      new JsonFormat[InternalBinding] {
        override def write[J](obj: InternalBinding, builder: Builder[J]): Unit =
          ???
        override def read[J](
            jsOpt: Option[J],
            unbuilder: Unbuilder[J]
        ): InternalBinding = ???
      }

    implicit val inputFormat: JsonFormat[Input] =
      new JsonFormat[Input] {
        override def write[J](obj: Input, builder: Builder[J]): Unit = ???
        override def read[J](jsOpt: Option[J], unbuilder: Unbuilder[J]): Input =
          ???
      }
    // caseClassArray(Input.apply _, Input.unapply _)

    val tracker = Tracked.inputChanged[Input, Set[File]](cacheFile / "input") {
      (changed: Boolean, in: Input) =>
        Tracked.diffOutputs(cacheFile / "output", FileInfo.exists) {
          (outDiff: ChangeReport[File]) =>
            if (changed || outDiff.modified.nonEmpty) {
              builder
                .generate(
                  defined,
                  destination,
                  lang,
                  Some(clangPath)
                )
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

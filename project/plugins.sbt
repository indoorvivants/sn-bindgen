resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.17")

addSbtPlugin("com.indoorvivants" % "sbt-commandmatrix" % "0.0.5")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.12")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")

addSbtPlugin(
  "com.indoorvivants" % "subatomic-plugin" % "0.0.7+185-edd8bd34-SNAPSHOT"
)

addSbtPlugin(
  "com.indoorvivants" % "bindgen-sbt-plugin" % "0.0.24"
)

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")

addSbtPlugin("org.jmotor.sbt" % "sbt-dependency-updates" % "1.2.7")

addSbtPlugin("com.github.reibitto" % "sbt-welcome" % "0.4.0")

libraryDependencies += "com.indoorvivants.detective" %% "platform" % "0.0.2"

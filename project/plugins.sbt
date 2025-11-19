resolvers += Resolver.sonatypeCentralSnapshots

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.8")

addSbtPlugin("com.indoorvivants" % "sbt-commandmatrix" % "0.0.5")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.11.2")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.6")

addSbtPlugin(
  "com.indoorvivants" % "subatomic-plugin" % "0.0.9+45-2c519f79-SNAPSHOT"
)

addSbtPlugin(
  "com.indoorvivants" % "bindgen-sbt-plugin" % "0.2.3"
)

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.13.1")

addSbtPlugin("org.jmotor.sbt" % "sbt-dependency-updates" % "1.2.9")

addSbtPlugin("com.github.reibitto" % "sbt-welcome" % "0.5.0")

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.14.3")

libraryDependencies += "com.indoorvivants.detective" %% "platform" % "0.1.0"

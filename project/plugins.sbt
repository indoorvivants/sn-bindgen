resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.9")
addSbtPlugin("com.indoorvivants" % "sbt-commandmatrix" % "0.0.5")
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.11")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
addSbtPlugin(
  "com.indoorvivants" % "subatomic-plugin" % "0.0.7"
)
addSbtPlugin(
  "com.indoorvivants" % "bindgen-sbt-plugin" % "0.0.13+20-4fe7511c-SNAPSHOT"
)
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")
addSbtPlugin("org.jmotor.sbt" % "sbt-dependency-updates" % "1.2.7")

libraryDependencies += "com.indoorvivants.detective" %% "platform" % "0.0.2"

import scala.collection.Seq

homepage in ThisBuild := Some(url("https://github.com/slamdata/fs2-ssh"))

scmInfo in ThisBuild := Some(ScmInfo(
  url("https://github.com/slamdata/fs2-ssh"),
  "scm:git@github.com:slamdata/fs2-ssh.git"))

// Include to also publish a project's tests
lazy val publishTestsSettings = Seq(
  publishArtifact in (Test, packageBin) := true)

lazy val root = project
  .in(file("."))
  .settings(noPublishSettings)
  .aggregate(core)
  .enablePlugins(AutomateHeaderPlugin)

lazy val core = project
  .in(file("core"))
  .settings(name := "fs2-ssh")
  .settings(
    libraryDependencies ++= Seq(
      "com.hierynomus" % "sshj" % "0.27.0",

      "org.typelevel" %% "cats-effect" % "1.4.0",
      "co.fs2"        %% "fs2-io"      % "1.0.5"),

    performMavenCentralSync := false,
    publishAsOSSProject := true)
  .enablePlugins(AutomateHeaderPlugin)
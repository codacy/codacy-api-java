import codacy.CodacySbt.autoImport._

name := "codacy-api-java"

crossPaths := false

autoScalaLibrary := false

description := "Codacy Java API wrapper"

scmInfo := Some(
  ScmInfo(url("https://github.com/codacy/codacy-api-java"), "scm:git:git@github.com:codacy/codacy-api-java.git")
)

// this setting is not picked up properly from the plugin
pgpPassphrase := Option(System.getenv("SONATYPE_GPG_PASSPHRASE")).map(_.toCharArray)

resolvers ~= { _.filterNot(_.name.toLowerCase.contains("codacy")) }

libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.4",
  "com.google.code.gson" % "gson" % "2.3.1",
  "commons-io" % "commons-io" % "2.4",
  "junit" % "junit" % "4.11" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

fork in Test := true
cancelable in Global := true

publicMvnPublish

jacocoReportSettings := JacocoReportSettings(
  "Jacoco Coverage Report",
  None,
  JacocoThresholds(),
  Seq(JacocoReportFormats.ScalaHTML, JacocoReportFormats.XML),
  "utf-8"
)


sbtPlugin := true

name := "sbt-satisfy"

scalaVersion := "2.10.3"

organization := "com.tagged.satisfaction"

version := "0.15"

val hadoopVersion = "2.3.0"

libraryDependencies ++= Seq(
  ("org.apache.hadoop" % "hadoop-common" % hadoopVersion),
  ("org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion)
)

publishMavenStyle := true

isSnapshot := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")



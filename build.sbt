name := "jmh-scala"

organization := "com.microWorkflow"

version := "0.0.1"

scalaVersion := "2.11.6"

jmhSettings

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test" withSources() withJavadoc()
)

initialCommands := "import com.microWorkflow.jmh-scala._"


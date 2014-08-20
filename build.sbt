import AssemblyKeys._


name := "calab-example"

version := "0.1"

scalaVersion := "2.11.2"

scalacOptions ++= Seq( "-deprecation", "-feature", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

incOptions := incOptions.value.withNameHashing( true )

organization := "ca.hyperreal"

resolvers += "Hyperreal Repository" at "http://hyperreal.ca/maven2"

libraryDependencies ++= Seq(
	"ca.hyperreal" %% "calab" % "0.1",
	"ca.hyperreal" %% "color" % "0.1"
	)

mainClass in (Compile, run) := Some( "ca.hyperreal.calab.Main" )

assemblySettings

mainClass in assembly := Some( "ca.hyperreal.calab.Main" )

jarName in assembly := "calab.jar"
import AssemblyKeys._

import LaikaKeys._


name := "calab-example"

version := "0.1"

scalaVersion := "2.11.2"

scalacOptions ++= Seq( "-deprecation", "-feature", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

incOptions := incOptions.value.withNameHashing( true )

organization := "ca.hyperreal"

//resolvers += Resolver.sonatypeRepo( "snapshots" )

resolvers += "Hyperreal Repository" at "http://hyperreal.ca/maven2"

mainClass in (Compile, run) := Some( "ca.hyperreal.calab.Main" )

assemblySettings

mainClass in assembly := Some( "ca.hyperreal.myproject.Main" )

jarName in assembly := "funl.jar"


LaikaPlugin.defaults

templateDirectives in Laika += LaikaExtension.bootstrapToc


publishMavenStyle := true

publishTo := Some( Resolver.sftp( "private", "hyperreal.ca", "/var/www/hyperreal.ca/maven2" ) )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("GPL" -> url("http://opensource.org/licenses/GPL"))

homepage := Some(url("https://github.com/edadma/color"))

pomExtra := (
  <scm>
    <url>git@github.com:edadma/color.git</url>
    <connection>scm:git:git@github.com:edadma/color.git</connection>
  </scm>
  <developers>
    <developer>
      <id>edadma</id>
      <name>Edward A. Maxedon, Sr.</name>
      <url>http://hyperreal.ca</url>
    </developer>
  </developers>)

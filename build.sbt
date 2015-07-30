

import AssemblyKeys._
import com.github.bigtoast.sbtthrift.ThriftPlugin

assemblySettings

jarName in assembly := "ColumnarSpark.jar"

name := "ColumnarSpark"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	  // spark deps: mark 'provided' if distributing to clusters
	  "org.apache.spark" 		%% 	"spark-core"		 % 	"1.4.1" 		% 	"provided",
	  "org.apache.hadoop"		%	"hadoop-client"		%	"2.7.1" 		% 	"provided"
	  	excludeAll(
			ExclusionRule(organization = "org.jboss.netty"),
			ExclusionRule(organization = "io.netty"),
			ExclusionRule(organization = "org.eclipse.jetty"),
			ExclusionRule(organization = "org.mortbay.jetty"),
			ExclusionRule(organization = "org.ow2.asm"),
			ExclusionRule(organization = "asm")
	 	 ),
	  "com.typesafe.akka"		%%	"akka-slf4j"		%	"2.4-M2",
	  "org.apache.thrift" 		% 	"libthrift"		%	"0.9.2",
	  "com.twitter" 			%	"parquet-thrift"		%	"1.6.0"
)

resolvers ++= Seq(
	"Akka Repository" at "http://repo.akka.io/releases/",
	"Twitter" at "http://maven.twttr.com/",
	"bigtoast-github" at "http://bigtoast.github.com/repo/"
)

seq(ThriftPlugin.thriftSettings: _*)

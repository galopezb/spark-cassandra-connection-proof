Spark Cassandra Connection Proof
================================

A small proof of concept using [spark-cassandra-connector](https://github.com/datastax/spark-cassandra-connector).  

Prerequisites
-------------

* [sbt 0.13](http://www.scala-sbt.org/download.html)
* [Scala 2.11.7] (http://www.scala-lang.org/)
* [Scala IDE for Eclipse](http://scala-ide.org/)
* [sbteclipse](https://github.com/typesafehub/sbteclipse)
* [Maven 3.0.5](https://maven.apache.org/download.cgi) or later
* [Spark 1.5.2](http://spark.apache.org/)
* [Cassandra 2.2.4](http://cassandra.apache.org/download/)

Step by step Development
------------------------

#### Configure Apache Spark

- [Download apache spark 1.5.2](http://spark.apache.org/downloads.html)
- [Build spark with sbt](http://spark.apache.org/docs/latest/building-spark.html#building-with-sbt)

#### Configure Apache Cassandra

- [Download apache cassandra 2.2.4](http://cassandra.apache.org/download/)
- Uncompress cassandra. `tar xvf apache-cassandra-2.2.4-bin.tar.gz`
- Move cassandra to home path. `mv apache-cassandra-2.2.4-bin ~/cassandra`
- Start cassandra. `sudo ~/cassandra/bin/cassandra -f`

#### Create new Scala Project in Eclipse.

- [Add plugin for sbt to create Eclipse project definitions](https://github.com/typesafehub/sbteclipse)
- `cd path-to-project`  
- Start sbt session. `sbt`
- `eclipse`
- Create `build.sbt` file in root of project.  
- Create Scala Object named `SparkCassandra.scala`
- `compile`

Usage
-----

- Open the interactive command line interface for Cassandra.  
`~/cassandra/bin/cqlsh`  
- Create keyspace.  
`CREATE KEYSPACE spark_test_key WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };`  
- `USE spark_test_key;`  
- Create table.  
`CREATE TABLE table_test (value int PRIMARY KEY);`
- `cd path-to-project`  
- Start sbt session. `sbt`  
- Run program. `run`
- Finally get an RDD of type Row with which can do transformations and actions.

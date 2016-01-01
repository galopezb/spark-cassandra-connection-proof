import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.datastax.spark.connector._

object SparkCassandra extends App {        
  val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "localhost").setAppName("SparkCassandraApp").setMaster("local[*]")
      .set("spark.cassandra.connection.port", "9042")
  val sc = new SparkContext(conf)
  val table_test_rdd = sc.cassandraTable("spark_test_key", "table_test")
  println(table_test_rdd)
  sc.stop
}

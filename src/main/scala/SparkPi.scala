import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/** Computes an approximation to pi */
object SparkPi {
  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir", "D:\\app\\hadoop-2.7.7")
    val conf = new SparkConf().setAppName("demo").setMaster("local");
    conf.set("spark.testing.memory", "2147480000")//后面的值大于512m即可

    val sc = new SparkContext(conf);

    val rdd = sc.parallelize(List(1, 2, 3, 4, 5));

    val rdd2: RDD[Int] = rdd.map(_ * 2);

    print(rdd2.collect().toBuffer);


  }
}

package com.tej.tutorial

import org.apache.spark.sql.SparkSession
;

object WordCount {
  def main(args: Array[String]) {


    if (args.size < 2)
      println("Usage : com.tantra.WordCount hdfs:///user/mageswarand/blogs/ hdfs:///user/mageswarand/blogs_out/")
//      System.exit(-1)

    val in = args(0)
    val out = args(1)

    println("Input path: ", in)
    println("Output path: ", out)

    val spark = SparkSession.builder.getOrCreate()
    val sc = spark.sparkContext

    val lines = sc.wholeTextFiles(in)

//    lines.take(10).foreach(println)


    val words = lines.flatMap { case (fileName, data) => data.split(",") }

    val wc = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
    wc.saveAsTextFile(out)

//    wc.collect().foreach(println)
  }
}

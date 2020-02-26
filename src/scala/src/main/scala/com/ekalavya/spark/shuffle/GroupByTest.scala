package com.tej.tutorial.shuffle

import java.util.Random

import org.apache.spark.sql.SparkSession


object GroupByTest {


  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("GroupBy Test").getOrCreate()

    val sc = spark.sparkContext

    var numMappers = if (args.length > 0) args(0).toInt else 100
    var numKVPairs = if (args.length > 1) args(1).toInt else 10000
    var valSize = if (args.length > 2) args(2).toInt else 1000
    var numReducers = if (args.length > 3) args(3).toInt else 36

    /**
      * Job 1 with 1 stage
      * >>  numMappers tasks
      * >> Each task performs flatMap generated FlatMappedRDD
      * >> Refer : JobRDD.png and PhysicalView.png
      */
    val pairs1 = sc.parallelize(0 until numMappers, numMappers)
      .flatMap{ p =>
        val ranGen = new Random
        var arr1 = new Array[(Int, Array[Byte])](numKVPairs)
        for (i <- 0 until numKVPairs) {
          val byteArr = new Array[Byte](valSize)
          ranGen.nextBytes(byteArr)
          arr1(i) = (ranGen.nextInt(Int.MaxValue), byteArr) // (Random Int Key, valSize bytes)
        }
        arr1
        // Size(arr1) = numKVPairs * (4 + valSize) = 10000 * (4 + 1000) = 9.5 MB (~10 MB)
      } // so that Size(pairs1) = numMappers * Size(arr1) ＝ 100 * 9.5 = 950 MB (~1000 MB)
      .cache()

    // Enforce that everything has been calculated and in cache
    // First counts the number of records in each parition and then all partitions are summed up
    val count1 = pairs1.count() // numMappers * numKVPairs = 100 * 10000 = 1,000,000

    /**
      * Job 2 with 2 Stages
      * >> Stage 0 contains 100 ShuffleMapTask, each task reads a partition of paris1 from the cache, repartitions it,
      *   and then write the repartitioned results into local disk.
      * >> Stage 1 contains 36 ResultTasks. Each task fetches and shuffles the data that it needs to process.
      * It fetches the data, aggregates the data, and performes mapPartitions() operation in a pipeline style.
      * Finally, count() is applied to get the result.
      */

    // numMappers * numKVPairs / numReducer ＝ (100 * 10000) / 36 = 27,777
    val count2 = pairs1.groupByKey(numReducers).count()

    println("Count 1 : ", count1)
    println("Count 2 : ", count2)

    println("pairs1 toDebugString :", pairs1.toDebugString)
    println("pairs1.groupByKey(numReducers) toDebugString : ", pairs1.groupByKey(numReducers).toDebugString)

    sc.stop()

  }
}

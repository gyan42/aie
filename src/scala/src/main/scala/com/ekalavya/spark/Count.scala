//package com.tej.tutorial;
//
//object Count {
//  def main(args: Array[String]) {
//    val inputFile = "/home/nishantdas/Desktop/SparkProg/file1.txt"
//    val outputFile = "/home/nishantdas/Desktop/"
//    val conf = new SparkConf().setAppName("Count").setMaster("local")
//    val sc = new SparkContext(conf)
//    val lines = sc.textFile(inputFile)
//    val words = lines.flatMap(line => line.split(" "))
//    val wc = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
//    wc.saveAsTextFile(outputFile)
//  }
//}

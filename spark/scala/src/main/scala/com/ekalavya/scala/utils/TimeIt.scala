package com.ekalavya.scala.utils

object TimeIt {

  def measure[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def measure10Runs[R](block: => R) = {

    def print_result(s: String, ns: Long): Unit = {
      val formatter = java.text.NumberFormat.getIntegerInstance
      println("%-16s".format(s) + formatter.format(ns) + " ns")
    }

    var t0 = System.nanoTime()
    var result = block    // call-by-name
    var t1 = System.nanoTime()

    print_result("First Run", (t1 - t0))

    var lst = for (i <- 1 to 10) yield {
      t0 = System.nanoTime()
      result = block    // call-by-name
      t1 = System.nanoTime()
      print_result("Run #" + i, (t1 - t0))
      (t1 - t0).toLong
    }

    print_result("Max", lst.max)
    print_result("Min", lst.min)
    print_result("Avg", (lst.sum / lst.length))
  }

  def main(args: Array[String]): Unit = {
    // Now wrap your method calls, for example change this...
    val result0 = 1 to 1000 sum

    // ... into this
    val result = measure { 1 to 1000 sum }
  }
}




// In file ChecksumAccumulator.scala
class ChecksumAccumulator {
  private var sum = 0
  //where is the constructor?
  //Put a print statement here, and see what happens?
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

val a = new ChecksumAccumulator
a.add(10)
a.checksum()


// In file ChecksumAccumulator.scala
import scala.collection.mutable

object ChecksumAccumulator {

  private val cache = mutable.Map.empty[String, Int]
  //Mutable Map i.e you can

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

//No constructor params
//No `new` keyword is used, like Java static class
ChecksumAccumulator.calculate("Every value is an object.")

ChecksumAccumulator.calculate("Every value is an object.")


//TODO how to put this in a Scala file, compile and run it?
//1. The class / runnable should take a command line arg and print its checksum
//Read about App trait

//References https://booksites.artima.com/programming_in_scala_3ed/examples/html/ch04.html
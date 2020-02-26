import java.util.Random

var numMappers = 2
var numKVPairs = 10
var valSize = 100
var numReducers = 4

def mapper(value: Int): Array[(Int, Array[Byte])] = {
  val ranGen = new Random
  var arr1 = new Array[(Int, Array[Byte])](numKVPairs)
  for (i <- 0 until numKVPairs) {
    val byteArr = new Array[Byte](valSize)
    ranGen.nextBytes(byteArr)
    arr1(i) = (ranGen.nextInt(Int.MaxValue), byteArr)
  }
  arr1
}

val res = mapper(1)
res.size
res(0)._1
res(0)._2.size
res(1)

(100.0 * 10000) / 36

((10000.0 * (4 + 1000))/1024)/1024.0

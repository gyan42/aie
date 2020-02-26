
import scala.io.Source

/**
 * Created by mageswaran on 31/10/15.
 *
 * Why only Spark can do the word cant? after all it is written in Scala right?
 */


val fileBuffer = Source.fromFile("/etc/apt/sources.list")
//Remember only once the contents are streamed!
var lines = fileBuffer.getLines()

println("---------------------------------------------------")

var splitLinesToStrings = lines.flatMap(_.split(" ")) //doesn't work
//Lets see the class
lines.getClass
splitLinesToStrings.map(_.split(" ")) // even this didn't work

println("---------------------------------------------------")

//oh wait
val fileBuffer1 = Source.fromFile("/etc/apt/sources.list")

val linesVer1 = fileBuffer1.getLines().toList
linesVer1.getClass
var strings = linesVer1.flatMap(_.split(" "))
strings.foreach(print)

println("---------------------------------------------------")

val wordNumberTuple = strings.map(string => (string, 1))
//val reducedWordCount = wordCountMap.reduce() // oh no this is not Spark

println("---------------------------------------------------")

//Create a HashMap i.e (key, value) pair
val wordCount = scala.collection.mutable.HashMap[String, Int]().withDefaultValue(0)

//strings.map(string => wordCount(string) += 1)
strings.foreach(string => wordCount(string) += 1)
wordCount.foreach(println)

println("---------------------------------------------------")

val wordCountInintValue = Map[String, Int]().withDefaultValue(0)

//More functional way i.e confusing way
val wordCountVer1= strings.foldLeft(wordCountInintValue){(currentCounts, word) =>
  currentCounts.updated(word, currentCounts(word) + 1)}

wordCountVer1

println("---------------------------------------------------")

fileBuffer.close()
fileBuffer1.close()

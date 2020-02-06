//References : https://booksites.artima.com/programming_in_scala_3ed/examples/html/ch03.html
val big = new java.math.BigInteger("12345")

//-----------------------------------------------

val greetStrings = new Array[String](3)
//greetStrings is immutable but not its contents!
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for (i <- 0 to 2)
  print(greetStrings(i))

//wait why i see no []

greetStrings.update(0, "Hello")
greetStrings.update(1, ", ")
greetStrings.update(2, "world!\n")

for (i <- 0.to(2))
  print(greetStrings.apply(i))

//huh is there any easy way to declare?

val numNames = Array("zero", "one", "two")

val numNames2 = Array.apply("zero", "one", "two")

//------------------------------------------------

//Lists
val oneTwoThree = List(1, 2, 3)
val oneTwo = List(1, 2)
val threeFour = List(3, 4)



val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

val twoThree = List(2, 3)
val oneTwoThree1 = 1 :: twoThree

println(oneTwoThree1)


val oneTwoThree2 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree2)

//But wait why Nil?
//1,2,3 are integers and dont have support for List operations
//Nil is empty List

Nil.::(3).::(2).::(1)


//Tuples

val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

//Why _N notation? Tuples are basically collection of different types

//Maps n sets

var jetSet = Set("Boeing", "Airbus")
println(jetSet += "Lear") //jetSet = jetSet + "Lear"
println(jetSet.contains("Cessna"))
println(jetSet)

import scala.collection.mutable

val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

import scala.collection.immutable.HashSet

val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")

//-------------------------------------------------

import scala.collection.mutable

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))

//wait you said 1 is Int type? from where Int got -> ?
//Implicit Conversions!

//--------------------------------------------------

val args = Array("1", "2", "3")

def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}

printArgs(args = args)


def printArgs1(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

printArgs1(args = args)

def printArgs2(args: Array[String]): Unit = {
  args.foreach(println)
}

printArgs2(args = args)


def formatArgs(args: Array[String]) = args.mkString("\n")
println(formatArgs(args))

val res = formatArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo")
//-------------------------------------------------

//Read lines from a file

import scala.io.Source

if (args.length > 0) {

  for (line <- Source.fromFile("/etc/apt/sources.list").getLines())
    println(line.length + " " + line)
}
else
  Console.err.println("Please enter filename")

//TODO
//1. Find length of each line
//2. Max length of the lines
//3. Find the longes line and print it
//4. Pad all the lines to same length

//Functional Programming

//Functions vs Methods (class functions)

import scala.io.Source

object LongLines {

  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  private def processLine(filename: String,
                          width: Int, line: String) = {

    if (line.length > width)
      println(filename + ": " + line.trim)
  }
}

LongLines.processFile("/etc/apt/sources.list", 70)

//Lets see how to use Scala's method's first class citizen power

import scala.io.Source

object LongLines1 { //package it so that we wont pollute the namespace

  def processFile(filename: String, width: Int) = {

    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }
}

LongLines1.processFile("/etc/apt/sources.list", 70)

//Function literals
var increase = (x: Int) => x + 1
//Int => Int
increase(10)

increase = (x: Int) => x + 9999

increase(10)

increase = (x: Int) => {
  println("We")
  println("are")
  println("here!")
  x + 1
} //note for multiple lines include use curly braces

increase(10)


val someNumbers = List(-11, -10, -5, 0, 5, 10)

//def printc(x: Int) => println(x)

someNumbers.foreach((x: Int) => println(x))

someNumbers.filter((x: Int) => x > 0)

someNumbers.map((x) => increase(x))
someNumbers.map(x => increase(x))
someNumbers.map(increase)

//place holders
someNumbers.filter(_ > 0)
val f = (_: Int) + (_: Int)
//compiler do need some info to infer
f(5,10)

//Partially Applied Function
def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)

val a = sum _ //a: (Int, Int, Int) => Int = <function3>
//note '_' is important or error will be raised
//To avoid situations like this, Scala normally requires you to specify function arguments that are left out
//  explicitly, even if the indication is as simple as a `_'. Scala allows you to leave off even the _ only when
//a function type is expected.
a(1, 2, 3)
a.apply(1, 2, 3)

val b = sum(1, _: Int, 3)
b(2)

//Closures, very important while dealing with Spark
var more = 1 //free variables
val addMore = (x: Int) => x + more //open term since `more ` is used
addMore(10)

val someNumbers1 = List(-11, -10, -5, 0, 5, 10)
var summ = 0
someNumbers.foreach(summ +=  _)
someNumbers.sum

def makeIncreaser(more: Int): Int => Int = (x: Int) => x + more

//what if a closure uses a local variable of some function, and the function is invoked many
//times?
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10)
inc9999(10)

//Function Call forms
//Scala supports repeated parameters,
// named arguments, and default arguments.

//Repeated parameters a.k.a variable length params
def echo(args: String*) =
    for (arg <- args) println(arg)

echo()
echo("one")
echo("hello", "world!")

//ok cool, looks like I can pass Array
val arr = Array("What's", "up", "doc?")
//echo(arr)

echo(arr: _*)

//Named arguments & Default Paramteres values
def speed(distance: Float, time: Float = 1): Float =
  distance / time

speed(100)

speed(100, 10)

speed(time = 10, distance = 100)


//Tail Recursive: The Scala compiler detects tail recursion and replaces it with
//a jump back to the beginning of the function, after updating the function parameters with the new
//values.



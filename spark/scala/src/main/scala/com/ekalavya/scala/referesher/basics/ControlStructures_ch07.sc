//If expressions

val a = 6
val b = 10

println(if (a > b) a else b)
//returns the result no need of temp variable

//For Expression
val filesHere = (new java.io.File(".")).listFiles

//List down all the files and folders
for (file <- filesHere)
  println(file)

//List down files and folders that ends with 's'
for (file <- filesHere if file.getName.endsWith("s"))
  println(file)

//List down files that ends with 's'
for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith("s")
) println(file)

//Lets write ourn own grep function

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for {
    file <- filesHere
    if file.isFile
//    if file.getName.endsWith(".s")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file + ": " + trimmed)

//grep("h")
//Not working? TODO fix it


//Get list of files that ens with s
def files =
  for {
    file <- filesHere
    if file.isFile
    if file.getName.endsWith("s")
  } yield file

println(files)
println(files.toList)

//Title: for (sequence and/or filter) yield expression
/*
Syntax:
=======
for (
variableName <- someCollections
) yield variableName

for {
variableName <- someCollections
variableName1 <- someCollections someConditions
someConditions
}

for clause yield body

 */

//10 included
0 to 10
//10 excluded
0 until 10

for (
  i <- 0 to 9
) yield i

for {
  i <- 0 to 9
  j <- 0 to 9
} yield (i,j)
//What you see? nested loop!

for {
  i <- 0 to 9
  j <- 0 to 9
  if (i == j)
} yield (i,j)

for (
  i <- 0 to 9 if((i % 2) == 0)
) yield i


for {
  element <- List(1,2,3,4,5)
} yield "T"+element

val c = for {
  word <- Array("Hello", "Scala") //temp variable
  char <- word //new varaible declaration
} yield char.toUpper

for {
  word <- Seq("Hello", "Scala")
  char <- word if char.isUpper
} yield char

val list = List(1,2,3,4,5,6,7,8,9,10)

val even = for(element <- list if element%2 == 0; if element > 5)  yield element
println(even.toList)

//------------------------------------------
//exception handling
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
  val f = new FileReader("input.txt")
  // Use and close file
} catch {
  case ex: FileNotFoundException => "FileNotFoundException"
  case ex: IOException => "IOException"
}
//Note it returns value

//val res = try { 12 / 0 } finally 0
//huh thats a mess, then?


//Title: Pattern matching

import java.util.Random

def printNumbers(number: Int) = number match {
  case 1 => println("Number one!")
  case 2 => println("Number two!")
  case 3 => println("Number three!")
}

printNumbers(1)


case class Person1(name: String, age: Int)

val p = Person1("Aja", 1) //Person1.apply("Aja", 1) ==> new Person1("Aja", 1)
val p1 = Person1("Mageswaran", 27)

def validate(p: Person1) = p match {
  case Person1("Aja", 1) => println("Allowed here!") //Extractors, which helps in retreiving the values from the object
  case _ => println("Sorry!")
}

validate(p)
validate(p1)

println("---------------------------------------------------")

val randNumber = new Random().nextInt(10)
randNumber match {
  case 7 => println("Wow we are lucky!")
  case otherNumber => otherNumber
}

println("---------------------------------------------------")

val willWork = List(1, 3, 23, 90)
val willNotWork = List(4, 18, 52)
val empty = List()
for (l <- List(willWork, willNotWork, empty)) {
  l match {
    case List(_, 3, _, _) => println("Four elements, with the 2nd being '3'.")
    case List(_*) => println("Any other list with 0 or more elements.")
  }
}

println("---------------------------------------------------")
//https://regex101.com/
//([^,]+) -> Anything string till ,
//(.+) -> match all characters till terminated
val BookExtractorRE = """Book: title=([^,]+),\s+authors=(.+)""".r
val MagazineExtractorRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r

val catalog = List(
  "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",
  "Magazine: title=The New Yorker, issue=January 2009",
  "Book: title=War and Peace, authors=Leo Tolstoy",
  "Magazine: title=The Atlantic, issue=February 2009",
  "BadData: text=Who put this here??"
)

for (item <- catalog) {
  item match {
    case BookExtractorRE(title, authors) =>
      println("Book \"" + title + "\", written by " + authors)
    case MagazineExtractorRE(title, issue) =>
      println("Magazine \"" + title + "\", issue " + issue)
    case entry => println("Unrecognized entry: " + entry)
  }
}

println("---------------------------------------------------")

class Role
case object Manager extends Role
case object Developer extends Role

case class Person(name: String, age: Int, role: Role)

val alice = new Person("Alice", 25, Developer)
val bob = new Person("Bob", 32, Manager)
val charlie = new Person("Charlie", 32, Developer)

//@ to delcare variable in pattern
for (item <- Map(1 -> alice, 2 -> bob, 3 -> charlie)) {
  item match {
    case (id, p @ Person(_, _, Manager)) => println(p + "is overpaid.\n")
    case (id, p @ Person(_, _, _)) => println(p + " is underpaid.\n")
  }
}

//p @ => flatens below code
//item match {
//  case (id, p: Person) => p.role match {
//    case Manager => format("%s is overpaid.\n", p)
//    case _ => format("%s is underpaid.\n", p)
//  }
//}

//-----------------------------------------------

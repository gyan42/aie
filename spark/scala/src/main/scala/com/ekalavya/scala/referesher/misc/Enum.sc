//Scala does not need special syntax for enumerations. Instead, there's a class in its standard
//library, scala.Enumeration.

object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Color1 extends Enumeration {
  val Red, Green, Blue = Value
}

object Breed extends Enumeration {
  val doberman = Value("Doberman Pinscher")
  val yorkie = Value("Yorkshire Terrier")
  val scottie = Value("Scottish Terrier")
  val dane = Value("Great Dane")
  val portie = Value("Portuguese Water Dog")
}

Breed.dane.id
// print a list of breeds and their IDs
println("ID\tBreed")
for (breed <- Breed.values)
  println(breed + "\t" + breed)
// print a list of Terrier breeds
//println("\nJust Terriers:")
//Breed.
//  filter(_.toString.endsWith("Terrier")).foreach(println)



object WeekDay extends Enumeration {
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}

import WeekDay._
def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)
WeekDay.values filter isWorkingDay foreach println



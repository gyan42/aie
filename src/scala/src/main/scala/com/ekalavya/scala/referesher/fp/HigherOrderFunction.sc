/**
 * Created by mdhandapani on 10/8/15.
 *
 * Simply put passing function around the program. Giving the "first class citizen" recognition
 * to the functions just like objects.
 */

//Reduce Code Duplication

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file


  //Scala way
  def filesMatching(query: String,
                    matcher: (String, String) => Boolean) = {

    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding1(query: String) =
    filesMatching(query, _.endsWith(_)) //(fileName: String, query: String) => fileName.endsWith(query)

  def filesContaining1(query: String) =
    filesMatching(query, _.contains(_))

  def filesRegex1(query: String) =
    filesMatching(query, _.matches(_))
}


//-------------------------------------------------------------------


def containsNeg(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}

containsNeg(List(1, 2, 3, 4))

containsNeg(List(1, 2, -3, 4))

def containsNeg1(nums: List[Int]) = nums.exists(_ < 0)

containsNeg1(List(0, -1, -2))

def containsOdd(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num % 2 == 1)
      exists = true
  exists
}

//TODO
//--------------------------------------------------------------------------------------------


def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)

def modN(n: Int)(x: Int) = ((x % n) == 0)

val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

filter(nums, modN(2))
filter(nums, modN(3))


//------------------------------------------------------------------------------------------------

//Function "f" takes a integer and converts that to string
//This gives flexibility of defining the pattern of how the string can be
def apply(f: Int => String, v: Int) = f(v)
def layout[A](x: A) = "[" + x.toString() + "]"
println(apply(layout, 10))

println("/////////////////////////////////////////////////////////////////////////")

def formatResult(str: String, n: Int, f: Int => Int) : Unit = {
  println("The %s of %d is %d".format(str, n, f(n)))
}

formatResult("Increment", 7, (x: Int) => {val r = x + 1; r})
formatResult("Increment", 7, (x) => x + 1)
formatResult("Increment", 7, x => x + 1)
formatResult("Increment", 7, (x: Int) => x + 1)
/*In this last form _ + 1, sometimes called underscore
syntax for a function literal, we are not even bothering to name the argument to the
function, using _ represent the sole argument. When using this notation, we can
only reference the function parameter once in the body of the function */
formatResult("Increment", 7, _ + 1)
formatResult("Increment", 7, x => {val r = x + 1; r})
//If you really have patience to create a local variable
//for a function
val f = (x: Int) => {val r = x + 1; r}
formatResult("Increment", 8, f)


println("---------------------------------------------------------------------------")

def sumInts(a: Int, b: Int): Int = {
  if (a > b) 0 else a + sumInts(a+1, b)
}

sumInts(1,5)


def cube(x: Int): Int = x * x * x

def sumOfCubes(lowerLimit: Int, upperLimit: Int): Int = {
  if (lowerLimit > upperLimit)
    0
  else
    cube(lowerLimit) + sumOfCubes(lowerLimit + 1, upperLimit)
}

def summation(f: Int => Int, lowerLimit: Int, upperLimit: Int): Int = {
  if (lowerLimit > upperLimit) 0
  else f(lowerLimit) + summation(f, lowerLimit + 1, upperLimit)
}

def identity(x: Int) = x
def square(x: Int): Int = x * x
def cube1(x: Int) = x * x * x

def sumOfInts(a: Int, b: Int) = summation(identity, a , b)
def sumOfSquares(a: Int, b: Int) = summation(square, a , b)
def sumOfCubes1(a: Int, b: Int) = summation(cube1, a , b)

sumOfSquares(1,5)

println("----------------------------------------")

def sumX(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1, acc + f(a))
  }
  loop(a, 0)
}

def sumOfSquares2(a: Int, b: Int) = sumX(square, a,b)

sumOfSquares2(1,5)

sumX(x => x * x, 3, 5)

val s = Set(1,2,3)
s.map(_+2)
println("/////////////////////////////////////////////////////////////////////////")



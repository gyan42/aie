import java.lang._ // everything in the java.lang package
import scala._ // everything in the scala package
import Predef._// everything in the Predef object

val immutable = 0
//immutable = 2

//A Scalable Language
//In python Map is inbuild type. In Scala?
var capital = Map("US" -> "Washington", "France" -> "Paris")

// Adding new key-value pair to the map
capital += ("Japan" -> "Tokyo")

// Accessing the value using the key
println(capital("France"))



//-------------------------------------------

def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

factorial(30)

//--------------------------------------------

// Find of factorial of given number

import java.math.BigInteger

def factorial(x: BigInteger): BigInteger =
  if (x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial(x.subtract(BigInteger.ONE)))


//--------------------------------------------

// What makes Scala scalable?
val xs = 1 to 3
println(xs)
val it = xs.iterator
//eventually { it.next() shouldBe 3 }

//--------------------------------------------

// this is Java
//class MyClass {
//
//    private int index;
//    private String name;
//
//    public MyClass(int index, String name) {
//        this.index = index;
//        this.name = name;
//    }
//}

// Simple and elegant code
class MyClass(index: Int, name: String)


/*boolean nameHasUpperCase = false;  // this is Java
for (int i = 0; i < name.length(); ++i) {
    if (Character.isUpperCase(name.charAt(i))) {
        nameHasUpperCase = true;
        break;
    }
}*/

val name = "Imaginea"
val nameHasUpperCase = name.exists(_.isUpper)

val someValue = "someValue"
println(s"I am go print ${someValue}")
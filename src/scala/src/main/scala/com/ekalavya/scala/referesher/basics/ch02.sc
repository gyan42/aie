//evering this is a class
1 + 1

1.+(1)

//But how?
//1 ---> Implicit ocnversion ---> Int class


// Declare a string type variable and initialize the same

val msg = "Hello, world!"
val msg2: java.lang.String = "Hello again, world!"
val msg3: String = "Hello yet again, world!"
println(msg)

//msg = "Goodbye cruel world!" //uncomment to see the error


var greeting = "Hello, world!"
greeting = "Leave me alone, world!"

val multiLine =
  """
    |Line 1
    |Line 2
  """.stripMargin

//Time to see functions

def max(x: Int, y: Int): Int = {
     if (x > y) x
     else y
   }

max(5,6)

//or
def max1(x: Int, y: Int) = if (x > y) x else y
max1(6,5)


def greet() = println("Hello, world!")

//Loops

var i = 0
val array = "1234567890"
while (i < 10) {
  println(array(i))
  i += 1
}

array.foreach((value: Char) => println(value))

// Print the contents of array
for (value <- array)
  println(value)


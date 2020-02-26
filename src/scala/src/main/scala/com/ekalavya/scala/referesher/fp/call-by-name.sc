//https://alvinalexander.com/source-code/scala/simple-scala-call-name-example

def time(): Long = {
  println("In time()")
  System.nanoTime
}

def exec(t: Long): Long = {
  println("Entered exec, calling t ...")
  println("t = " + t)
  println("Calling t again ...")
  t
}

println(exec(time()))

//-------------------------------------------


def time1() = {
  println("Entered time() ...")
  System.nanoTime
}

//(variable: Type) : Type => {}  : Lambda

// `t` is now defined as a by-name parameter
def exec1(t: => Long) = {
  println("Entered exec, calling t ...")
  println("t = " + t)
  println("Calling t again ...")
  t
}

println(exec1(time1()))
/**
 * Created by mageswaran on 10/11/15.
 */

//Avoid concrete fields in traits that can’t be initialized to suitable default
//values. Use abstract fields instead, or convert the trait to a class with
//a constructor. Of course, stateless traits don’t have any issues with
//initialization.

class C1 {
  def m = List("C1")
}
trait T1 extends C1 {
  override def m = {"T1" :: super.m}
}
trait T2 extends C1 {
  override def m = {"T2" :: super.m}
}
trait T3 extends C1 {
  override def m = {"T3" :: super.m}
}
class C2 extends T1 with T2 with T3 {
  override def m = { "C2" :: super.m}
}
new C2().m

//C2, T3, T2, T1, C1

//Steps:
//1. C2
//1. C2 T1 T2 T3
//2. C2 T3 T2 T1
//3. C2 T3 C1 T2 C1 T1 C1
//4. C2 T3 T2 T1 C1 //remove all duplicates from left to right
//6. C2 T3 T2 T1 C1 java.lang.Object scala.Any

//1. Start with the class declaration and drop the other keywords
//2. Reverse the order of the list, except keep the first item  at the beginning,
//3. Replace each item in the list except the first  with its linearization
//4. Remove the classes on the left that appears twice on the right
//??5. Insert a right-associative list-concatenation operator between each element in the list
//6. Append the standard Scala classes ScalaObject, AnyRef, Any

//To print class Linearization
import scala.reflect.runtime.universe._
//val tpe = typeOf[LinearRegressionModel]
val tpe = typeOf[C2]
tpe.baseClasses foreach { s => println(s.fullName) }

class C3A extends T2 {
  override def m = "C3A" :: super.m
}

class C3 extends C3A with T1 with T2 with T3 {
  override def m = "C3" :: super.m
}

new C3().m
//List(C3, T3, T1, C3A, T2, C1)

//---------------------------------------------------------------------------------------

class A {
  def foo() = "A"
}

trait B extends A {
  override def foo() = "B" + super.foo()
}

trait C extends B {
  override def foo() = "C" + super.foo()
}

trait D extends A {
  override def foo() = "D" + super.foo()
}


//Mixins
var d = new A with D with C with B
println(d.foo) // CBDA????

/**
  Class Linearization (https://stackoverflow.com/questions/34242536/linearization-order-in-scala)


  A D C B

  1. expand
  A -> A
  D -> D A
  C -> C B A
  B -> B A

  2. reverse
  B C D A

  3.substitute
  B A C B A D A A

  4.remove all duplicates from left to right
  C B D A

  */

class Animal
trait Furry extends Animal
trait HasLegs extends Animal
trait FourLegged extends HasLegs
class Cat extends Animal with Furry with FourLegged

println("(new Cat) [" + (new Cat) + "]")


//As stackable interfaces

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }

  override def toString: String = buf.mkString(",")
}

val queue = new BasicIntQueue

queue.put(10)
queue.put(20)
queue.get()
queue.get()

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}

val q = new BasicIntQueue with Incrementing with Doubling
q.put(1)
q.put(42)  // which put would be called?
println("q [" + q + "]")

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}


val queue1 = (new BasicIntQueue with Incrementing with Filtering)
queue.put(-1)
queue.put(0)
queue.put(1)
println(queue)
queue.get()
queue.get()
queue.get()

//1. If the behavior will not be reused, then make it a concrete class. It is not reusable behavior after all.
//2. If it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into different parts of the class hierarchy.
//3. If you want to inherit from it in Java code, use an abstract class.
//4. If you plan to distribute it in compiled form, and you expect outside groups to write classes inheriting from it, you might lean towards using an abstract class.
//5. By default start with traits ;)
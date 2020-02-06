//https://docs.scala-lang.org/overviews/collections/overview.html
//https://docs.scala-lang.org/overviews/collections/performance-characteristics.html

import scala.collection.immutable.Queue
//Type Parameterization

//C++ -> Templates
//Java -> Generics

val intList: List[Int] = List(1,2,3,4)
val stringList: List[String] = List("a", "b", "c", "d")
val floatList: List[Double] = List(0.1, 0.2, 0.3)

intList.head
intList.tail
intList.reverse
intList.reverse.last
intList.reverse.init

assert(intList.head == intList.reverse.last)

2 :: intList
intList ::: List(6,7,8)
//Queues
//Lets build a function queue i.e immutable

//head :returns the first element of the queue
//tail :returns a queue without its first element
//enqueue:  returns a new queue with a given element
//appended at the end

//head, tail, and enqueue, should operate in constant time
val q = Queue(1, 2, 3)
val q1 = q enqueue 4 //a new queue is created, persisting old data

// Purely functional queues also have some similarity with lists.

class SlowAppendQueue[T](elems: List[T]) { // Not efficient
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x)) //slow
}

class SlowHeadQueue[T](smele: List[T]) { // Not efficient
  // smele is elems reversed
  def head = smele.last //slow
  def tail = new SlowHeadQueue(smele.init) //slow
  def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}

//So how to acheive constant time in three operations
//Use two lists: "leading ::: trailing.reverse"

class QueueV0[T](private val leading: List[T], private val trailing: List[T]) {
  private def mirror =
    if (leading.isEmpty)
      new QueueV0(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new QueueV0(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) =
    new QueueV0(leading, x :: trailing)
}

//Information hiding

class QueueV1[T] private (private val leading: List[T],
                        private val trailing: List[T])

object QueueV1 {
  // constructs a queue with initial elements `xs'
  def apply[T](xs: T*) = new QueueV1[T](xs.toList, Nil)
}

trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}

object QueueV2 {

  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](private val leading: List[T],
                             private val trailing: List[T]) extends Queue[T] {

    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head: T = mirror.leading.head

    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  }
}

// Queue is trait
//QueueV2[Int] is type

// If S is sub type of T, then should QueueV2[S] be considered a subtype
//of QueueV2[T]?

//for example, that you could pass a QueueV2[String] to
//the doesCompile method shown previously, which takes a value parameter of type Queue[AnyRef]


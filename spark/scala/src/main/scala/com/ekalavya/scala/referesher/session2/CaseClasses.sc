/**
 * Created by mageswarand on 14/May/19.
 */

abstract class Expr
case class Variable(name: String) extends Expr //name implicitly gets `val` prefix
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,  left: Expr, right: Expr) extends Expr

//toString, hashCode, and equalsto added by the compiler

val v = Variable("x")
v.name
val op = BinOp("+", Number(1), v)
//all objects are immutable, so how then to get a new version of the object ?
val newOp = op.copy(operator = "-")

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e))  => e   // Double negation
  case BinOp("+", e, Number(0)) => e   // Adding zero
  case BinOp("*", e, Number(1)) => e   // Multiplying by one
  case _ => expr
}

op match {
  case BinOp(expr, left, right) =>
    println(expr + " is a binary operation")
  case _ =>
}

//wildcard
op match {
  case BinOp(_, _, _) =>
    println(op + " is a binary operation")
  case _ =>
}

//Constant patterns

def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

describe(true)

//Variable patterns
val expr = 0
val res = expr match {
  case 0 => "zero"
  case somethingElse => "not zero: " + somethingElse
}

println(res)

//Constructor patterns

//Constructors are where pattern matching becomes really powerful.

op match {
  case BinOp("+", e, Number(0)) => println("a deep match")
  case _ =>
}

//Sequesnce PAttern
var value = List(0,1,2)
value match {
  case List(0, _, _) => println("found it")
  case _ =>
}

//Tuple patterns
val value1 = ("a", 1, 5.5)
value1 match {
  case (a, b, c) => println("matched " + a + b + c)
  case _ =>
}

//Typed patterns

def generalSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

generalSize("abc")
generalSize(Map(1 -> 'a', 2 -> 'b'))
generalSize(math.Pi)

//if (x.isInstanceOf[String]) {
//  val s = x.asInstanceOf[String]
//  s.length
//} else ...

//Type erasure

def isIntIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}

isIntIntMap(Map(1 -> 1))
isIntIntMap(Map("abc" -> "abc"))


def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

val as = Array("abc")
isStringArray(as)

val ai = Array(1, 2, 3)
isStringArray(ai)


//Variable binding
val op1 = UnOp("abs",  UnOp("abs", Number(0)))
op1 match {
  case UnOp("abs", e @ UnOp("abs", _)) => println(e)
  case _ =>
}

// Pattern guards i.e conditions in pattern matching

//Say if you want to transform as follows
//BinOp("+", Var("x"), Var("x")) ===> BinOp("*", Var("x"), Number(2))

//error
//def simplifyAdd(e: Expr) = e match {
//  case BinOp("+", x, x) => BinOp("*", x, Number(2))
//  case _ => e
//}


def simplifyAdd(e: Expr) = e match {
  case BinOp("+", x, y) if x == y =>
         BinOp("*", x, Number(2))
       case _ => e
}

val res3 = simplifyAdd(BinOp("+", Variable("x"), Variable("x")))



val myTuple = (123, "abc")

val (number, string) = myTuple

val exp = new BinOp("*", Number(5), Number(1))
val BinOp(oper, left, right) = exp


//Case sequences as partial functions
//This facility is quite useful for the Akka actors library
val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

withDefault(Some(10))
withDefault(None)

//var sum = 0
//def receive = {
//  case Data(byte) =>
//    sum += byte
//  case GetChecksum(requester) =>
//    val checksum = ~(sum & 0xFF) + 1
//    requester ! checksum
//}


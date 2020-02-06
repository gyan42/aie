# Scala

- Object Oriented
- Functional Programming
- Dynamic vs Static typed Languages
- Python Map (inbuild data type) vs Scala Map (yet another type)
- Lego blocks vs Pre moulded house
- Everything is a class : Types
- Multithreading : Traditional (Shared I/O, Locks), Scala: Traditional + Actors(Akka)
- Functional Programming Support
    - Immutable
    - No side effects
    - Refferential transparent (replace function with value) 


## Session 1 Contents
- Basics
    - Collections 
    - Higher level APIs
    - Control Structures
    - Pattern matching
- Object Oriented Concepts
    - Traits
    - Inheritance
    - Accessibility
- Functional Programming
    - Function literals / Lambdas
    - Higher Order Function
    - Currying
    - Partial Function
    - Closure
- Misc
    - Options, Either, Lazy val
    - Enum
    

## Notes

Unit ~ Void
Null ~ Option[x] which can be Some(x) or None  ~ Either[+T1, +T2] - Left for exception
Nil ~ End element in the List

AnyRef ~ java.Object ~ java.* ref types / scala.* ref types
Nothing - Subclass of all types

function() --> parenthesis can be dropped if there is no side effect when there is no params
"hello".length // no () because no side-effect, access the value
println() // better to not drop the () when there is some operation


## Collections:
AnyRef <- Iteratable[T] <- Collection[+T] <- Seq[+T]
- List
- Map
- Set
- Queue
- Stack

Predef defines a number of implicit conversion methods for the value types (excluding Unit).

There are implicit conversions to the corresponding scala.runtime.RichX types.

## Annonymous Function
A FunctionN trait, where N is 0 to 22, is instantiated for an anonymous function with
N arguments. So, consider the following anonymous function:
          (t1: T1, ..., tN: TN) => new R(...)
It is syntactic sugar for the following creation of an anonymous class:
new FunctionN {
  def apply(t1: T1, ..., tN: TN): R = new R(...)
  // other methods
}

## Scala Symbols
+/- : Operators for adding/removing elements
++/-- : Operators for adding/removing elements defined in the iterators (which could be other sets, lists, etc.).


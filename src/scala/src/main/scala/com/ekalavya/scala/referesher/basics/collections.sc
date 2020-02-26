
/* We can create mutable and immutable variable in scala.
Declaring and Initializing the mutable variables, Var is the keyword */

var x = 2
var y = 3


// Declaring the variable by specifying the datatype

val data:String = "Welcome to Scala"

// Print the variables

println(x)
println(data)

// Reassignment of values to the variables

x = 4
x+y

// Intializing the Immutable type variables, val is the keyword

val p = 10
val q = 20
p+q

// Trying to assign new value to immutable type variable

//p = 15

/* A string is a sequence of characters. 
In Scala, objects of String are immutable and if
you need to append to the original string, 
then use StringBuilder class */

// Define and Initialize the String variables
var str1 = "Scala"
var str2 : String = "Java"

println(str1)
println(str2)

// String in built functions

// Length of the string
var len1 = str1.length();
println(len1)

// Concatenate two strings
println(str1.concat(str2));


// String formating
var name = "MAC"
var number = 130
println("%s, %d".format(name, number));


/* List maintains order of elements and 
can contain duplicates elements also */

// Create and print list
var l1 = List(1,8,5,6,9,58,23,15,4)  
var l2:List[Int] = List(1,8,5,6,9,58,23,15,4)  
println(l1)  
println(l2) 

// Operations on List

var list = List(1,8,5,6,9,58,23,15,4)  
var list2 = List(88,100) 

// Iterating using foreach loop 
print("Elements: ")  
list.foreach((element:Int) => print(element+" "))

// Accessing element of 2 index 
print("\nElement at 2 index: "+list(2))

// Merging two list 
var list3 = list ++ list2
print("\nElement after merging list and list2: ")  
list3.foreach((element:Int)=>print(element+" "))

// Sorting list 
var list4 = list3.sorted 
print("\nElement after sorting list3: ")  
list4.foreach((element:Int)=>print(element+" "))

// Reversing list elements
var list5 = list3.reverse 
print("\nElements in reverse order of list5: ")  
list5.foreach((element:Int)=>print(element+" ")) 

// Creating and initializing immutable sets 
val set1: Set[String] = Set("Sunday", "Monday", "Tuesday", "Wednesday") 
val set2 = Set("C", "C#", "Java", "Scala","PHP", "Ruby") 

// Display the value of myset1 

println("Set 1:") 
println(set1)

// Display the value of set2 using for loop 

println("\nSet 2:") 
for(myset<-set2) 
{ 
    println(myset) 
}

import scala.collection.mutable._
// Creating and initilazing mutable set 

var myset = Set("One", "Two", "Three") 
println("Set before addition of new elements:") 
println(myset) 

// Adding new element in set using += and ++==  
       
myset += "Four"
          
/* Here, "Monday" is already present in the 
Set so, "Monday" is not added in set */

myset ++== List("Five", "Six", "One") 

 // Adding elements using add() method 

myset.add("Seven") 
myset.add("Eight") 
println("\nSet after addition of new elements:") 
println(myset)

// Removing elements from the Mutable set

myset -= "Seven"
println(myset)

myset --= List("Three", "Four") 
println(myset)

// Creating and initializing two sets 

val myset1 = Set(11, 22, 33, 44, 55, 66, 77, 111) 
val myset2 = Set(88, 22, 99, 44, 55, 66, 77)

// Union

val S1 = myset1.union(myset2) 
println("\nUnion:") 
println(S1)

// Intersection

val S2 = myset1.intersect(myset2) 
println("Intersection:") 
println(S2) 

// Difference

val S3 = myset1.diff(myset2) 
println("\nDifference:") 
println(S3)

// SortedSet -> This is to get values from the set in sorted order
import  scala.collection.immutable.SortedSet
val myset4: SortedSet[Int] = SortedSet(87, 0, 3, 45, 7, 56, 8,6)
myset4.foreach((items: Int)=> println(items)) 

// Initialize the map and print the same

val mapIm = scala.collection.immutable.Map("Ajay" -> 30, "Avinash" -> 20, "Anushu" -> 50)
println(mapIm)

// Accessing Values Using Keys

val ajay = mapIm("Ajay")
println(ajay)

//Updating the values
//mapIm("Ajay") = 10  //Error
//println(mapIm)

// Initialize the mutable map and print the same

val mapMut = scala.collection.mutable.Map("Ajay" -> 30, "Avinash" -> 20,  "Anushu" -> 50)
println("Before Updating: " + mapMut) 

// Updating the values

mapMut("Ajay") = 40
println("After Updating: " + mapMut)

// Adding new key-value pair

mapMut += ("Aravind" -> 60)
println(mapMut)

// Deleting a key-value pair

mapMut -= ("Avinash")
println(mapMut)

// (k, v) is a tuple with two elements 
for((k, v) <- mapMut)
{
    //where k is key and v is value
    print("Key:"+k+", ")
    println("Value:"+v)
}

/* Create an array  of the string as week days,
store day values in the weekdays and prints each value */

var days = Array("Sunday", "Monday", "Tuesday",  "Wednesday", "Thursday", "Friday", "Saturday" )
println("Array elements are : ") 
for ( m1 <-days )
{
    println(m1 )
}

// Accessing array elements

var days1 = Array("Sunday", "Tuesday", "Tuesday") 
println("second element of an array is: ") 
println(days1(1)) 

// Updating an element in array

days1(1)="Monday"
println("After updation array elements are: ") 
for ( m2 <-days1 ) 
{
    println(m2 )
}

// Adding elements in an array
 
var weekdays = new Array[String](3)
weekdays(0) = "Thursday"
weekdays(1) = "Friday"
weekdays(2) = "Saturday"
for ( day <-weekdays ) 
{
    println(day)
}

// Tuple is a collection of elements. Tuples are heterogeneous data structures

val name3 = (15, "Chandan", true)

// Accessing elements from tuple

println(name3._1)
println(name3._2)
println(name3._3)

// Pattern matching on tuples

var (a1, b1, c1) = (15, "chandan", true) 
println(a1) 
println(b1) 
println(c1)

// Iterating over a tuple

name3.productIterator.foreach{i4=>println(i4)} 

// Converting tuple to string

println(name3.toString())

// Swap the elements of tuple

val name2 = ("first","second") 
println(name2.swap)

// Define Trait

trait MyTrait 
{ 
    def pet  
    def pet_color 
}

// MyClass inherits trait 

class MyClass extends MyTrait 
{ 
      
    // Implementation of methods of MyTrait 
    def pet() 
    { 
        println("Pet: Dog") 
    } 
      
    def pet_color() 
    { 
        println("Pet_color: White") 
    } 
      
    // Class method 
    def pet_name() 
    { 
        println("Pet_name: Dollar") 
    } 
} 

// Invoke the MyClass

val obj = new MyClass(); 
obj.pet(); 
obj.pet_color(); 
obj.pet_name(); 

// Create an array and Iterarte over it

val v = Array(5,1,2,3,6,4)

// defining an iterator 

val itr = v.iterator 
while (itr.hasNext) 
    print(itr.next + " ")

// Defining Iterator

val l = List(5, 1, 2, 3, 6, 4) 
val itr1 = l.iterator

// Accessing List elements using foreach
itr1 foreach println

// Defining Iterator

val list6 = List(5, 1, 2, 3, 6, 4) 
val itr2 = list6.iterator

// Accessing elements using for loop 

for(k <- itr2) println(k)

/* Find Max and Min Values using built in functions
Using built-in functions min and max Iterators can be traversed only once */

// defining iterator 
val itr3 = Iterator(5, 1, 2, 3, 6, 4) 

// calling max function 
println("Maximum: "+ itr3.max) 

// redefining iterator 
val itr4 = Iterator(5, 1, 2, 3, 6, 4) 

// calling min function 
println("Minimum: "+ itr4.min)



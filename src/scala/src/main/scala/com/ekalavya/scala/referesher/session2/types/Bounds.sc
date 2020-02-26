
//https://blog.codecentric.de/en/2015/03/scala-type-system-parameterized-types-variances-part-1/
//https://apiumhub.com/tech-blog-barcelona/scala-type-bounds/
//https://apiumhub.com/tech-blog-barcelona/scala-generics-generalized-type-constraints/
//https://medium.com/@wiemzin/variances-in-scala-9c7d17af9dc4
//https://scalac.io/typeclasses-in-scala/

abstract class Fruit {
  def name: String
}

class Orange extends Fruit {
  def name = "Orange"
}

class Apple extends Fruit {
  def name = "Apple"
}

abstract class BoxV0 {
  def fruit: Fruit
  def contains(aFruit: Fruit) = fruit.name.equals(aFruit.name)
}

class OrangeBox(orange: Orange) extends BoxV0 {
  def fruit: Orange = orange
}

class AppleBox(apple: Apple) extends BoxV0 {
  def fruit: Apple = apple
}



class Box[F <: Fruit](aFruit: F) {

  def fruit: F = aFruit

  def contains(aFruit: Fruit) = fruit.name == aFruit.name
}

var appleBox = new Box[Apple](new Apple)

var orangeBox = new Box[Orange](new Orange)

class Rational(n: Int, d: Int) {

  require(d != 0) //goes nto primary constructor

  private val g = gcd(n.abs, d.abs)

  val numer = n / g
  val denom = d / g

  val `val`:String = "reserved name can be used with back ticks"
  val with_ : String = "with _ needs a space"

  //auxilary constructor
  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  //Method overloading
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  //use override to give new functionality
  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}



val x = new Rational(2, 3)

x * x

x * 2

//2 * r //Error Int(2).*(_: Int)

implicit def intToRational(x: Int) = new Rational(x) //Pimp my library

2 * x
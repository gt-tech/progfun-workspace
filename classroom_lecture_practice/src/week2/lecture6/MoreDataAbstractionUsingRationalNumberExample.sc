package week2.lecture6

object MoreDataTypesUsingRationalNumberExample {
  val x = new Rational(1, 3)                      //> x  : week2.lecture6.Rational = 1/3
  x.numerator                                     //> res0: Int = 1
  x.denominator                                   //> res1: Int = 3

  val y = new Rational(5, 7)                      //> y  : week2.lecture6.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week2.lecture6.Rational = 3/2

  x.add(y)                                        //> res2: week2.lecture6.Rational = 22/21

  x.sub(y).sub(z)                                 //> res3: week2.lecture6.Rational = -79/42

  y.add(y)                                        //> res4: week2.lecture6.Rational = 10/7

  x.less(y)                                       //> res5: Boolean = true

  x.max(y)                                        //> res6: week2.lecture6.Rational = 5/7

  //val strange = new Rational(1, 0)
  //strange.add(strange)

  new Rational(4)                                 //> res7: week2.lecture6.Rational = 4/1
}

class Rational(x: Int, y: Int) {

  require(y != 0, "Denominator must be non-zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //private val g = gcd(x, y)

  //def numerator = x / g
  //def denominator = y / g
  def numerator = x
  def denominator = y

  // overloaded constructor example
  def this(x: Int) = this(x, 1)

  def add(in: Rational): Rational =
    new Rational((numerator * in.denominator + denominator * in.numerator),
      denominator * in.denominator)

  def neg = new Rational(-numerator, denominator)

  def sub(in: Rational) = add(in.neg) // DRY principle, instead of writing principle, just inverse and send it to add to make it auto subtraction

  override def toString = {
    val g = gcd(x, y)
    numerator / g + "/" + denominator / g
  }

  def less(in: Rational): Boolean = numerator * in.denominator < in.numerator * denominator

  def max(in: Rational): Rational = if (this.less(in)) in else this
}
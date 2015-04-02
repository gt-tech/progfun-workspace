package week2.lecture5

object DataTypesUsingRationalNumberExample {
  val x = new Rational(1, 3)                      //> x  : week2.lecture5.Rational = 1/3
  x.numerator                                     //> res0: Int = 1
  x.denominator                                   //> res1: Int = 3

  val y = new Rational(5, 7)                      //> y  : week2.lecture5.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week2.lecture5.Rational = 3/2

  x.add(y)                                        //> res2: week2.lecture5.Rational = 22/21
  
  x.sub(y).sub(z)                                 //> res3: week2.lecture5.Rational = -79/42
}

class Rational(x: Int, y: Int) {
  def numerator = x
  def denominator = y

  def add(in: Rational): Rational =
    new Rational((numerator * in.denominator + denominator * in.numerator),
      denominator * in.denominator)

  def neg = new Rational(-numerator, denominator)
  
  def sub(in: Rational) = add(in.neg) // DRY principle, instead of writing principle, just inverse and send it to add to make it auto subtraction
  
  override def toString = numerator + "/" + denominator
}
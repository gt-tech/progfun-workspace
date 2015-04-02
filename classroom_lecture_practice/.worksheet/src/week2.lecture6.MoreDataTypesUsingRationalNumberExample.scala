package week2.lecture6

object MoreDataTypesUsingRationalNumberExample {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(102); 
  val x = new Rational(1, 3);System.out.println("""x  : week2.lecture6.Rational = """ + $show(x ));$skip(14); val res$0 = 
  x.numerator;System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  x.denominator;System.out.println("""res1: Int = """ + $show(res$1));$skip(31); 

  val y = new Rational(5, 7);System.out.println("""y  : week2.lecture6.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week2.lecture6.Rational = """ + $show(z ));$skip(13); val res$2 = 

  x.add(y);System.out.println("""res2: week2.lecture6.Rational = """ + $show(res$2));$skip(20); val res$3 = 

  x.sub(y).sub(z);System.out.println("""res3: week2.lecture6.Rational = """ + $show(res$3));$skip(13); val res$4 = 

  y.add(y);System.out.println("""res4: week2.lecture6.Rational = """ + $show(res$4));$skip(14); val res$5 = 

  x.less(y);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(13); val res$6 = 

  x.max(y);System.out.println("""res6: week2.lecture6.Rational = """ + $show(res$6));$skip(84); val res$7 = 

  //val strange = new Rational(1, 0)
  //strange.add(strange)

  new Rational(4);System.out.println("""res7: week2.lecture6.Rational = """ + $show(res$7))}
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

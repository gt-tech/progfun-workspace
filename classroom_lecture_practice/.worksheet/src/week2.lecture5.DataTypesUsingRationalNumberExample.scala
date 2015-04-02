package week2.lecture5

object DataTypesUsingRationalNumberExample {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  val x = new Rational(1, 3);System.out.println("""x  : week2.lecture5.Rational = """ + $show(x ));$skip(14); val res$0 = 
  x.numerator;System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  x.denominator;System.out.println("""res1: Int = """ + $show(res$1));$skip(31); 

  val y = new Rational(5, 7);System.out.println("""y  : week2.lecture5.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week2.lecture5.Rational = """ + $show(z ));$skip(13); val res$2 = 

  x.add(y);System.out.println("""res2: week2.lecture5.Rational = """ + $show(res$2));$skip(21); val res$3 = 
  
  x.sub(y).sub(z);System.out.println("""res3: week2.lecture5.Rational = """ + $show(res$3))}
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

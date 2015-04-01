package week1.lecture6

object BlockAndLexicalScopingSqrtComputationUsingNewtonMethod {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(137); 
  def absolute(x: Double) = if (x < 0) -x else x;System.out.println("""absolute: (x: Double)Double""");$skip(773); 

  def sqrt(number: Double) = {

    def sqrtIter(guess: Double): Double = {

      if (isGoodEnough( guess ) ) guess
      else sqrtIter(improve(guess))
    }

    def isGoodEnough(guess: Double): Boolean = {
      absolute(guess * guess - number) <= 0.001 // this is a problem for very small numbers which are smaller than 0.001 itself
      // this is also a problem for very large numbers because computation just takes infinite time as distance between very large but consecutive
      // floating point number is bigger than 0.001

      // A solution is to test proportional of the guess
      absolute(guess * guess - number) / number <= 0.001
    }

    def improve(guess: Double): Double = {
      (guess + number / guess) / 2
    }

    sqrtIter(1.0)
  };System.out.println("""sqrt: (number: Double)Double""");$skip(12); val res$0 = 

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(10); val res$2 = 
  sqrt(8);System.out.println("""res2: Double = """ + $show(res$2));$skip(85); val res$3 = 

  // Below are examples of very very small or very very large number
  sqrt(0.001);System.out.println("""res3: Double = """ + $show(res$3));$skip(14); val res$4 = 
  sqrt(1e-20);System.out.println("""res4: Double = """ + $show(res$4));$skip(13); val res$5 = 
  sqrt(1e20);System.out.println("""res5: Double = """ + $show(res$5));$skip(13); val res$6 = 
  sqrt(1e60);System.out.println("""res6: Double = """ + $show(res$6));$skip(11); val res$7 = 
  sqrt(16);System.out.println("""res7: Double = """ + $show(res$7))}

}

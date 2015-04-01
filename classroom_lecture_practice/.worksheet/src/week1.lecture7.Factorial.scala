package week1.lecture7

object Factorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(330); 

  // Factorial but not with tail-recursion as the
  // last call always have more than just the recursion
  // forcing stack to be maintained instead of being re-used (so more a linear recursion)
  def factorial(num: Int): Int = {
    if (num == 0) 1 else num * factorial(num - 1)
  };System.out.println("""factorial: (num: Int)Int""");$skip(331); 

  // last call of this method is always pure looping call back to itself
  // no other arguments/operations in that last call, hence it's a tail recursion
  def factorialWithTailRecursion(num: Int): Int = {
    def loop(acc: Int, x: Int): Int = {
      if (x == 0) acc
      else loop(acc * x, x -1 )
    }

    loop(1, num)
  };System.out.println("""factorialWithTailRecursion: (num: Int)Int""");$skip(17); val res$0 = 

  factorial(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(32); val res$1 = 
  factorialWithTailRecursion(4);System.out.println("""res1: Int = """ + $show(res$1))}
}

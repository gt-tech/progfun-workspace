package week1.lecture7

object Factorial {

  // Factorial but not with tail-recursion as the
  // last call always have more than just the recursion
  // forcing stack to be maintained instead of being re-used (so more a linear recursion)
  def factorial(num: Int): Int = {
    if (num == 0) 1 else num * factorial(num - 1)
  }                                               //> factorial: (num: Int)Int

  // last call of this method is always pure looping call back to itself
  // no other arguments/operations in that last call, hence it's a tail recursion
  def factorialWithTailRecursion(num: Int): Int = {
    def loop(acc: Int, x: Int): Int = {
      if (x == 0) acc
      else loop(acc * x, x -1 )
    }

    loop(1, num)
  }                                               //> factorialWithTailRecursion: (num: Int)Int

  factorial(4)                                    //> res0: Int = 24
  factorialWithTailRecursion(4)                   //> res1: Int = 24
}
package week2.lecture2

object Exercise {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int

  sum(x => x)(2, 4)                               //> res0: Int = 9
  product(x => x)(2, 6)                           //> res1: Int = 720
  fact(5)                                         //> res2: Int = 120
}
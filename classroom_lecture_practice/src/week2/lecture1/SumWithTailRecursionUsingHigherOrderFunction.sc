package week2.lecture1

object SumWithTailRecursion {

  def sum(f: Int => Int, start: Int, end: Int): Int = {

    def impl(acc: Int, next: Int): Int = {
     if ( next > end ) acc
     else impl(acc + f(next), (next+1))
    }

    impl(0, start)
  }                                               //> sum: (f: Int => Int, start: Int, end: Int)Int
  
  
  sum(x => x, 1,5)                                //> res0: Int = 15
  sum(x => x*x, 1,5)                              //> res1: Int = 55
  sum(x => x*x*x, 1,5)                            //> res2: Int = 225
  
}
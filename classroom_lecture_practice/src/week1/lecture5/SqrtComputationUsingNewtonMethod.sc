
object SqrtComputationUsingNewtonMethod {

  def absolute(x: Double) = if (x < 0) -x else x  //> absolute: (x: Double)Double

  def sqrtIter(guess: Double, number: Double): Double = {

    if (isGoodEnough(guess, number)) guess
    else sqrtIter(improve(guess, number), number)

  }                                               //> sqrtIter: (guess: Double, number: Double)Double

  def isGoodEnough(guess: Double, number: Double): Boolean = {
    absolute(guess * guess - number) <= 0.001 // this is a problem for very small numbers which are smaller than 0.001 itself
    // this is also a problem for very large numbers because computation just takes infinite time as distance between very large but consecutive
    // floating point number is bigger than 0.001
    
    // A solution is to test proportional of the guess
    absolute(guess * guess - number) / number <= 0.001
  }                                               //> isGoodEnough: (guess: Double, number: Double)Boolean

  def improve(guess: Double, number: Double): Double = {
    (guess + number / guess) / 2
  }                                               //> improve: (guess: Double, number: Double)Double

  def sqrt(number: Double) = sqrtIter(1.0, number)//> sqrt: (number: Double)Double
  
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(8)                                         //> res2: Double = 2.8284685718801468
  
  // Below are examples of very very small or very very large number
  sqrt(0.001)                                     //> res3: Double = 0.03162278245070105
  sqrt(1e-20)                                     //> res4: Double = 1.0000021484861236E-10
  sqrt(1e20)                                      //> res5: Double = 1.0000021484861237E10
  sqrt(1e60)                                      //> res6: Double = 1.0000788456669446E30
  sqrt(16)                                        //> res7: Double = 4.000000636692939
}
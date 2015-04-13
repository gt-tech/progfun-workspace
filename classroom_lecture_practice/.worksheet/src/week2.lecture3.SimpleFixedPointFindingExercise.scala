package week2.lecture3

import math.abs

object SimpleFixedPointFindingExercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(472); 
  def fixedPoint(f: Double => Double)(guess: Double): Double = {

    def loop(iterGuess: Double): Double = {
      val nextGuess = f(iterGuess)
      if (isCloseEnough(iterGuess, nextGuess)) nextGuess
      else loop(nextGuess)
    }

    def isCloseEnough(current: Double, next: Double): Boolean = {
      abs((current - next) / current) / current < 1.0e-4
    }

    loop(guess)
  };System.out.println("""fixedPoint: (f: Double => Double)(guess: Double)Double""");$skip(34); val res$0 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(580); 

  // Implement square root thru fixed point
  /*
   * Square root => y*y = x
   * => y = x/y
   * => Implies the sqrt(x) would be the fixed point answer of above equation
   * But implemetation of above quation as-is will osciallate a lot, so to reduce the
   * value oscillation, we limit it by instead using a mean (y + x/y) /2
   *
   * This way of limiting the osciallation is also referred as - 'Average Damping'
   * or 'stablizing by averaging'
   */
  // example of passing higher order function as argument
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0);System.out.println("""sqrt: (x: Double)Double""");$skip(184); 

  // example of passing higher order function as argument as well as using a return function for average damping
  def sqrt_alt(x: Double) = fixedPoint( averageDamp( y => x/y) )(1.0);System.out.println("""sqrt_alt: (x: Double)Double""");$skip(645); 
  //def sqrt_alt(x: Double) = fixedPoint( averageDamp( y => x/y, _) )(1.0) // with currying/partial function.
  // Tip for understanding -> basically we have decorated our function of y => x/y by using the returned function from averageDamp and then
  // passed the decorated function as argument to fixedPoint function, this way the callback for lack of better word
  // from within loop method inside fixedPoint will actually call the function inside (or returned from averageDamp)
  // which internally is calling the y=> x/y to get y and then averaging it out.
  
  
  def averageDamp(f: Double => Double)(num: Double) = (num + f(num)) / 2;System.out.println("""averageDamp: (f: Double => Double)(num: Double)Double""");$skip(90); val res$1 = 
  
  //def averageDamp(f: Double => Double, num: Double) = (num + f(num)) / 2

  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(14); val res$2 = 
  sqrt_alt(4);System.out.println("""res2: Double = """ + $show(res$2))}
}

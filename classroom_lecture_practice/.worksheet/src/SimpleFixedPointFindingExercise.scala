import math.abs

package week2.lecture3

object SimpleFixedPointFindingExercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(468); 
  def fixedPoint(f: Double => Double)(guess: Double): Double = {

    def loop(iterGuess: Double): Double = {
      val nextGuess = f(guess)
      if (isCloseEnough(iterGuess, nextGuess)) nextGuess
      else loop(nextGuess)
    }

    def isCloseEnough(current: Double, next: Double): Boolean = {
      abs((current - next) / current) / current < 1.0e-4
    }
    
    loop(guess)
   };System.out.println("""fixedPoint: (f: Double => Double)(guess: Double)Double""");$skip(41); val res$0 = 
   
   
   fixedPoint( x => 1 + x/2)(1);System.out.println("""res0: Double = """ + $show(res$0))}
}

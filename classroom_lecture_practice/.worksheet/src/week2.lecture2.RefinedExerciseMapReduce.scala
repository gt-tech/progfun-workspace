package week2.lecture2

object RefinedExerciseMapReduce {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(241); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(93); 

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(89); 

  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(48); 
  def fact(n: Int): Int = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(22); val res$0 = 

  sum(x => x)(2, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(24); val res$1 = 
  product(x => x)(2, 6);System.out.println("""res1: Int = """ + $show(res$1));$skip(10); val res$2 = 
  fact(5);System.out.println("""res2: Int = """ + $show(res$2))}
}

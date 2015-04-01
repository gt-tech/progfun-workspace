package week2.lecture1

object SumWithTailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(251); 

  def sum(f: Int => Int, start: Int, end: Int): Int = {

    def impl(acc: Int, next: Int): Int = {
     if ( next > end ) acc
     else impl(acc + f(next), (next+1))
    }

    impl(0, start)
  };System.out.println("""sum: (f: Int => Int, start: Int, end: Int)Int""");$skip(25); val res$0 = 
  
  
  sum(x => x, 1,5);System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  sum(x => x*x, 1,5);System.out.println("""res1: Int = """ + $show(res$1));$skip(23); val res$2 = 
  sum(x => x*x*x, 1,5);System.out.println("""res2: Int = """ + $show(res$2))}
  
}

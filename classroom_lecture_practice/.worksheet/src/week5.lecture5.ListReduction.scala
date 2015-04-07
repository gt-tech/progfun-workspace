package week5.lecture5

object ListReduction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  println("Welcome to the Scala worksheet");$skip(35); 

  val nums = List(1, 2, 3, 4, 5);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(38); val res$0 = 

  nums reduceLeft ((x, y) => x * y);System.out.println("""res0: Int = """ + $show(res$0));$skip(115); val res$1 = 
  // shorthand for above, each underscore
  // represents a new param from left to right
  nums reduceLeft (_ * _);System.out.println("""res1: Int = """ + $show(res$1));$skip(67); val res$2 = 

// foldleft takes a starting parameter
  (nums foldLeft 1)(_ * _);System.out.println("""res2: Int = """ + $show(res$2))}
  // foldleft can be applied to
  // empty list and starting param is
  // returned while reduceLeft can't
  // be applied on empty list
}

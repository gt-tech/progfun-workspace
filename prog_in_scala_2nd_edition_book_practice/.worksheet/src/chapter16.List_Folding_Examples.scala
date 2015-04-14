package chapter16

object List_Folding_Examples {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(58); 
  
  
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(76); val res$0 = 
  
  numbers.foldLeft(0)( (result: Int, current: Int) => result + current );System.out.println("""res0: Int = """ + $show(res$0));$skip(263); val res$1 = 
  
  // reverse a list using fold (we start throwing elements from left at the head of list, so last element
  // encountered while folding becomes first one on the result.
  numbers.foldLeft(List[Int]())( (result: List[Int], current: Int) => current :: result );System.out.println("""res1: List[Int] = """ + $show(res$1))}
  
}

package chapter16

object List_Sorting_Examples {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(45); val res$0 = 
  
  
  List(1, 3, 4, 2, 6) sortWith (_ < _);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(42); val res$1 = 
  
  List(1, 3, 4, 2, 6) sortWith (_ > _);System.out.println("""res1: List[Int] = """ + $show(res$1))}
  
  
}

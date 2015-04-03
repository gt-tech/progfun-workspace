package week3.lecture3

// To Test TypesExample_List.scala
object TypesExample_List_WorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
  println("Welcome to the Scala worksheet");$skip(76); 
  
  val list = new cons(0, new cons(1, new cons(2, new cons(3, new Nil))));System.out.println("""list  : week3.lecture3.cons[Int] = """ + $show(list ));$skip(16); val res$0 = 

  list.get(3);System.out.println("""res0: Int = """ + $show(res$0));$skip(14); val res$1 = 
  list.get(0);System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
  
  list.get(-1);System.out.println("""res2: Int = """ + $show(res$2))}
}

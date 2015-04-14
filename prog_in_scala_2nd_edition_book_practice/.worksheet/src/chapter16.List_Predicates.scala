package chapter16

//Predicates over lists: forall and exists
// forall - predicate must return true for all elements
// exist - looks for only one element to satisfy predicate requirement

object List_Predicates {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(260); 
  println("Welcome to the Scala worksheet");$skip(41); 

  val numbers = List(1, 2, 3, 4, 5, 6);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(30); val res$0 = 

  numbers forall { _ < 10 };System.out.println("""res0: Boolean = """ + $show(res$0));$skip(47); val res$1 = 

  (numbers map { _ + 10 }) forall { _ < 12 };System.out.println("""res1: Boolean = """ + $show(res$1));$skip(47); val res$2 = 

  (numbers map { _ + 10 }) exists { _ < 12 };System.out.println("""res2: Boolean = """ + $show(res$2))}

}

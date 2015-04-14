package chapter16

// map, flatMap, forall and foreach

object List_HigherOrderMethods_Mapping_Examples {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(149); 
  println("Welcome to the Scala worksheet");$skip(42); 
  
  val numbers = List(1, 2, 3, 4, 5, 6);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(26); val res$0 = 
  
  numbers map (_ + 10);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  numbers.map { x => x + 10 };System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(35); val res$2 = 
 
  numbers.forall { x => x < 10 };System.out.println("""res2: Boolean = """ + $show(res$2));$skip(41); val res$3 = 
  (11 :: numbers).forall { x => x < 10 };System.out.println("""res3: Boolean = """ + $show(res$3));$skip(43); val res$4 = 
  
  numbers.flatMap { x => List(x, x+1) };System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(93); val res$5 = 
  // to see difference with Map, see same thing with map
  numbers.map { x => List(x, x+1) };System.out.println("""res5: List[List[Int]] = """ + $show(res$5));$skip(174); val res$6 = 
  
  // inner map creates tuples while outer flatmap concats all tuples and keeps in a single list
  List.range(1, 5).flatMap { i => List.range(1, i) map { j => ( i , j ) }};System.out.println("""res6: List[(Int, Int)] = """ + $show(res$6))}
  
}

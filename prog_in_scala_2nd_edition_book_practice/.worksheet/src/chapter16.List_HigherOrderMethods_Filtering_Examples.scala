package chapter16

// filter, partition, find, takeWhile, dropWhile, and span
object List_HigherOrderMethods_Filtering_Examples {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(173); 
  println("Welcome to the Scala worksheet");$skip(41); 

  val numbers = List(1, 2, 3, 4, 5, 6);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(34); val res$0 = 

  numbers filter { _ % 2 == 0 };System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(37); val res$1 = 

  numbers filterNot { _ % 2 == 0 };System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(55); 

  val partitioned = numbers partition { _ % 2 == 0 };System.out.println("""partitioned  : (List[Int], List[Int]) = """ + $show(partitioned ));$skip(17); val res$2 = 
  partitioned._1;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(17); val res$3 = 
  partitioned._2;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(41); 
  
  val found = numbers find { _ == 6 };System.out.println("""found  : Option[Int] = """ + $show(found ));$skip(42); 
  val not_found = numbers find { _ == 7 };System.out.println("""not_found  : Option[Int] = """ + $show(not_found ));$skip(27); 
  assert(found == Some(6));$skip(28); 
  assert(not_found == None);$skip(35); 
  println("found -> " + found.get);$skip(34); val res$4 = 
  
  numbers takeWhile { _ <= 3 };System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(34); val res$5 = 
  
  numbers dropWhile { _ <= 3 };System.out.println("""res5: List[Int] = """ + $show(res$5))}

  // span not attempted
}

package chapter16

object List_FirstOrderMethods {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(85); 

  // :: is extension
  // ::: is concatenation

  val xs = List(1, 2, 3, 4, 5, 6);System.out.println("""xs  : List[Int] = """ + $show(xs ));$skip(51); 
  val ys = List("a", "b", "c", "d", "e", "f", "g");System.out.println("""ys  : List[String] = """ + $show(ys ));$skip(39); 

  println((xs :: ys).mkString(", "));$skip(40); 

  println((xs ::: ys).mkString(", "));$skip(194); 

  // writing custom - :::
  def custom_concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil            => ys
    case xhead :: xtail => xhead :: custom_concat(xtail, ys)
  };System.out.println("""custom_concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(53); 
  
  println((custom_concat(xs, ys)).mkString(", "));$skip(52); 
  
  assert(custom_concat(xs, ys).init.last == "f");$skip(44); 
  assert(custom_concat(xs, ys).last == "g");$skip(42); 
  assert(custom_concat(xs, ys).head == 1);$skip(47); 
  assert(custom_concat(xs, ys).tail.head == 2);$skip(52); 
  assert(custom_concat(xs, ys).reverse.head == "g");$skip(53); 
  
  assert(custom_concat(xs, ys).take(2).last == 2);$skip(50); 
  assert(custom_concat(xs, ys).drop(2).head == 3);$skip(38); val res$0 = 
  
  custom_concat(xs, ys).splitAt(6);System.out.println("""res0: (List[Any], List[Any]) = """ + $show(res$0));$skip(65); val res$1 = 
  
  custom_concat(xs, ys) map { x => "-" + x.toString() + "-" };System.out.println("""res1: List[String] = """ + $show(res$1));$skip(43); 
  
  assert(custom_concat(xs, ys)(0) == 1);$skip(46); 
  assert(custom_concat(xs, ys).apply(0) == 1);$skip(37); 
  
  val complex_list = List(xs, ys);System.out.println("""complex_list  : List[List[Any]] = """ + $show(complex_list ));$skip(23); val res$2 = 
  complex_list.flatten;System.out.println("""res2: List[Any] = """ + $show(res$2));$skip(15); val res$3 = 
  
  xs zip ys;System.out.println("""res3: List[(Int, String)] = """ + $show(res$3));$skip(20); val res$4 = 
  (xs zip ys) unzip;System.out.println("""res4: (List[Int], List[String]) = """ + $show(res$4))}
}

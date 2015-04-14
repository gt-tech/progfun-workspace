package chapter16

object List_InsertionSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  println("Welcome to the Scala worksheet");$skip(230); 

  def doSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => {
      /*println("doSort head -> " + head + ", tail -> " + tail.mkString(", "));*/
      insert(head, doSort(tail))
    }
  };System.out.println("""doSort: (list: List[Int])List[Int]""");$skip(273); 

  def insert(x: Int, list: List[Int]): List[Int] = list match {
    case Nil => x :: Nil
    case head :: tail => {
      /*println("insert -> head -> " + head + ", tail -> " + tail.mkString(", "));*/
      if (x <= head) x :: list else head :: insert(x, tail)
    }
  };System.out.println("""insert: (x: Int, list: List[Int])List[Int]""");$skip(56); 

  val list = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(32); val res$0 = 

  doSort(list).mkString(", ");System.out.println("""res0: String = """ + $show(res$0))}
}

package week5.lecture2

import scala.math.Ordering.StringOrdering

object ListMergeSortUsingOrderingClass {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(857); 

  def mergeSort[T](inList: List[T])(implicit ord: Ordering[T]): List[T] = {

    val n = inList.length / 2;
    //println("List length -> " + inList.length + ", Split index -> " + n);

    if (n == 0)
      inList
    else {

      def merge(fs: List[T], ls: List[T]): List[T] = {
        //println("fs => " + fs + " and ls => " + ls)

        (fs, ls) match {
          case (Nil, ys)          => ys
          case (xs, Nil)          => xs
          case (x :: xs, y :: ys) => if (ord.lt(x, y)) x :: merge(xs, ls) else y :: merge(fs, ys)
        }
      }

      merge(mergeSort(inList take n)(ord), mergeSort(inList drop n)(ord))

      /*val lists = inList.splitAt(n)
      merge( mergeSort(lists._1), mergeSort(lists._2))*/
    }

  };System.out.println("""mergeSort: [T](inList: List[T])(implicit ord: Ordering[T])List[T]""");$skip(59); 

  val nums = List(5, 6, 7, -3, -1, 8, 9, 0, 1, 2, -4, 7);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(100); 
  val fruits = List("banana", "apple", "apricot", "mango", "blackberry", "blueberry", "strawberry");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(32); val res$0 = 
  mergeSort(nums)(Ordering.Int);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(93); val res$1 = 
  // will work since compiler is told in function arg that ord is implicit
  mergeSort(nums);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(219); val res$2 = 

  // TODO: Doesn't work, not sure what's the construct??
  // sort by length of fruit name
  
  mergeSort(fruits)(new StringOrdering {
    override def lt(x: String, y: String): Boolean = x.length() < y.length()
  });System.out.println("""res2: List[String] = """ + $show(res$2));$skip(70); val res$3 = 
  
  

  // sort alphabetically
  mergeSort(fruits)(Ordering.String);System.out.println("""res3: List[String] = """ + $show(res$3));$skip(95); val res$4 = 
  // will work since compiler is told in function arg that ord is implicit
  mergeSort(fruits);System.out.println("""res4: List[String] = """ + $show(res$4))}

}

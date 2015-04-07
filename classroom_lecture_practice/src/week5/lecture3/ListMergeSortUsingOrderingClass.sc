package week5.lecture2

import scala.math.Ordering.StringOrdering

object ListMergeSortUsingOrderingClass {

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

  }                                               //> mergeSort: [T](inList: List[T])(implicit ord: Ordering[T])List[T]

  val nums = List(5, 6, 7, -3, -1, 8, 9, 0, 1, 2, -4, 7)
                                                  //> nums  : List[Int] = List(5, 6, 7, -3, -1, 8, 9, 0, 1, 2, -4, 7)
  val fruits = List("banana", "apple", "apricot", "mango", "blackberry", "blueberry", "strawberry")
                                                  //> fruits  : List[String] = List(banana, apple, apricot, mango, blackberry, bl
                                                  //| ueberry, strawberry)
  mergeSort(nums)(Ordering.Int)                   //> res0: List[Int] = List(-4, -3, -1, 0, 1, 2, 5, 6, 7, 7, 8, 9)
  // will work since compiler is told in function arg that ord is implicit
  mergeSort(nums)                                 //> res1: List[Int] = List(-4, -3, -1, 0, 1, 2, 5, 6, 7, 7, 8, 9)

  // TODO: Doesn't work, not sure what's the construct??
  // sort by length of fruit name
  
  mergeSort(fruits)(new StringOrdering {
    override def lt(x: String, y: String): Boolean = x.length() < y.length()
  })                                              //> res2: List[String] = List(mango, apple, banana, apricot, blueberry, strawbe
                                                  //| rry, blackberry)
  
  

  // sort alphabetically
  mergeSort(fruits)(Ordering.String)              //> res3: List[String] = List(apple, apricot, banana, blackberry, blueberry, ma
                                                  //| ngo, strawberry)
  // will work since compiler is told in function arg that ord is implicit
  mergeSort(fruits)                               //> res4: List[String] = List(apple, apricot, banana, blackberry, blueberry, ma
                                                  //| ngo, strawberry)

}
package week5.lecture3

object ListAlternateParameterizedMergeSort {

  // this technique utilizes usage of higher order function to enable use
  // of < operator as a function on any type passed to mergeSort function
  // this is different from lecture 2 in week 5 as that uses a slightly more
  // restrictive approach by ddefining T to be something that can be converted to
  // Ordered (T is a covariant of Ordered)
  // additionally it also promots the reuse of function for different types of
  // sorting - for example see how fruits was being sorted in different ways below
  // using the same sorting function.

  def mergeSort[T](inList: List[T])(lt: (T, T) => Boolean): List[T] = {

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
          case (x :: xs, y :: ys) => if (lt(x, y)) x :: merge(xs, ls) else y :: merge(fs, ys)
        }
      }

      merge(mergeSort(inList take n)(lt), mergeSort(inList drop n)(lt))

      /*val lists = inList.splitAt(n)
      merge( mergeSort(lists._1), mergeSort(lists._2))*/
    }

  }                                               //> mergeSort: [T](inList: List[T])(lt: (T, T) => Boolean)List[T]

  val nums = List(5, 6, 7, -3, -1, 8, 9, 0, 1, 2, -4, 7)
                                                  //> nums  : List[Int] = List(5, 6, 7, -3, -1, 8, 9, 0, 1, 2, -4, 7)
  val fruits = List("banana", "apple", "apricot", "mango", "blackberry", "blueberry", "strawberry")
                                                  //> fruits  : List[String] = List(banana, apple, apricot, mango, blackberry, bl
                                                  //| ueberry, strawberry)
  mergeSort(nums)((x: Int, y: Int) => x < y)      //> res0: List[Int] = List(-4, -3, -1, 0, 1, 2, 5, 6, 7, 7, 8, 9)

  // sort by length of fruit name
  mergeSort(fruits)((x: String, y: String) => x.length() < y.length())
                                                  //> res1: List[String] = List(mango, apple, banana, apricot, blueberry, strawbe
                                                  //| rry, blackberry)

  // sort alphabetically
  mergeSort(fruits)((x, y) => x < y)              //> res2: List[String] = List(apple, apricot, banana, blackberry, blueberry, ma
                                                  //| ngo, strawberry)
}
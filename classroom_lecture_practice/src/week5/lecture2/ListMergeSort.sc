package week5.lecture2

object ListMergeSort {

  // gtyagi ->  `T <% Ordered[T]` indicates T <% S (a view bound) says that
  // type T must be convertible to S, so it has to be either a subtype of S
  // or have implicit conversion defined
  def mergeSort[T <% Ordered[T]](inList: List[T]): List[T] = {

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
          case (x :: xs, y :: ys) => if (x < y) x :: merge(xs, ls) else y :: merge(fs, ys)
        }
      }
      
      merge( mergeSort(inList take n), mergeSort(inList drop n))

      /*val lists = inList.splitAt(n)
      merge( mergeSort(lists._1), mergeSort(lists._2))*/
    }

  }                                               //> mergeSort: [T](inList: List[T])(implicit evidence$2: T => Ordered[T])List[T]
                                                  //| 

  mergeSort(List(2,-4,5,7,1))                     //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  mergeSort(List(5, 6, 7, 8, 9, 1, 2, 7))         //> res1: List[Int] = List(1, 2, 5, 6, 7, 7, 8, 9)
}
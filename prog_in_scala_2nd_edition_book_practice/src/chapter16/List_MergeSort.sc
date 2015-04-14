package chapter16

object List_MergeSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sort[T](less: (T, T) => Boolean)(list: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (xhead :: xtail, yhead :: ytail) => {
        if (less(xhead, yhead)) xhead :: merge(xtail, ys)
        else yhead :: merge(xs, ytail)
      }
    }

    val n = list.length / 2
    if (n == 0) list
    else {
      val subLists: (List[T], List[T]) = list.splitAt(n)
      merge(sort(less)(subLists._1), sort(less)(subLists._2))
    }
  }                                               //> sort: [T](less: (T, T) => Boolean)(list: List[T])List[T]

  val list = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50)
                                                  //> list  : List[Int] = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50)
  
  // *********** Currying  ***********
  sort( (x: Int, y: Int) => x < y )(list)         //> res0: List[Int] = List(-50, -1, 0, 1, 2, 3, 4, 6, 10, 100)


  //  *********** Partial Application  ***********
  val intListSort = sort((x: Int, y: Int) => x < y) _
                                                  //> intListSort  : List[Int] => List[Int] = <function1>
  intListSort(list)                               //> res1: List[Int] = List(-50, -1, 0, 1, 2, 3, 4, 6, 10, 100)
}
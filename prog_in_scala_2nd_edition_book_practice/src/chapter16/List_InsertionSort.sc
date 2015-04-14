package chapter16

object List_InsertionSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def doSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => {
      /*println("doSort head -> " + head + ", tail -> " + tail.mkString(", "));*/
      insert(head, doSort(tail))
    }
  }                                               //> doSort: (list: List[Int])List[Int]

  def insert(x: Int, list: List[Int]): List[Int] = list match {
    case Nil => x :: Nil
    case head :: tail => {
      /*println("insert -> head -> " + head + ", tail -> " + tail.mkString(", "));*/
      if (x <= head) x :: list else head :: insert(x, tail)
    }
  }                                               //> insert: (x: Int, list: List[Int])List[Int]

  val list = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50)
                                                  //> list  : List[Int] = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50)

  doSort(list).mkString(", ")                     //> res0: String = -50, -1, 0, 1, 2, 3, 4, 6, 10, 100
}
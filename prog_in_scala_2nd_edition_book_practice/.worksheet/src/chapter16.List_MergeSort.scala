package chapter16

object List_MergeSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet");$skip(542); 

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
  };System.out.println("""sort: [T](less: (T, T) => Boolean)(list: List[T])List[T]""");$skip(56); 

  val list = List(100, 10, -1, 1, 0, 2, 3, 4, 6, -50);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(85); val res$0 = 
  
  // *********** Currying  ***********
  sort( (x: Int, y: Int) => x < y )(list);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(109); 


  //  *********** Partial Application  ***********
  val intListSort = sort((x: Int, y: Int) => x < y) _;System.out.println("""intListSort  : List[Int] => List[Int] = """ + $show(intListSort ));$skip(20); val res$1 = 
  intListSort(list);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}

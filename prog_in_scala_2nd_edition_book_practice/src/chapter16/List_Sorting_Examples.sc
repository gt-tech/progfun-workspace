package chapter16

object List_Sorting_Examples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  List(1, 3, 4, 2, 6) sortWith (_ < _)            //> res0: List[Int] = List(1, 2, 3, 4, 6)
  
  List(1, 3, 4, 2, 6) sortWith (_ > _)            //> res1: List[Int] = List(6, 4, 3, 2, 1)
  
  
}
package chapter16

object List_Folding_Examples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  numbers.foldLeft(0)( (result: Int, current: Int) => result + current )
                                                  //> res0: Int = 55
  
  // reverse a list using fold (we start throwing elements from left at the head of list, so last element
  // encountered while folding becomes first one on the result.
  numbers.foldLeft(List[Int]())( (result: List[Int], current: Int) => current :: result )
                                                  //> res1: List[Int] = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
  
}
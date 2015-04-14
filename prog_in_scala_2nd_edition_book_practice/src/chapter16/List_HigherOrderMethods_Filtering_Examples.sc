package chapter16

// filter, partition, find, takeWhile, dropWhile, and span
object List_HigherOrderMethods_Filtering_Examples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val numbers = List(1, 2, 3, 4, 5, 6)            //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6)

  numbers filter { _ % 2 == 0 }                   //> res0: List[Int] = List(2, 4, 6)

  numbers filterNot { _ % 2 == 0 }                //> res1: List[Int] = List(1, 3, 5)

  val partitioned = numbers partition { _ % 2 == 0 }
                                                  //> partitioned  : (List[Int], List[Int]) = (List(2, 4, 6),List(1, 3, 5))
  partitioned._1                                  //> res2: List[Int] = List(2, 4, 6)
  partitioned._2                                  //> res3: List[Int] = List(1, 3, 5)
  
  val found = numbers find { _ == 6 }             //> found  : Option[Int] = Some(6)
  val not_found = numbers find { _ == 7 }         //> not_found  : Option[Int] = None
  assert(found == Some(6))
  assert(not_found == None)
  println("found -> " + found.get)                //> found -> 6
  
  numbers takeWhile { _ <= 3 }                    //> res4: List[Int] = List(1, 2, 3)
  
  numbers dropWhile { _ <= 3 }                    //> res5: List[Int] = List(4, 5, 6)

  // span not attempted
}
package chapter16

// map, flatMap, forall and foreach

object List_HigherOrderMethods_Mapping_Examples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val numbers = List(1, 2, 3, 4, 5, 6)            //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6)
  
  numbers map (_ + 10)                            //> res0: List[Int] = List(11, 12, 13, 14, 15, 16)
  numbers.map { x => x + 10 }                     //> res1: List[Int] = List(11, 12, 13, 14, 15, 16)
 
  numbers.forall { x => x < 10 }                  //> res2: Boolean = true
  (11 :: numbers).forall { x => x < 10 }          //> res3: Boolean = false
  
  numbers.flatMap { x => List(x, x+1) }           //> res4: List[Int] = List(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7)
  // to see difference with Map, see same thing with map
  numbers.map { x => List(x, x+1) }               //> res5: List[List[Int]] = List(List(1, 2), List(2, 3), List(3, 4), List(4, 5),
                                                  //|  List(5, 6), List(6, 7))
  
  // inner map creates tuples while outer flatmap concats all tuples and keeps in a single list
  List.range(1, 5).flatMap { i => List.range(1, i) map { j => ( i , j ) }}
                                                  //> res6: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  
}
package chapter16

//Predicates over lists: forall and exists
// forall - predicate must return true for all elements
// exist - looks for only one element to satisfy predicate requirement

object List_Predicates {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val numbers = List(1, 2, 3, 4, 5, 6)            //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6)

  numbers forall { _ < 10 }                       //> res0: Boolean = true

  (numbers map { _ + 10 }) forall { _ < 12 }      //> res1: Boolean = false

  (numbers map { _ + 10 }) exists { _ < 12 }      //> res2: Boolean = true

}
package week5.lecture5

object ListReduction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val nums = List(1, 2, 3, 4, 5)                  //> nums  : List[Int] = List(1, 2, 3, 4, 5)

  nums reduceLeft ((x, y) => x * y)               //> res0: Int = 120
  // shorthand for above, each underscore
  // represents a new param from left to right
  nums reduceLeft (_ * _)                         //> res1: Int = 120

// foldleft takes a starting parameter
  (nums foldLeft 1)(_ * _)                        //> res2: Int = 120
  // foldleft can be applied to
  // empty list and starting param is
  // returned while reduceLeft can't
  // be applied on empty list
}
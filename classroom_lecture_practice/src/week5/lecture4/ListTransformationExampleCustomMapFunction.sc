package week5.lecture4

object ListTransformationExampleCustomMapFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def map[T, U](inList: List[T], f: T => U): List[U] = {
    inList match {
      case Nil     => Nil
      case x :: xs => f(x) :: map(xs, f)
    }
  }                                               //> map: [T, U](inList: List[T], f: T => U)List[U]

  val nums = List(1, 2, 3, 4)                     //> nums  : List[Int] = List(1, 2, 3, 4)
  map[Int, Int](nums, x => x * x)                 //> res0: List[Int] = List(1, 4, 9, 16)
  
  
  // just for demonstration using this with inbuilt map function
  nums.map { x => List(x.toString())}             //> res1: List[List[String]] = List(List(1), List(2), List(3), List(4))
  
}
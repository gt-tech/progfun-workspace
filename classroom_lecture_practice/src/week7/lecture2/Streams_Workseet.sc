package week7.lecture2

object Streams_Workseet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) List.empty
    else lo :: listRange(lo + 1, hi)
  }                                               //> listRange: (lo: Int, hi: Int)List[Int]

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]

  val list = listRange(1, 3)                      //> list  : List[Int] = List(1, 2)
  val stream = streamRange(1, 3)                  //> stream  : Stream[Int] = Stream(1, ?)

  for (n <- list) println(n)                      //> 1
                                                  //| 2
  // tail will be evaluated on demand
  // but end result is similar to list
  for (n <- stream) println(n)                    //> 1
                                                  //| 2
  // convert list to stream
  val strreamFromList = list.toStream             //> strreamFromList  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
}
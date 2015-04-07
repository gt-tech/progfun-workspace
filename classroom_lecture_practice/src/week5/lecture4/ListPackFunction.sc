package week5.lecture4

object ListPackFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def pack[T](inList: List[T]): List[List[T]] = inList match {
    case Nil => Nil
    case x :: xs => {
      val (first, rest) = inList.span(y => y == x)
      first :: pack(rest)
    }
  }                                               //> pack: [T](inList: List[T])List[List[T]]
  
  def packToEncode[T](inList: List[T]): List[(T, Int)] = inList match {
    case Nil => Nil
    case x :: xs => {
      val (first, rest) = inList.span(y => y == x)
      (x, first.length) :: packToEncode(rest)
    }
  }                                               //> packToEncode: [T](inList: List[T])List[(T, Int)]
  
  pack(List('a','a','b','b','b','b','c','a'))     //> res0: List[List[Char]] = List(List(a, a), List(b, b, b, b), List(c), List(a)
                                                  //| )
  packToEncode(List('a','a','b','b','b','b','c','a'))
                                                  //> res1: List[(Char, Int)] = List((a,2), (b,4), (c,1), (a,1))
}
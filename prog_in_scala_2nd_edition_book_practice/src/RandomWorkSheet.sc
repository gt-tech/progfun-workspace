object RandomWorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  (1 to 3) flatMap (x => ((1 to 3) map (y => (x, y))))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3))
  val numPairs = (List(1, 2, 3) zip List(1, 2, 3))//> numPairs  : List[(Int, Int)] = List((1,1), (2,2), (3,3))

  numPairs.map { xy => { println(xy._1 + "*" + xy._2); xy._1 & xy._2 } }.sum
                                                  //> 1*1
                                                  //| 2*2
                                                  //| 3*3
                                                  //| res1: Int = 6

  // Collection foldLeft

  val add = (_: Int) + (_: Int)                   //> add  : (Int, Int) => Int = <function2>
  val join = (_: String).concat(_: String)        //> join  : (String, String) => String = <function2>

  val nums = 1 to 10 toList                       //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val sum = nums.foldLeft(0)((res, current) => add(res, current))
                                                  //> sum  : Int = 55
  val sumUsingReduceLeft = nums.reduceLeft((res, current) => add(res, current))
                                                  //> sumUsingReduceLeft  : Int = 55
  val sumUsingReduceLeft2 = nums.reduceLeft(_ + _)//> sumUsingReduceLeft2  : Int = 55
  val sumUsingReduceLeft3 = nums.reduceLeft(add(_, _))
                                                  //> sumUsingReduceLeft3  : Int = 55

  val numStrList = nums map (x => x.toString)     //> numStrList  : List[String] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val alphabets = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                                                  //> alphabets  : List[String] = List(a, b, c, d, e, f, g, h, i, j)

  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val y = List(('r', 1))                          //> y  : List[(Char, Int)] = List((r,1))
  
  // we have to get now x - y
  val x_minus_y = y.foldLeft(x)( (acc, yelem) => { acc map( xelem =>  if ( xelem._1 == yelem._1) (xelem._1, xelem._2 - yelem._2) else xelem ) } )
                                                  //> x_minus_y  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,0))
  val x_minus_y_excluding_0_count = x_minus_y filter{case(x, y) => y > 0}
                                                  //> x_minus_y_excluding_0_count  : List[(Char, Int)] = List((a,1), (d,1), (l,1)
                                                  //| )
}
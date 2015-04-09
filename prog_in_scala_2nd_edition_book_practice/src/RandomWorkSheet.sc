object RandomWorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  (1 to 3) flatMap (x => ( (1 to 3) map ( y => (x, y) ) ) )
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3))
  val numPairs = (List(1,2,3) zip List(1,2,3) )   //> numPairs  : List[(Int, Int)] = List((1,1), (2,2), (3,3))
  
  numPairs.map { xy => {println(xy._1 + "*" + xy._2); xy._1 & xy._2} }.sum
                                                  //> 1*1
                                                  //| 2*2
                                                  //| 3*3
                                                  //| res1: Int = 6
}
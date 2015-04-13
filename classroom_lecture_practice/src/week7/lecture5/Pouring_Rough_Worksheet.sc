package week7.lecture5

object Pouring_Rough_Worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val problem = new Pouring(Vector(4, 7, 19))     //> problem  : week7.lecture5.Pouring = week7.lecture5.Pouring@5b3699a6

  // problem.moves
  //problem.pathSets.take(3).toList
  
  problem.solution(15)                            //> res0: Stream[week7.lecture5.Pouring_Rough_Worksheet.problem.Path] = Stream(F
                                                  //| ill(2) --> Vector(4, 0, 15)Pour(2,0), ?)
}
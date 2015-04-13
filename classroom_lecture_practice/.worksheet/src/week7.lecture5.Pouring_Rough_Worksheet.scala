package week7.lecture5

object Pouring_Rough_Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  println("Welcome to the Scala worksheet");$skip(48); 

  val problem = new Pouring(Vector(4, 7, 19));System.out.println("""problem  : week7.lecture5.Pouring = """ + $show(problem ));$skip(83); val res$0 = 

  // problem.moves
  //problem.pathSets.take(3).toList
  
  problem.solution(15);System.out.println("""res0: Stream[week7.lecture5.Pouring_Rough_Worksheet.problem.Path] = """ + $show(res$0))}
}

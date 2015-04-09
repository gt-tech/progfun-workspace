package week6.lecture3

object NQueens_Workseet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(744); 

  def queens(n: Int): Set[List[Int]] = {

    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1) // Algo first part ... place queens k-1
          col <- 0 until n
          if (isSafe(col, queens))
        } yield col :: queens
    }

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      //println("col - " + col + " queens -> " + queens + "  queensWithRow " + queensWithRow)
      queensWithRow forall {
        case (r, c) => col != c && Math.abs(col - c) != row - r // TODO??? same column and then diagonal check!
      }
    }
    placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(48); 

  def show(queens: List[Int]): Unit = {

  };System.out.println("""show: (queens: List[Int])Unit""");$skip(87); val res$0 = 

  //queens(4) map { x => show(x) }
  // also works by inference
  queens(4) map show;System.out.println("""res0: scala.collection.immutable.Set[Unit] = """ + $show(res$0))}
}

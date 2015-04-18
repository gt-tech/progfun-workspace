package week6.lecture3

object NQueens_Workseet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> queens: (n: Int)Set[List[Int]]

  def show(queens: List[Int]): Unit = {

  }                                               //> show: (queens: List[Int])Unit

  //queens(4) map { x => show(x) }
  // also works by inference
  queens(4) map show                              //> res0: scala.collection.immutable.Set[Unit] = Set(())
  
  queens(4).foreach { x => println(x) }           //> List(1, 3, 0, 2)
                                                  //| List(2, 0, 3, 1)
}
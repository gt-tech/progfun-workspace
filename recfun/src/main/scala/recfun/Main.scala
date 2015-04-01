package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
     val opening_parenthesis = '('
     val closing_parenthesis = ')'
     
    // we increment the count with every opening parenthesis and we decrement the count with every
    // closing parenthesis until we navigate to the end of list

    // if at any point in middle of navigation drops to less than 0, means that we have had more
    // closing parenthesis than open parenthesis, now count doesn't matter anymore with this unbalanced
    // ordering
    
    // for a proper balanced string, we would expect the final count to 0 with each opening parenthesis
    // being canceled out by corresponding closing parenthesis
    @tailrec def loop(chars: List[Char], count: Int): Boolean = {
      if ( chars.isEmpty ) count == 0 // return true (or balanced) if our count comes back to 0 at the end of list navigation
      else if ( count < 0 ) false // return false if count went below 0, we may have more closing parenthesis in start not in proper order, e.g. - ()))((
      else if ( chars.head == opening_parenthesis) loop(chars.tail, count + 1) // replay recursion by moving to next character in string and incrementing count
      else if ( chars.head == closing_parenthesis) loop(chars.tail, count - 1) // replay recursion by moving to next character in string and decrementing count
      else loop(chars.tail, count) // replay recursion by moving to next character in string but leaving count as-is
    }
    
    loop(chars, 0)
  }

  /**
   * Exercise 3
   */
  // solved by reference
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}

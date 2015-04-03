package week3.lecture1

/*
* This worksheet demonstrates class and inheritance
*/
object IntSets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val t1 = new Empty                              //> t1  : week3.lecture1.Empty = .
  t1 incl 4 incl 8 incl 6 incl 6                  //> res0: week3.lecture1.IntSet = {.4{{.6.}8.}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def contains(x: Int): Boolean = false
  
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else if (x == elem) true
    else false
  }
  
  override def toString = "{" + left + elem + right + "}"

3}
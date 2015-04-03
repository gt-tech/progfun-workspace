package week3.lecture1

/*
* This worksheet demonstrates class and inheritance
*/
object IntSets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(143); 
  println("Welcome to the Scala worksheet");$skip(24); 
  
  val t1 = new Empty;System.out.println("""t1  : week3.lecture1.Empty = """ + $show(t1 ));$skip(33); val res$0 = 
  t1 incl 4 incl 8 incl 6 incl 6;System.out.println("""res0: week3.lecture1.IntSet = """ + $show(res$0))}
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

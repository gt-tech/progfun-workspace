package week3.lecture3

import java.util.NoSuchElementException

// Below example shows how a "type" parameter (java like generics) can be used in Scala
// on classes
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def get(i: Int): T = throw new IndexOutOfBoundsException
}

class cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false // cons cell are never empty

  override def get(i: Int): T = {

    def iterate(n: Int, inList: List[T]): T = {
      if (inList.isEmpty) throw new IndexOutOfBoundsException
      else if (n == 0) inList.head
      else iterate(n - 1, inList.tail)
    }

    iterate(i, this)
  }
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head = throw new NoSuchElementException // using scala provided exception
  def tail = throw new NoSuchElementException("Nil.tail") // using java provided exception
}

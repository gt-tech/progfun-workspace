package learn.scalacheck

import org.scalacheck.Properties

object RecursiveGeneratorExample extends Properties("RecursiveGenerator") {

  // =========== START: Model ===========
  trait Tree[T] {
    def size: Int
  }

  case class Leaf[T](item: T) extends Tree[T] {
    def size = 1
  }

  case class Node[T](children: List[Tree[T]]) extends Tree[T] {
    def size = children.map(_.size).sum
  }
  // =========== STOP: Model ===========

  // ======== START: Generator Definitions =============
  import org.scalacheck.Gen
  import org.scalacheck.Gen.{ sized, choose, resize, oneOf, listOf, listOfN, lzy }
  import org.scalacheck.Arbitrary.{ arbitrary }

  def genLeaf[T](genT: Gen[T]): Gen[Leaf[T]] = genT map (Leaf(_))

  def genNode[T](genT: Gen[T]): Gen[Node[T]] =
    sized { size =>
      for {
        s <- choose(0, size)
        g = resize(size / (s+1), genTree(genT))
        children <- listOfN(s, g)
        //children <- listOf(genTree(genT))
      } yield Node(children)
    }

  // wrapped in lzy generator as otherwise StackOverflowError would occur
  // as genTree and genNode are calling each other recursively and oneOf
  // doesn't accept call by name so both of the arguments to oneOf would 
  // be evaluated from the word go resulting in infinite loop.
  def genTree[T](genT: Gen[T]): Gen[Tree[T]] = lzy { oneOf(genLeaf(genT), genNode(genT)) }

  val genIntTree = genTree(arbitrary[Int])

  println(genIntTree.sample)
  // ======== STOP: Generator Definitions =============
}
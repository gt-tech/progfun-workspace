package learn.scalacheck

object CustomArbitaryGenerator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Welcome to the Scala worksheet")

import org.scalacheck._
import org.scalacheck.Prop.forAll
  // START - Tree objects
  abstract sealed class Tree[T] {
    def merge(t: Tree[T]) = Internal(List(this, t))

    def size: Int = this match {
      case Leaf(_)            => 1
      //case Internal(children) => (children :\ 0)(_.size + _)
      case Internal(children) => children.foldLeft(0)((result: Int, current: Tree[T]) => result + current.size)
    }
  }

  case class Internal[T](children: Seq[Tree[T]]) extends Tree[T]

  case class Leaf[T](elem: T) extends Tree[T];$skip(1157); 

  // STOP - Tree objects

  // Start - ScalaCheck Arbitary extensions
  implicit def arbitaryTree[T](implicit a: Arbitrary[T]): Arbitrary[Tree[T]] = {
    Arbitrary {
      val genLeaf: Gen[Tree[T]] = for (e <- Arbitrary.arbitrary[T]) yield Leaf(e)

      def genInternal(sz: Int): Gen[Tree[T]] = for {
        n <- Gen.choose(sz / 3, sz / 2)
        c <- Gen.listOfN(n, genSizedTree(sz))
      } yield Internal(c)

      def genSizedTree(sz: Int): Gen[Tree[T]] =
        if (sz <= 0) genLeaf
        else Gen.frequency((1, genLeaf), (3, genInternal(sz)))

      Gen.sized { sz => genSizedTree(sz) }
    }
  };System.out.println("""arbitaryTree: [T](implicit a: org.scalacheck.Arbitrary[T])org.scalacheck.Arbitrary[learn.scalacheck.CustomArbitaryGenerator.Tree[T]]""");$skip(110); 

  val propMergeTree = forAll( (t1: Tree[Int], t2: Tree[Int]) =>
    t1.size + t2.size == t1.merge(t2).size);System.out.println("""propMergeTree  : org.scalacheck.Prop = """ + $show(propMergeTree ))}
}

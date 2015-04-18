package learn.scalacheck

object TreeUsingCaseClassGeneration extends App {

  abstract class Tree

  case object Leaf extends Tree
  case class Node(left: Tree, right: Tree, value: Int) extends Tree

  import org.scalacheck._
  import Gen._
  import Arbitrary.arbitrary

  val genLeaf = const(Leaf)
  
  val genNode = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(left, right, v)
  
  val genTree: Gen[Tree] = oneOf(genLeaf, genNode)
  
  
  println("tree -> " + genTree.sample)
}
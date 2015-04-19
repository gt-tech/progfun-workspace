package learn.scalacheck

import org.scalacheck.Properties
import org.scalacheck.Test.Parameters

object CustomTestSpecificationExample extends Properties("CustomTestSpecification") {

  // =========== START: Model ===========
  trait Expression {
    override def toString = show(this)
  }

  case class Const(n: Int) extends Expression
  case class Add(e1: Expression, e2: Expression) extends Expression
  case class Mul(e1: Expression, e2: Expression) extends Expression

  def show(e: Expression): String = e match {
    case Const(n)    => n.toString
    case Add(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
    case Mul(e1, e2) => "(" + show(e1) + " * " + show(e2) + ")"
  }

  def eval(e: Expression): Int = e match {
    case Const(n)    => n
    case Add(e1, e2) => eval(e1) + eval(e2)
    case Mul(e1, e2) => eval(e1) * eval(e2)
  }

  def rewrite(e: Expression): Expression = e match {
    case Add(e1, e2) if e1 == e2 => Mul(Const(2), e1)
    case Mul(Const(0), e)        => Const(0)
    case Add(Const(1), e)        => Add(Const(1), e)
    case _                       => e
  }
  // =========== STOP: Model ===========

  // ======== START: Generator Definitions =============
  import org.scalacheck.Gen
  import org.scalacheck.Gen.{ sized, choose, resize, oneOf, listOf, listOfN, lzy }
  import org.scalacheck.Arbitrary.{ arbitrary }
  import org.scalacheck.Prop.{ forAll, BooleanOperators, AnyOperators }

  val genExpr: Gen[Expression] = Gen.sized { size =>
    Gen.frequency(
      (size, genConst),
      (size - Math.sqrt(size).toInt, resize(size / 2, genAdd)),
      (size - Math.sqrt(size).toInt, resize(size / 2, genMul)))
  }

  val genConst = choose(0, 10).map { x => Const(x) }
  val genAdd = for { e1 <- genExpr; e2 <- genExpr } yield Add(e1, e2)
  val genMul = for { e1 <- genExpr; e2 <- genExpr } yield Mul(e1, e2)

  //println(genExpr.sample)

  import org.scalacheck.Shrink
  import org.scalacheck.Shrink.shrink
  import scala.collection.immutable.Stream
  implicit val shrinkExpr: Shrink[Expression] = Shrink(
    {
      case Const(n) => shrink(n) map Const
      case Add(e1, e2) => Stream.concat(
        Stream(e1, e2),
        shrink(e1) map (Add(_, e2)),
        shrink(e2) map (Add(e1, _)))
      case Mul(e1, e2) => Stream.concat(
        Stream(e1, e2),
        shrink(e1) map (Mul(_, e2)),
        shrink(e2) map (Mul(e1, _)))
    })

  val propRewrite = forAll(genExpr) { expr =>
    val rwExpr = rewrite(expr);
    (eval(rwExpr) ?= eval(expr)) :| "rewritten = "+rwExpr
  }

  object testParameters extends Parameters.Default {
    override val minSuccessfulTests = 1000
  }
  propRewrite.check(testParameters)
  // ======== STOP: Generator Definitions =============  
}
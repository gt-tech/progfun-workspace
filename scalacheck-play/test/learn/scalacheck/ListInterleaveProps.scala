package learn.scalacheck

import org.scalacheck.Properties
import org.scalacheck.Prop.{ AnyOperators, forAll, BooleanOperators, all, classify }
import org.scalacheck.Gen.{ choose }
import org.scalacheck.Arbitrary._

// used for "propInterleaveUsingFmwkErrorMessages" property specification
import org.scalatest._
import Matchers._
import prop.PropertyChecks._

/*
 * Example shows how the properties and generators along can be 
 * labeled along with smart equivalence checking.
 * 
 */
object ListInterleaveProps extends Properties("list.interleave") {

  def interleave[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case xshead :: xstail => ys match {
      case Nil              => xs
      case yshead :: ystail => xshead :: ys.head :: interleave(xstail, ystail)
    }
  }

  // example of generators being labeled in the argument to forAll
  property("propInterleave") = forAll(arbitrary[List[Int]] :| "List A", "List B" |: arbitrary[List[Int]]) { (xs, ys) =>
    classify(xs.length > 25, "large List A", "Small List A") { // example of printing percentage of types of data we are interested to know was generated for test
      classify(ys.length > 25, "large List B", "Small List B") { // nested example of printing percentage of types of data we are interested to know was generated for test
        val result = interleave(xs, ys)
        all( // examples of individual sub-properties being labeled in a complicated test.
          "size" |:
            (result.size ?= xs.size + ys.size),

          (!xs.isEmpty) ==> {
            "List A element" |:
              (result.contains(xs.head))
          },

          (!ys.isEmpty) ==> {
            "List B element" |:
              (result.contains(ys.head))
          }) :| ("result: " + result) // this is to print intermediate values to make test output more useful if property verification fails.
      }
    }
  }

  // sample of above test using scalacheck framework error messages - this approach doesn't require cluttering code with labels etc.
  // note that true is returned at the end as if the test has reached that far, it would imply that
  // it has passed, the shouldEqual methods which comes from ScalaTest (matcher etc.), performs match
  // and on failure throws exception otherwise on success returns Unit which doesn't work well for 
  // forAll which is expecting back a Boolean.
  property("propInterleaveUsingFmwkErrorMessages") = forAll { (xs: List[Int], ys: List[Int]) =>
    val result = interleave(xs, ys)
    xs.length + ys.length shouldEqual result.length

    true
  }
}
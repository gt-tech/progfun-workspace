package learn.scalacheck

import org.scalacheck.Properties
import org.scalacheck.Prop
import org.scalacheck.Prop.AnyOperators
import org.scalacheck.Gen.{ listOf, alphaStr, numChar }
import Prop.BooleanOperators

object StringUtilsProps extends Properties("StringUtils") {

  // test by using "Throw the exception" method for negative values
  // of n
  property("truncate") = Prop.forAll { (
    str: String, n: Int) =>
    lazy val out = StringUtils.truncate(str, n)
    if (n < 0) Prop.throws(classOf[StringIndexOutOfBoundsException])(out)
    else (str.length() <= n && str == out) || (str.length() > n && out == str.take(n) + "...")
  }

  // test by using "Remain unspecified - aka implication operator" method for negative values
  // of n
  property("truncate") = Prop.forAll { (
    str: String, n: Int) =>
    (n >= 0) ==> {
      val out = StringUtils.truncate(str, n)
      (str.length() <= n && str == out) || (str.length() > n && out == str.take(n) + "...")
    }
  }

  // a third way to test truncate is to handle the condition within the implemented method and
  // accordingly modify the evaluation criteria within property. - not shown.

  property("tokenize") = Prop.forAll(listOf(alphaStr), numChar) {
    (ts, d) =>
      val out = StringUtils.tokenize(ts.mkString, d)
      // ?= Prop.anyOperators used instead of == as it will print the 
      // generated input and output as well for easier debugging in why 
      // the test would fail if it fails (values printed to console)
      out.toList ?= ts
  }
}
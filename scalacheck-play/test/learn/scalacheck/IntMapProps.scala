package learn.scalacheck

import java.util.HashMap
import collection.JavaConversions._
import collection.immutable.IntMap

import org.scalacheck.Prop.{ forAll, AnyOperators, BooleanOperators }
import org.scalacheck.Properties

// This demonstrates how a reference implementation approach can be used to define 
// properties and test target object. Target object IntMap in this case is tested
// for a similar behavior we would expect in a reference (tried and tested/true) 
// implementation of HashMap[Int, Any] behavior.
object IntMapProps extends Properties("IntMap") {

  def equalMaps(hm: HashMap[Int, Any], im: IntMap[Any]) = {
    im.keys.forall { hm.containsKey(_) } &&
      hm.keySet().containsAll(im.keys) &&
      im.keys.forall { k => im(k) == hm(k) }
  }

  import org.scalacheck.Gen
  import org.scalacheck.Arbitrary.arbitrary

  val genMaps: Gen[(HashMap[Int, Any], IntMap[Any])] = {
    (arbitrary[List[Int]]) map { xs =>
      val mappings = for (n <- xs) yield (n, new Object)
      val im = IntMap(mappings: _*) // Shorthand Syntax for converting list of tuples to a key/value in Map
      val hm = new HashMap[Int, Any]
      for ((k, v) <- mappings) hm.put(k, v)
      (hm, im)
    }
  }

  property("size") = forAll(genMaps) {
    case (hm, im) => im.size ?= hm.size
  }

  property("isEmpty") = forAll(genMaps) {
    case (hm, im) => im.isEmpty ?= hm.isEmpty
  }

  property("add") = forAll(genMaps) {
    case (hm, im) => forAll { (k: Int, v: String) =>
      (k > 0) ==> {
        hm.put(k, v)
        equalMaps(hm, im + (k -> v))
      }
    }
  }
}
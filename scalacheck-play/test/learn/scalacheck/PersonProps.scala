package learn.scalacheck

import org.scalacheck.Gen.{choose, oneOf}
import org.scalacheck.Prop.forAll
import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.Prop.AnyOperators
import org.scalacheck.Properties

// This example shows how can we register custom
// implicit generators.
object PersonProps extends Properties("Person") {

  val genPerson = for {
    firstName <- oneOf("Sachin", "Virat", "Mahi", "Rohit", "Shikhar")
    lastName <- oneOf("Tendulkar", "Kohli", "Dhoni", "Sharma", "Dhawan")
    age <- choose(1, 1000)
  } yield new Person(firstName, lastName, age)
  
  
  import org.scalacheck.Arbitrary
  implicit val arbPerson = Arbitrary(genPerson)
  
  property("isTeenager") = forAll{ (p: Person) => p.isTeenager ?= (p.age >= 13 && p.age <= 19)}
}
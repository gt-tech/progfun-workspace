package chapter14

import chapter12.TraitPractice._
import org.scalatest.Suite

class Chapter12_TraitsPractice_Linearization_Test1 extends Suite {
  
  def testValidMessagesOnCatInstantiation() {
    val cat = new Cat()
    var result: List[String] = List() // TODO: How to test this thru a pure functional style?
    cat.name { x => (result = x :: result) }
    assert(result.size == 2)
  }
}
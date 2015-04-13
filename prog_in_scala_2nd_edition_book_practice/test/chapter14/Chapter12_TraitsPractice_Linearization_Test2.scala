package chapter14

import chapter12.TraitPractice._

import org.scalatest.FunSuite

class Chapter12_TraitsPractice_Linearization_Test2 extends FunSuite {

  test("test proper output on cat.name") {
    var result: List[String] = List() // TODO: How to test this thru a pure functional style?
    new Cat().name { x => (result = x :: result) }
    assert(result.size == 2)
    
    expect(2) {
      result.size
    }
  }
}
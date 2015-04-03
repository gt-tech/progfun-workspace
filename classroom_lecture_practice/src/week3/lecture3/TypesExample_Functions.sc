package week3.lecture3

object TypesExample_Functions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // Below example shows how functions can also use types (aka. generics)

  def singleton[T](elem: T) = new cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.lecture3.cons[T]
  singleton[Int](1)                               //> res0: week3.lecture3.cons[Int] = week3.lecture3.cons@1527171d
  singleton[Boolean](false)                       //> res1: week3.lecture3.cons[Boolean] = week3.lecture3.cons@395e7bc4

  // type inference example
  singleton(2.0)                                  //> res2: week3.lecture3.cons[Double] = week3.lecture3.cons@6a0f9e48
}
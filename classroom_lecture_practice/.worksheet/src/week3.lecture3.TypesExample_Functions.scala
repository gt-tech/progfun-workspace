package week3.lecture3

object TypesExample_Functions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(138); 

  // Below example shows how functions can also use types (aka. generics)

  def singleton[T](elem: T) = new cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)week3.lecture3.cons[T]""");$skip(20); val res$0 = 
  singleton[Int](1);System.out.println("""res0: week3.lecture3.cons[Int] = """ + $show(res$0));$skip(28); val res$1 = 
  singleton[Boolean](false);System.out.println("""res1: week3.lecture3.cons[Boolean] = """ + $show(res$1));$skip(47); val res$2 = 

  // type inference example
  singleton(2.0);System.out.println("""res2: week3.lecture3.cons[Double] = """ + $show(res$2))}
}

package week3.lecture3

object Main extends App {
  
  val list = new cons(0, new cons(1, new cons(2, new cons(3, new Nil))))
  
  println(list.get(3))
}

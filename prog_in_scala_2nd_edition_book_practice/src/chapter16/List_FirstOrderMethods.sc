package chapter16

object List_FirstOrderMethods {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // :: is extension
  // ::: is concatenation

  val xs = List(1, 2, 3, 4, 5, 6)                 //> xs  : List[Int] = List(1, 2, 3, 4, 5, 6)
  val ys = List("a", "b", "c", "d", "e", "f", "g")//> ys  : List[String] = List(a, b, c, d, e, f, g)

  println((xs :: ys).mkString(", "))              //> List(1, 2, 3, 4, 5, 6), a, b, c, d, e, f, g

  println((xs ::: ys).mkString(", "))             //> 1, 2, 3, 4, 5, 6, a, b, c, d, e, f, g

  // writing custom - :::
  def custom_concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil            => ys
    case xhead :: xtail => xhead :: custom_concat(xtail, ys)
  }                                               //> custom_concat: [T](xs: List[T], ys: List[T])List[T]
  
  println((custom_concat(xs, ys)).mkString(", ")) //> 1, 2, 3, 4, 5, 6, a, b, c, d, e, f, g
  
  assert(custom_concat(xs, ys).init.last == "f")
  assert(custom_concat(xs, ys).last == "g")
  assert(custom_concat(xs, ys).head == 1)
  assert(custom_concat(xs, ys).tail.head == 2)
  assert(custom_concat(xs, ys).reverse.head == "g")
  
  assert(custom_concat(xs, ys).take(2).last == 2)
  assert(custom_concat(xs, ys).drop(2).head == 3)
  
  custom_concat(xs, ys).splitAt(6)                //> res0: (List[Any], List[Any]) = (List(1, 2, 3, 4, 5, 6),List(a, b, c, d, e, f
                                                  //| , g))
  
  custom_concat(xs, ys) map { x => "-" + x.toString() + "-" }
                                                  //> res1: List[String] = List(-1-, -2-, -3-, -4-, -5-, -6-, -a-, -b-, -c-, -d-,
                                                  //|  -e-, -f-, -g-)
  
  assert(custom_concat(xs, ys)(0) == 1)
  assert(custom_concat(xs, ys).apply(0) == 1)
  
  val complex_list = List(xs, ys)                 //> complex_list  : List[List[Any]] = List(List(1, 2, 3, 4, 5, 6), List(a, b, c
                                                  //| , d, e, f, g))
  complex_list.flatten                            //> res2: List[Any] = List(1, 2, 3, 4, 5, 6, a, b, c, d, e, f, g)
  
  xs zip ys                                       //> res3: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d), (5,e), (6,f))
                                                  //| 
  (xs zip ys) unzip                               //> res4: (List[Int], List[String]) = (List(1, 2, 3, 4, 5, 6),List(a, b, c, d, 
                                                  //| e, f))
}
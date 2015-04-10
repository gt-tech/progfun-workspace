package week7.lecture2

object Streams_Workseet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(121); 

  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) List.empty
    else lo :: listRange(lo + 1, hi)
  };System.out.println("""listRange: (lo: Int, hi: Int)List[Int]""");$skip(140); 

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  };System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(31); 

  val list = listRange(1, 3);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(33); 
  val stream = streamRange(1, 3);System.out.println("""stream  : Stream[Int] = """ + $show(stream ));$skip(31); 

  for (n <- list) println(n);$skip(108); 
  // tail will be evaluated on demand
  // but end result is similar to list
  for (n <- stream) println(n);$skip(66); 
  // convert list to stream
  val strreamFromList = list.toStream;System.out.println("""strreamFromList  : scala.collection.immutable.Stream[Int] = """ + $show(strreamFromList ))}
}

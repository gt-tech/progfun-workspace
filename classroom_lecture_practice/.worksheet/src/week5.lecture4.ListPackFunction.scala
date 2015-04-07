package week5.lecture4

object ListPackFunction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(194); 

  def pack[T](inList: List[T]): List[List[T]] = inList match {
    case Nil => Nil
    case x :: xs => {
      val (first, rest) = inList.span(y => y == x)
      first :: pack(rest)
    }
  };System.out.println("""pack: [T](inList: List[T])List[List[T]]""");$skip(224); 
  
  def packToEncode[T](inList: List[T]): List[(T, Int)] = inList match {
    case Nil => Nil
    case x :: xs => {
      val (first, rest) = inList.span(y => y == x)
      (x, first.length) :: packToEncode(rest)
    }
  };System.out.println("""packToEncode: [T](inList: List[T])List[(T, Int)]""");$skip(49); val res$0 = 
  
  pack(List('a','a','b','b','b','b','c','a'));System.out.println("""res0: List[List[Char]] = """ + $show(res$0));$skip(54); val res$1 = 
  packToEncode(List('a','a','b','b','b','b','c','a'));System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1))}
}

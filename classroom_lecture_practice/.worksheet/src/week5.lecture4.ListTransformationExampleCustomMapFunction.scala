package week5.lecture4

object ListTransformationExampleCustomMapFunction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(120); 
  println("Welcome to the Scala worksheet");$skip(155); 

  def map[T, U](inList: List[T], f: T => U): List[U] = {
    inList match {
      case Nil     => Nil
      case x :: xs => f(x) :: map(xs, f)
    }
  };System.out.println("""map: [T, U](inList: List[T], f: T => U)List[U]""");$skip(32); 

  val nums = List(1, 2, 3, 4);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(34); val res$0 = 
  map[Int, Int](nums, x => x * x);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(109); val res$1 = 
  
  
  // just for demonstration using this with inbuilt map function
  nums.map { x => List(x.toString())};System.out.println("""res1: List[List[String]] = """ + $show(res$1))}
  
}

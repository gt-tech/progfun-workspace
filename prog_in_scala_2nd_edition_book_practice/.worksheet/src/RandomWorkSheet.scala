object RandomWorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(57); val res$0 = 

  (1 to 3) flatMap (x => ((1 to 3) map (y => (x, y))));System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(58); 
     
  val numPairs = (List(1, 2, 3) zip List(1, 2, 3));System.out.println("""numPairs  : List[(Int, Int)] = """ + $show(numPairs ));$skip(79); val res$1 = 

  numPairs.map { xy => { println(xy._1 + "*" + xy._2); xy._1 & xy._2 } }.sum;System.out.println("""res1: Int = """ + $show(res$1));$skip(61); 

  // Collection foldLeft

  val add = (_: Int) + (_: Int);System.out.println("""add  : (Int, Int) => Int = """ + $show(add ));$skip(43); 
  val join = (_: String).concat(_: String);System.out.println("""join  : (String, String) => String = """ + $show(join ));$skip(30); 

  val nums = 1 to 10 toList;System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(68); 

  val sum = nums.foldLeft(0)((res, current) => add(res, current));System.out.println("""sum  : Int = """ + $show(sum ));$skip(80); 
  val sumUsingReduceLeft = nums.reduceLeft((res, current) => add(res, current));System.out.println("""sumUsingReduceLeft  : Int = """ + $show(sumUsingReduceLeft ));$skip(51); 
  val sumUsingReduceLeft2 = nums.reduceLeft(_ + _);System.out.println("""sumUsingReduceLeft2  : Int = """ + $show(sumUsingReduceLeft2 ));$skip(55); 
  val sumUsingReduceLeft3 = nums.reduceLeft(add(_, _));System.out.println("""sumUsingReduceLeft3  : Int = """ + $show(sumUsingReduceLeft3 ));$skip(48); 

  val numStrList = nums map (x => x.toString);System.out.println("""numStrList  : List[String] = """ + $show(numStrList ));$skip(75); 

  val alphabets = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");System.out.println("""alphabets  : List[String] = """ + $show(alphabets ));$skip(57); 

  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1));System.out.println("""x  : List[(Char, Int)] = """ + $show(x ));$skip(25); 
  val y = List(('r', 1));System.out.println("""y  : List[(Char, Int)] = """ + $show(y ));$skip(180); 
  
  // we have to get now x - y
  val x_minus_y = y.foldLeft(x)( (acc, yelem) => { acc map( xelem =>  if ( xelem._1 == yelem._1) (xelem._1, xelem._2 - yelem._2) else xelem ) } );System.out.println("""x_minus_y  : List[(Char, Int)] = """ + $show(x_minus_y ));$skip(74); 
  val x_minus_y_excluding_0_count = x_minus_y filter{case(x, y) => y > 0};System.out.println("""x_minus_y_excluding_0_count  : List[(Char, Int)] = """ + $show(x_minus_y_excluding_0_count ))}
}

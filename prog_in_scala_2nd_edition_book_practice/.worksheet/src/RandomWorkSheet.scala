object RandomWorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(63); val res$0 = 
  
  (1 to 3) flatMap (x => ( (1 to 3) map ( y => (x, y) ) ) );System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(48); 
  val numPairs = (List(1,2,3) zip List(1,2,3) );System.out.println("""numPairs  : List[(Int, Int)] = """ + $show(numPairs ));$skip(78); val res$1 = 
  
  numPairs.map { xy => {println(xy._1 + "*" + xy._2); xy._1 & xy._2} }.sum;System.out.println("""res1: Int = """ + $show(res$1))}
}

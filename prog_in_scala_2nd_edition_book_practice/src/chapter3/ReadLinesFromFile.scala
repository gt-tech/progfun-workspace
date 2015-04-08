package chapter3

object ReadLinesFromFile extends App {

  import scala.io.Source

  //override def main(args:Array[String]):Unit = {
  if (args.length <= 0)
    println("No argument name")
  else
    args.foreach { x =>
      {
        println("Reading file -> " + x)
        // converted to list as getLines() gives iterator for one time use
        val lines = Source.fromFile(x).getLines().toList

        // find max line width
        val longest = lines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
        println("Max width -> " + longest.length())

        lines.foreach {
          x =>
            {
              println("(" + x.length() + ") | " + x)
            }
        }

      }
    }
  //}
}
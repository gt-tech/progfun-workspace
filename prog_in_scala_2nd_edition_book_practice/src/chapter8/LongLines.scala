package chapter8

import scala.io.Source

object LongLines {
  
  def processFile(filename: String, width: Int): Int = {
    val source = Source.fromFile(filename)
    val count = source.getLines().count { x => {processLine(filename, width, x); x.length() >= width} }
    count
//    for (line <- source.getLines())
//      processLine(filename, width, line)
  }
  
  
  private def processLine(filename: String,
                          width: Int, line: String) {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }
}
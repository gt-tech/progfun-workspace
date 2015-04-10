package chapter8

object FindLongLines {

  def main(args: Array[String]) {
    require(args != null && args.length > 0, "Program must be invoked with non-zero arguments")
    require(args(0) forall { ch => ch.isDigit }, "First argument must be the numeric desired width threshold")

    val width = args(0).toInt
    for (arg <- args drop 1) 
    {
      val count = LongLines.processFile(arg, width)
      println("Total lines exceeding width in file '" + arg + "' are - " + count)
    }
  }
}
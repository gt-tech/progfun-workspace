package chapter10

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    Element.elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    //val contents = new Array[String](this1.contents.length)
    Element.elem(for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2)
  }

  def demo() {
    println("Element's implementation invoked")
  }

  override def toString = contents mkString "\n"

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = Element.elem(' ', (w - width) / 2, height)
      var right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = Element.elem(' ', width, (h - height) / 2)
      var bot = Element.elem(' ', width, h - height - top.height)
      top above this above bot
    }
}

object Element {

  private class ArrayElement(
    val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}
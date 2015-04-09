package week6.lecture4

object For_constructsUsingBookDatabaseExample {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(116); 
  println("Welcome to the Scala worksheet");$skip(496); 

  def getAllBooks(): List[Book] = List(
    Book(name = "Programming in Scala", authors = List("John Doe", "Martin Oderskey")),
    Book(name = "Intro to functional programming", authors = List("Bird Richard")),
    Book(name = "Effective Java", authors = List("Joshua Bloch")),
    Book(name = "Playing it my way", authors = List("Sachin Tendulkar, John Doe")),
    Book(name = "Scala - In depth", authors = List("John Doe")),
    Book(name = "Effective testing", authors = List("John Doe")));System.out.println("""getAllBooks: ()List[week6.lecture4.Book]""");$skip(125); val res$0 = 

  // find all books whose author name contains doe
  for (b <- getAllBooks(); a <- b.authors if a.contains("Doe")) yield b;System.out.println("""res0: List[week6.lecture4.Book] = """ + $show(res$0));$skip(114); val res$1 = 
  // find all books whose name/title contains Scala
  for (b <- getAllBooks() if b.name contains "Scala") yield b;System.out.println("""res1: List[week6.lecture4.Book] = """ + $show(res$1));$skip(830); 

  // find all authors who have written more than one book
  val a = {
    for {
      b1 <- getAllBooks()
      b2 <- getAllBooks()

      // if b1 != b2 && b1.name < b2.name // 2nd expression added to ensure that a name doesn't get printed as many times as many
      // pairs of multiple books are encountered, like b1 = book1, b2 = book2 and then b1 = book2 and b2 = book1 but this only
      // fixes when author has 2 books, it fails when a author has more than 2 books, as this check is basically cutting the result
      // in half.
      //
      // One other way to fix this is to enclose the outer for loop in curly braces and call .distinct on the closing curly braces
      // removing duplicates

      if b1 != b2

      a1 <- b1.authors
      a2 <- b2.authors

      if a1 == a2

    } yield a1
  }.distinct;System.out.println("""a  : List[String] = """ + $show(a ));$skip(17); 
  
  println(a)}

}

case class Book(name: String, authors: List[String])

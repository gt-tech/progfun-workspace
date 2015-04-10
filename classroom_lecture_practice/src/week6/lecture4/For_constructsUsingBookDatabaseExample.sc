package week6.lecture4

object For_constructsUsingBookDatabaseExample {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def getAllBooks(): List[Book] = List(
    Book(name = "Programming in Scala", authors = List("John Doe", "Martin Oderskey")),
    Book(name = "Intro to functional programming", authors = List("Bird Richard")),
    Book(name = "Effective Java", authors = List("Joshua Bloch")),
    Book(name = "Playing it my way", authors = List("Sachin Tendulkar, John Doe")),
    Book(name = "Scala - In depth", authors = List("John Doe")),
    Book(name = "Effective testing", authors = List("John Doe")))
                                                  //> getAllBooks: ()List[week6.lecture4.Book]

  // find all books whose author name contains doe
  for (b <- getAllBooks(); a <- b.authors if a.contains("Doe")) yield b
                                                  //> res0: List[week6.lecture4.Book] = List(Book(Programming in Scala,List(John D
                                                  //| oe, Martin Oderskey)), Book(Playing it my way,List(Sachin Tendulkar, John Do
                                                  //| e)), Book(Scala - In depth,List(John Doe)), Book(Effective testing,List(John
                                                  //|  Doe)))

  // find all books whose author name contains doe - without for loop
  // or with higher order functions. (note for loops are translated to
  // higher order functions by compiler at compile time
  getAllBooks().flatMap { b => b.authors.withFilter(a => a.contains("Doe")) map (y => { println("y => " + y); b }) }
                                                  //> y => John Doe
                                                  //| y => Sachin Tendulkar, John Doe
                                                  //| y => John Doe
                                                  //| y => John Doe
                                                  //| res1: List[week6.lecture4.Book] = List(Book(Programming in Scala,List(John 
                                                  //| Doe, Martin Oderskey)), Book(Playing it my way,List(Sachin Tendulkar, John 
                                                  //| Doe)), Book(Scala - In depth,List(John Doe)), Book(Effective testing,List(J
                                                  //| ohn Doe)))

  // find all books whose name/title contains Scala
  for (b <- getAllBooks() if b.name contains "Scala") yield b
                                                  //> res2: List[week6.lecture4.Book] = List(Book(Programming in Scala,List(John 
                                                  //| Doe, Martin Oderskey)), Book(Scala - In depth,List(John Doe)))

  // find all authors who have written more than one book
  val a = {
    for {
      b1 <- getAllBooks()
      b2 <- getAllBooks()

      // if b1 != b2 && b1.name < b2.name // 2nd expression added to ensure that a name doesn't get printed as many times as many
      // pairs of multiple books are encountered, like b1 = book1, b2 = book2 and then b1 = book2 and b2 = book1 but this only
      // fixes when author has 2 books, it fails when a author has more than 2 books, as this check is basically cutting the result
      // in half so (2/2 - fixes and shows 1 though indirectly but with author having 3 books, results gets reduced to half like 6/2 -> 3 which is wrong).
      //
      // One other way to fix this is to enclose the outer for loop in curly braces and call .distinct on the closing curly braces
      // removing duplicates

      if b1 != b2

      a1 <- b1.authors
      a2 <- b2.authors

      if a1 == a2

    } yield a1
  }.distinct // distinct to make sure author names are unique and not duplicated
                                                  //> a  : List[String] = List(John Doe)

  println(a)                                      //> List(John Doe)

}

case class Book(name: String, authors: List[String])
package week6.lecture7

import scala.io.Source;

object CollectionsWorkSheet_TelephoneNumberTranslation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(151); 
  println("Welcome to the Scala worksheet");$skip(132); 

  // dictionary
  val dict = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt");System.out.println("""dict  : scala.io.BufferedSource = """ + $show(dict ));$skip(171); 

  // keep only words which has nothing else in them other than String.
  val words = dict.getLines().toList filter { w: String => w forall { chr: Char => chr.isLetter }
  };System.out.println("""words  : List[String] = """ + $show(words ));$skip(215); ;
  /* mneomonics define the map of numbers to letters */
  val nmem: Map[Char, String] = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO",
    '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""nmem  : Map[Char,String] = """ + $show(nmem ));$skip(256); 

  // invert the above map by having a character to phone key code mapping like A -> 2, B -> 2, C -> 2, D -> 3
  //var charCodeUsingFor = for { (k, v) <- nmem; x <- v } yield x -> k
  val charCode = nmem flatMap { case (k, v) => { v map (x => x -> k) } };System.out.println("""charCode  : scala.collection.immutable.Map[Char,Char] = """ + $show(charCode ));$skip(265); 

  // two ways to translate a word to it's correspondin digits like JAVA = 5282, 2nd way has more succint map usage
  //def wordCode(word: String): String = word map { x => charCode(x.toUpper) }
  def wordCode(word: String): String = word.toUpperCase map charCode;System.out.println("""wordCode: (word: String)String""");$skip(218); 

  // / Get all words to their corresponding digit translation
  // like 5282 -> List("Java","Kata","Lava"...)
  val wordsForNum: Map[String, Seq[String]] = (words groupBy { x => wordCode(x) }) withDefaultValue Seq();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(1123); 

  // to check if there are digit combinations which have more than one words
  //for { (k, v) <- wordsForNum; if ( v.length > 1 ) } yield ( k -> v )

  // Return all ways as a list to encode a number
  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty()) Set(List()) // empty number -> empty phrase
    else {
      {
        for {
          // if we don't do a outer conversion to set around for loop,
          // we get an error at split_point marked in IDE or in compilation
          // reason being scala type inference engine sees first line inside for block is
          // range and range can never be a result so it moves to next to figure what should
          // be the return type from for loop as a rule of type inference engine and that
          // turns out to  be IndexedSequence which isn't compatible with method's return type
          // of Set[List[String]]
          split_point <- 1 to number.length
          word <- wordsForNum(number take split_point)
          rest_encode <- encode(number drop split_point)
        } yield word :: rest_encode
      }.toSet
    }
  };System.out.println("""encode: (number: String)Set[List[String]]""");$skip(104); 

  def translate(number: String): Set[String] = {
    encode(number).map { x => x mkString (" ") }
  };System.out.println("""translate: (number: String)Set[String]""");$skip(51); 
  
  translate("7225247386").foreach { println _ }}
}

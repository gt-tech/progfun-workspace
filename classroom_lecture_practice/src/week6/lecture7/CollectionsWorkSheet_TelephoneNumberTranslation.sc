package week6.lecture7

import scala.io.Source;

object CollectionsWorkSheet_TelephoneNumberTranslation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // dictionary
  val dict = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
                                                  //> dict  : scala.io.BufferedSource = non-empty iterator

  // keep only words which has nothing else in them other than String.
  val words = dict.getLines().toList filter { w: String => w forall { chr: Char => chr.isLetter }
                                                  //> words  : List[String] = List(Aarhus, Aaron, Ababa, aback, abaft, abandon, ab
                                                  //| andoned, abandoning, abandonment, abandons, abase, abased, abasement, abasem
                                                  //| ents, abases, abash, abashed, abashes, abashing, abasing, abate, abated, aba
                                                  //| tement, abatements, abater, abates, abating, Abba, abbe, abbey, abbeys, abbo
                                                  //| t, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbreviating, abbre
                                                  //| viation, abbreviations, Abby, abdomen, abdomens, abdominal, abduct, abducted
                                                  //| , abduction, abductions, abductor, abductors, abducts, Abe, abed, Abel, Abel
                                                  //| ian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberrations, abet, 
                                                  //| abets, abetted, abetter, abetting, abeyance, abhor, abhorred, abhorrent, abh
                                                  //| orrer, abhorring, abhors, abide, abided, abides, abiding, Abidjan, Abigail, 
                                                  //| Abilene, abilities, ability, abject, abjection, abjections, abjectly, abject
                                                  //| ness, abjure, abjured, abjures, abjuring, ablate, ablated, ablates, ablating
                                                  //| , ablation, ablative, ab
                                                  //| Output exceeds cutoff limit.
  };
  /* mneomonics define the map of numbers to letters */
  val nmem: Map[Char, String] = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO",
    '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")   //> nmem  : Map[Char,String] = Map(8 -> TUV, 4 -> GHI, 9 -> WXYZ, 5 -> JKL, 6 ->
                                                  //|  MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)

  // invert the above map by having a character to phone key code mapping like A -> 2, B -> 2, C -> 2, D -> 3
  //var charCodeUsingFor = for { (k, v) <- nmem; x <- v } yield x -> k
  val charCode = nmem flatMap { case (k, v) => { v map (x => x -> k) } }
                                                  //> charCode  : scala.collection.immutable.Map[Char,Char] = Map(E -> 3, X -> 9, 
                                                  //| N -> 6, T -> 8, Y -> 9, J -> 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G ->
                                                  //|  4, V -> 8, Q -> 7, L -> 5, B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, 
                                                  //| R -> 7, O -> 6, D -> 3, Z -> 9, S -> 7)

  // two ways to translate a word to it's correspondin digits like JAVA = 5282, 2nd way has more succint map usage
  //def wordCode(word: String): String = word map { x => charCode(x.toUpper) }
  def wordCode(word: String): String = word.toUpperCase map charCode
                                                  //> wordCode: (word: String)String

  // / Get all words to their corresponding digit translation
  // like 5282 -> List("Java","Kata","Lava"...)
  val wordsForNum: Map[String, Seq[String]] = (words groupBy { x => wordCode(x) }) withDefaultValue Seq()
                                                  //> wordsForNum  : Map[String,Seq[String]] = Map(63972278 -> List(newscast), 29
                                                  //| 237638427 -> List(cybernetics), 782754448 -> List(starlight), 2559464 -> Li
                                                  //| st(allying), 862532733 -> List(uncleared), 365692259 -> List(enjoyably), 86
                                                  //| 8437 -> List(unties), 33767833 -> List(deportee), 742533 -> List(picked), 3
                                                  //| 364646489 -> List(femininity), 3987267346279 -> List(extraordinary), 785539
                                                  //| 7 -> List(pulleys), 67846493 -> List(optimize), 4723837 -> List(grafter), 3
                                                  //| 86583 -> List(evolve), 78475464 -> List(Stirling), 746459 -> List(singly), 
                                                  //| 847827 -> List(vistas), 546637737 -> List(lionesses), 28754283 -> List(curl
                                                  //| icue), 84863372658 -> List(thunderbolt), 46767833 -> List(imported), 264374
                                                  //| 64 -> List(angering, cohering), 8872267 -> List(turbans), 77665377 -> List(
                                                  //| spoolers), 46636233 -> List(homemade), 7446768759 -> List(rigorously), 7464
                                                  //| 4647 -> List(ringings), 633738 -> List(offset), 847825 -> List(visual), 772
                                                  //| 832 -> List(Pravda), 47
                                                  //| Output exceeds cutoff limit.

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
  }                                               //> encode: (number: String)Set[List[String]]

  def translate(number: String): Set[String] = {
    encode(number).map { x => x mkString (" ") }
  }                                               //> translate: (number: String)Set[String]
  
  translate("7225247386").foreach { println _ }   //> sack air fun
                                                  //| pack ah re to
                                                  //| pack bird to
                                                  //| Scala ire to
                                                  //| Scala is fun
                                                  //| rack ah re to
                                                  //| pack air fun
                                                  //| sack bird to
                                                  //| rack bird to
                                                  //| sack ah re to
                                                  //| rack air fun
}
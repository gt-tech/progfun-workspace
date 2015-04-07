package week5.lecture1

import scala.annotation.tailrec

object ListPractice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(131); 
  val givenNames = List("John", "Sachin", "George");System.out.println("""givenNames  : List[String] = """ + $show(givenNames ));$skip(46); 
  val lastNames = List("Doe", "Ramesh", "Xi");System.out.println("""lastNames  : List[String] = """ + $show(lastNames ));$skip(280); val res$0 = 

  // since no element is defined and only double-colons are used entire
  // givenNames list will be preprended to lastNames so new list will have first
  // object as list (aka givenNames list object) followed by 3 string type elements of lastNames
  (givenNames :: lastNames);System.out.println("""res0: List[java.io.Serializable] = """ + $show(res$0));$skip(142); val res$1 = 

  // three-colons, a new list with all 3 elements of givenNames followed by
  // all 3 elements of last names.
  (givenNames ::: lastNames);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(47); val res$2 = 

  // ++ same as ::
  givenNames ++ lastNames;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(59); val res$3 = 

  // drop one element from the start
  givenNames drop 1;System.out.println("""res3: List[String] = """ + $show(res$3));$skip(61); val res$4 = 

  // Displays first 2 elements of list
  givenNames take 2;System.out.println("""res4: List[String] = """ + $show(res$4));$skip(56); val res$5 = 

  // a new list in reverse order
  givenNames.reverse;System.out.println("""res5: List[String] = """ + $show(res$5));$skip(106); val res$6 = 

  // a new list with "Dixit" replacing the 1st (zero indexed) element
  givenNames updated (1, "Dixit");System.out.println("""res6: List[String] = """ + $show(res$6));$skip(29); val res$7 = 

  lastNames contains "Doe";System.out.println("""res7: Boolean = """ + $show(res$7));$skip(34); val res$8 = 

  lastNames contains "not-here";System.out.println("""res8: Boolean = """ + $show(res$8));$skip(27); val res$9 = 

  lastNames indexOf "Xi";System.out.println("""res9: Int = """ + $show(res$9));$skip(428); 

  

  def findIndexIgnoreCase(str: String, l: List[String]): Int = {

    @tailrec def loop(list: List[String], i: Int): Int = {
      list match {
        case (x :: Nil) => if (str equalsIgnoreCase x) i else throw new Error(str + " not found")
        case (x :: xs)  => if (str equalsIgnoreCase x) i else loop(xs, i + 1)
        case _          => throw new Error("unexpected condition")
      }
    }
    loop(l, 0)
  };System.out.println("""findIndexIgnoreCase: (str: String, l: List[String])Int""");$skip(38); val res$10 = 

findIndexIgnoreCase("xi", lastNames);System.out.println("""res10: Int = """ + $show(res$10))}
}

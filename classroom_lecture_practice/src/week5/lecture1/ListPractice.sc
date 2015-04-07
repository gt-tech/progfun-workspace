package week5.lecture1

import scala.annotation.tailrec

object ListPractice {
  val givenNames = List("John", "Sachin", "George")
                                                  //> givenNames  : List[String] = List(John, Sachin, George)
  val lastNames = List("Doe", "Ramesh", "Xi")     //> lastNames  : List[String] = List(Doe, Ramesh, Xi)

  // since no element is defined and only double-colons are used entire
  // givenNames list will be preprended to lastNames so new list will have first
  // object as list (aka givenNames list object) followed by 3 string type elements of lastNames
  (givenNames :: lastNames)                       //> res0: List[java.io.Serializable] = List(List(John, Sachin, George), Doe, Ram
                                                  //| esh, Xi)

  // three-colons, a new list with all 3 elements of givenNames followed by
  // all 3 elements of last names.
  (givenNames ::: lastNames)                      //> res1: List[String] = List(John, Sachin, George, Doe, Ramesh, Xi)

  // ++ same as ::
  givenNames ++ lastNames                         //> res2: List[String] = List(John, Sachin, George, Doe, Ramesh, Xi)

  // drop one element from the start
  givenNames drop 1                               //> res3: List[String] = List(Sachin, George)

  // Displays first 2 elements of list
  givenNames take 2                               //> res4: List[String] = List(John, Sachin)

  // a new list in reverse order
  givenNames.reverse                              //> res5: List[String] = List(George, Sachin, John)

  // a new list with "Dixit" replacing the 1st (zero indexed) element
  givenNames updated (1, "Dixit")                 //> res6: List[String] = List(John, Dixit, George)

  lastNames contains "Doe"                        //> res7: Boolean = true

  lastNames contains "not-here"                   //> res8: Boolean = false

  lastNames indexOf "Xi"                          //> res9: Int = 2

  

  def findIndexIgnoreCase(str: String, l: List[String]): Int = {

    @tailrec def loop(list: List[String], i: Int): Int = {
      list match {
        case (x :: Nil) => if (str equalsIgnoreCase x) i else throw new Error(str + " not found")
        case (x :: xs)  => if (str equalsIgnoreCase x) i else loop(xs, i + 1)
        case _          => throw new Error("unexpected condition")
      }
    }
    loop(l, 0)
  }                                               //> findIndexIgnoreCase: (str: String, l: List[String])Int

findIndexIgnoreCase("xi", lastNames)              //> res10: Int = 2
}
package week3.lecture3

// To Test TypesExample_List.scala
object TypesExample_List_WorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val list = new cons(0, new cons(1, new cons(2, new cons(3, new Nil))))
                                                  //> list  : week3.lecture3.cons[Int] = week3.lecture3.cons@40b3c884

  list.get(3)                                     //> res0: Int = 3
  list.get(0)                                     //> res1: Int = 0
  
  list.get(-1)                                    //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.lecture3.cons.iterate$1(TypesExample_List.scala:21)
                                                  //| 	at week3.lecture3.cons.get(TypesExample_List.scala:26)
                                                  //| 	at week3.lecture3.TypesExample_List_WorkSheet$$anonfun$main$1.apply$mcV$
                                                  //| sp(week3.lecture3.TypesExample_List_WorkSheet.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.lecture3.TypesExample_List_WorkSheet$.main(week3.lecture3.Types
                                                  //| Example_List_WorkSheet.scala:4)
                                                  //| 	at week3.lecture3.TypesExample_List_WorkSheet.main(week3.lecture3.TypesE
                                                  //| xample_List_WorkSheet.scala)
}
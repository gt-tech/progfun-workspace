package chapter29.recipe

object testbed {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  println("Welcome to the Scala worksheet");$skip(55); 
  
  val apple = SimpleDatabase.foodNamed("Apple").get;System.out.println("""apple  : chapter29.recipe.Food = """ + $show(apple ));$skip(39); val res$0 = 
  
  SimpleBrowser.recipesUsing(apple);System.out.println("""res0: List[chapter29.recipe.Recipe] = """ + $show(res$0))}
}

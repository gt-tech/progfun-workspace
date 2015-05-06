package chapter29.recipe

object testbed {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val apple = SimpleDatabase.foodNamed("Apple").get
                                                  //> apple  : chapter29.recipe.Food = Apple
  
  SimpleBrowser.recipesUsing(apple)               //> res0: List[chapter29.recipe.Recipe] = List(fruit salad)
}
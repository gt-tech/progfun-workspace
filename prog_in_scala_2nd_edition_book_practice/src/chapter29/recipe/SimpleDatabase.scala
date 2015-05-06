package chapter29.recipe

trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods = List(Apple, Pear)
  def allCategories = Nil
}

trait SimpleRecipes { // Does not compile
  this: SimpleFoods =>
  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear), // Uh oh
    "Mix it all together.")
  def allRecipes = List(FruitSalad)
}

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes
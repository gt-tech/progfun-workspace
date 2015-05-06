package chapter29.recipe

class Recipe(val name: String, val ingredients: List[Food],
             val instructions: String) {

  override def toString: String = name;
}

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")
object FruitSalad extends Recipe(
  "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  "Stir it all together.")
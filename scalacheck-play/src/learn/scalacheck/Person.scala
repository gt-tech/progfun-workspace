package learn.scalacheck

class Person(val firstName: String, val lastName: String, val age: Int) {
  
  def isTeenager: Boolean = (age >= 13 && age <= 19)
  
  override def toString = firstName + " " + lastName + ", age - " + age;
}
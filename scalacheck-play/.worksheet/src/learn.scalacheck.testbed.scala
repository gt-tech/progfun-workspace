package learn.scalacheck

object testbed {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet")

  import org.scalacheck.Prop.forAll
  import org.scalacheck.Gen
  import org.scalacheck.Prop.{forAll, BooleanOperators, all};$skip(242); 

  val propConcatLists = forAll {
    (l1: List[Int], l2: List[Int]) => l1.size + l2.size == (l1 ::: l2).size
  };System.out.println("""propConcatLists  : org.scalacheck.Prop = """ + $show(propConcatLists ));$skip(98); 

  //propConcatLists.check

  val propSqrt = forAll { (n: Int) => scala.math.sqrt(n * n) == n };System.out.println("""propSqrt  : org.scalacheck.Prop = """ + $show(propSqrt ));$skip(225); 

  // will fail since the criteria doesn't hold for -1 or -2
  //propSqrt.check

	// but below shows how to use custom data generator
  val ranged_propSqrt = forAll(Gen.choose(1, 1000)) { n => scala.math.sqrt(n * n) == n };System.out.println("""ranged_propSqrt  : org.scalacheck.Prop = """ + $show(ranged_propSqrt ));$skip(508); 
  //ranged_propSqrt.check
  
  
  // implication generator example to provide guard against. the syntax not working on ==> Implicit operator
  // issue opened on githib, keep pursuing. TODO
  // generated input used for testing
   //val propMakeList = forAll { ( n: Int ) => (n >= 0 && n < 10000) ==> (List.fill(n)("").length == n)}
   
   //val propTrivial = forAll( (n: Int) => (n == 0) ==> (n == 0) )
   
   
    // composite property check
    val prop1 = forAll(Gen.choose(11, 15))( (n: Int) => n > 0 );System.out.println("""prop1  : org.scalacheck.Prop = """ + $show(prop1 ));$skip(65); 
    val prop2 = forAll(Gen.choose(-10, -1))( (n: Int) => n < 0 );System.out.println("""prop2  : org.scalacheck.Prop = """ + $show(prop2 ));$skip(36); 
    
    val prop3 = prop1 && prop2;System.out.println("""prop3  : org.scalacheck.Prop = """ + $show(prop3 ));$skip(31); 
    val prop4 = prop1 || prop2;System.out.println("""prop4  : org.scalacheck.Prop = """ + $show(prop4 ));$skip(340); 
    
   // prop1.check
   // prop2.check
   // prop3.check
   // prop4.check
   
   val propMul = forAll { (n: Int, m: Int) =>
      val res = n*m
      ("evidence = " + res) |: all(
        "div1" |: m != 0 ==> (res / m == n),
        "div2" |: n != 0 ==> (res / n == m),
        "lt1"  |: res > m,
        "lt2"  |: res > n
      )
    };System.out.println("""propMul  : org.scalacheck.Prop = """ + $show(propMul ))}
}

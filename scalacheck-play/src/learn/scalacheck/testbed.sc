package learn.scalacheck

object testbed {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  import org.scalacheck.Prop.forAll
  import org.scalacheck.Gen
  import org.scalacheck.Prop.{forAll, BooleanOperators, all}

  val propConcatLists = forAll {
    (l1: List[Int], l2: List[Int]) => l1.size + l2.size == (l1 ::: l2).size
  }                                               //> propConcatLists  : org.scalacheck.Prop = Prop

  //propConcatLists.check

  val propSqrt = forAll { (n: Int) => scala.math.sqrt(n * n) == n }
                                                  //> propSqrt  : org.scalacheck.Prop = Prop

  // will fail since the criteria doesn't hold for -1 or -2
  //propSqrt.check

	// but below shows how to use custom data generator
  val ranged_propSqrt = forAll(Gen.choose(1, 1000)) { n => scala.math.sqrt(n * n) == n }
                                                  //> ranged_propSqrt  : org.scalacheck.Prop = Prop
  //ranged_propSqrt.check
  
  
  // implication generator example to provide guard against. the syntax not working on ==> Implicit operator
  // issue opened on githib, keep pursuing. TODO
  // generated input used for testing
   //val propMakeList = forAll { ( n: Int ) => (n >= 0 && n < 10000) ==> (List.fill(n)("").length == n)}
   
   //val propTrivial = forAll( (n: Int) => (n == 0) ==> (n == 0) )
   
   
    // composite property check
    val prop1 = forAll(Gen.choose(11, 15))( (n: Int) => n > 0 )
                                                  //> prop1  : org.scalacheck.Prop = Prop
    val prop2 = forAll(Gen.choose(-10, -1))( (n: Int) => n < 0 )
                                                  //> prop2  : org.scalacheck.Prop = Prop
    
    val prop3 = prop1 && prop2                    //> prop3  : org.scalacheck.Prop = Prop
    val prop4 = prop1 || prop2                    //> prop4  : org.scalacheck.Prop = Prop
    
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
    }                                             //> propMul  : org.scalacheck.Prop = Prop
}
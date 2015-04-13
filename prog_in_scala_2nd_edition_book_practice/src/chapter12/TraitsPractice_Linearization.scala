package chapter12

object TraitPractice extends App {

  abstract class Species {
    def name(f: String => Unit)
    def does(f: String => Unit)
  }

  class Bird extends Species {
    def name(f: String => Unit) = {
      f("I am a Bird");
    }
    def does(f: String => Unit) = f("Bird fly");
  }

  abstract class Animal extends Species {
    def name(f: String => Unit) = {
      f("I am Animal")
    }
    def does(f: String => Unit) = {
      f("Animal lives in forest")
    }
  }

  class Cat extends Animal {
    override def name(f: String => Unit) = {
      f("I am a Cat"); super.name(f)
    }
    override def does(f: String => Unit) = {
      f("Cat can climb trees"); super.does(f)
    }
  }

  class Tiger extends Cat {
    override def name(f: String => Unit) = {
      f("I am a Lion"); super.name(f)
    }
    override def does(f: String => Unit) = {
      f("Tiger cannot climb trees");
    }
  }

  trait Fly extends Species {
    abstract override def does(f: String => Unit) {
      f("I fly in sky"); super.does(f)
    }
  }

  trait FourLegged extends Species {
    abstract override def does(f: String => Unit) {
      f("I walk with four legs"); super.does(f)
    }
  }

  trait Carnivorous extends Species {
    abstract override def does(f: String => Unit) {
      f("I am a big carnivorous"); super.does(f)
    }
  }
  
  // let's put to demo
  val cat = new Cat() with FourLegged with Carnivorous
  cat.name( println _ )
  cat.does( x => println(x) ) 
}
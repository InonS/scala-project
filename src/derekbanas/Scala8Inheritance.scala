package derekbanas

import derekbanas.Scala7Classes.Animal

/**
  * Created by admin on 2016-06-04.
  */
object Scala8Inheritance {

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound) {

    // non-default ctor.s
    def this(name: String, sound: String) {
      this(name, sound, "No growl")
    }

    def this(name: String) {
      this(name, "No sound")
    }

    def this() {
      this("No name")
    }

    override def toString(): String = {
      "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
    }
  }

  def main(args: Array[String]) {
    val spike = new Dog("Spike", "Woof", "grrrr")
    println(spike.toString())
  }

}

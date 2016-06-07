package scala1derekbanas

/**
  * Created by admin on 2016-06-04.
  */
object Scala9Polymorphism_AbstractClass {


  // abstract class: no multiple inheritance of state (fields) or implementation (method implementation)
  abstract class Mammal(val name: String) {
    var moveSpeed: Double

    def move: String
  }

  class Wolf(name: String) extends Mammal(name) {
    var moveSpeed = 35.0

    def move = "The wolf %s runs %.2f kph".format(this.name, this.moveSpeed)
  }

  def main(args: Array[String]) {
    val fang = new Wolf("Fang")
    fang.moveSpeed = 36.0
    println(fang.move)
  }
}

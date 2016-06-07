package scala1derekbanas

/**
  * Created by admin on 2016-06-04.
  */
object Scala10Polymorphism_Trait {

  // multiple inheritance of type (interface)
  trait Flyable {
    def fly: String
  }

  trait BulletProof {
    def hitByBullet: String

    // default implementation
    def richochet(startSpeed: Double): String = {
      "The bullet ricoches at a speed of %.1f m/s".format(startSpeed * 0.75)
    }
  }

  class Superhero(val name: String) extends Flyable with BulletProof {
    override def fly: String = "%s flyes through the air".format(this.name)

    override def hitByBullet: String = "The bullet bounces off of %s".format(name)
  }

  def main(args: Array[String]) {
    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.richochet(2500))
  }
}

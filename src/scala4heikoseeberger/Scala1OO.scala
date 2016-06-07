package scala4heikoseeberger

/**
  * Created by admin on 2016-06-06.
  *
  * github.com/hseeberger/scala-in-action
  */
object Scala1OO {

  /**
    * class definition
    *
    * In the class definition (primary ctor.),
    * declaring the class parameters as vals makes them instance immutable fields (with generated accessors). A read-only Scala bean!
    * declaring them as vars makes them mutable fields (with generated accessors and mutators)
    *
    */
  class ScalaTime0(val hours: Int, val minutes: Int)

  /**
    * class members and inheritance
    *
    * inheritance requires implementing the primary ctor.
    *
    * default values can be added
    *
    */
  class ScalaTime1(override val hours: Int = 0, override val minutes: Int = 0) extends ScalaTime0(hours, minutes) {

    // inferred type
    val totMinutes = hours * 60 + minutes

    def minus(that: ScalaTime1) = totMinutes - that.totMinutes
  }

  /**
    * operator overloading
    *
    * Same operator name, refers to different class methods!
    * In other words, Scala has no operators, just methods (and some keywords, such as assignment, i.e. `=`)
    *
    */
  class ScalaTime2(override val hours: Int, override val minutes: Int) extends ScalaTime1(hours, minutes) {

    // infix notation!
    def -(that: ScalaTime2) = this minus that
  }

  /**
    * case class
    *
    * Comparison and equality: default implementations for [[java.lang.Object#hashCode]], equals, compareTo, and even a nicer toString, all based on reflection of the underlying fields    *
    * The [[equals]] method is delegated from the {{{==}}} method.
    *
    * Also, the case class is meant to be immutable (e.g. entity, TO, value, ... ; c.f. Singleton objects),
    * so ctor. parameters are automatically promoted to immutable class fields
    *
    */
  case class ScalaTime3(h: Int, m: Int) extends ScalaTime2(h, m)

  /**
    * overriding methods and string interpolation
    *
    * note: case-to-case inheritance is prohibited
    *
    */
  case class ScalaTime4(hr: Int, min: Int) extends ScalaTime2(hr, min) {
    override def toString = f"$hours%02d:$minutes%02d" // prefix the String with s instead of f if no string formatting is required
  }

  def main(args: Array[String]) {
    val time0 = new ScalaTime0(8, 40)
    println(time0)
    println(time0.hours)

    val time1 = new ScalaTime1(8, 46)
    val time01 = new ScalaTime1(time0.hours, time0.minutes)
    // println(time1.minus(time01))
    println(time1 minus time01)

    println(new ScalaTime1(5).totMinutes) // 5:00
    println(new ScalaTime1(minutes = 5).totMinutes) // 0:05
    println(new ScalaTime1(minutes = 5, hours = 5).totMinutes) // 5:05

    val time2 = new ScalaTime2(8, 48)
    val time12 = new ScalaTime2(time1.hours, time1.minutes)
    println(time2 - time12) // infix notation!

    val time3 = ScalaTime3(8, 50) // using the free factory method from the case class's companion object
    println(time3)
    val time23 = new ScalaTime3(time2.hours, time2.minutes)
    println(time3 == time23)

    val time4 = ScalaTime4(8, 52)
    println(time4)
  }
}


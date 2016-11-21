package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5337parametric.themepark

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */

/**
  * private ctor.
  *
  * @param _values
  * @tparam A
  */
class ToDValues[A] private(private val _values: Array[Option[A]]) {

  def value(hour: Int) = _values(hour)

  def get(hour: Int) = _values(hour).get

  def update(hour: Int, value: Option[A]) {
    _values(hour) = value
  }

  /** reserved/special method name */
  def update(hour: Int, value: A) {
    _values(hour) = Some(value)
  }

  def unapply(arg: ToDValues[A], hour: Int): Option[A] = _values(hour)

  def clear(hour: Int) {
    _values(hour) = None
  }

  def +(other: ToDValues[A]) {

  }

  /**
    * Currying carries type inference forward from first parameter to second.
    */
  def +=?[O, C](other: ToDValues[O])(f: (Option[A], Option[O]) => Option[C]): ToDValues[C] = {
    val ret = ToDValues[C]()
    val merged = (this._values, other._values).zipped map f.apply
    merged.indices foreach (i => ret._values update(i, merged(i)))
    ret
  }
}

object ToDValues extends App {
  val riders1 = ToDValues[Int]()
  val riders2 = ToDValues[Int]()
  val workers1 = ToDValues[String]()
  val workers2 = ToDValues[String]()

  riders1(12) = 5
  riders1(8) = 10
  riders1(14) = 7
  riders2(14) = 8

  val totalRides = (riders1 +=? riders2) (someSum)
  totalRides._values foreach println

  workers1(12) = "Kyle"


  def someSum(o1: Option[Int], o2: Option[Int]): Option[Int] = (o1, o2) match {
    case (None, None) => None
    case (Some(x), None) => Some(x)
    case (None, Some(x)) => Some(x)
    case (Some(x), Some(y)) => Some(x + y)
  }

  def apply[B]() = new ToDValues[B](Array.fill(24)(None))

  def apply[B](vals: B*): ToDValues[B] = {
    val opts = vals.map(Option(_)).toArray
    new ToDValues[B](
      if (opts.length < 24) opts.padTo(24, None)
      else if (opts.length > 24) opts.take(24)
      else opts)
  }
}

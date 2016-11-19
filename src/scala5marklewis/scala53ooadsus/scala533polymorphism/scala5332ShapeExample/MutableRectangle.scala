package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */
class MutableRectangle(protected var _width: Double, protected var _height: Double, val color: Color) extends Shape with Colorful {
  override def area(): Double = _width * _height

  override def perimeter(): Double = 2 * (_width + _height)

  // private member accessors

  def width = _width

  def height = _height

  // private member mutators

  def width_=(w: Double) {
    _width = w
  }

  def height_=(h: Double) {
    _height = h
  }
}

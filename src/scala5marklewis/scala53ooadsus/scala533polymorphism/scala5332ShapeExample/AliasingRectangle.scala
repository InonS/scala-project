package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */

/**
  * Bad Rectangle!
  *
  * Solved by making [[Rectangle]] uninheritable ([final])
  */
class AliasingRectangle(private var _width: Double, private var _height: Double) extends Rectangle(_width, _height, Color.Red) {
  def width_=(w: Double) {
    _width = w
  }

  def height_=(h: Double) {
    _height = h
  }

  override def area(): Double = _width * _height

  override def perimeter(): Double = 2 * (_width + _height)
}

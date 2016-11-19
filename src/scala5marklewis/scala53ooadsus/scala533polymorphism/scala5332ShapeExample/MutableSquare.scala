package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */

/**
  *
  * @param _length not a member.
  *                Used to initialize the (immutable) width & height, and then gets thrown away
  *                (eliminating excess accessor and related confusion)
  */
class MutableSquare(_length: Double, color: Color) extends MutableRectangle(_length, _length, color) {

  override def width_=(w: Double) {
    _width = w
    _height = w
  }

  override def height_=(h: Double) {
    _width = h
    _height = h
  }
}

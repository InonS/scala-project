package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */

/**
  *
  * @param length not a member.
  *               Used to initialize the (immutable) width & height, and then gets thrown away
  *               (eliminating excess accessor and related confusion)
  */
class Square(length: Double, color: Color) extends Rectangle(length, length, color) {

}

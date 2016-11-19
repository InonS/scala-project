package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */
case class Rectangle(width: Double, height: Double, override val color:Color) extends Shape with Colorful {
  override def area(): Double = width * height

  override def perimeter(): Double = 2 * (width + height)

  override def draw(gc: GraphicsContext) {
    super.draw(gc)
    gc.fillRect(0, 0, width, height)
  }
}

package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */
case class Circle(radius: Double, override val color: Color) extends Shape with Colorful {
  override def area(): Double = math.Pi * math.pow(radius, 2)

  override def perimeter(): Double = 2 * math.Pi * radius

  override def draw(gc: GraphicsContext) {
    super.draw(gc)
    gc.fillOval(0, 0, radius, radius)
  }
}

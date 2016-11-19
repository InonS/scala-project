package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */
trait Colorful {
  val color: Color

  def draw(gc: GraphicsContext) {
    gc.fill = color
  }
}

package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5332ShapeExample

import scalafx.scene.paint.Color

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */
abstract class Shape extends Colorful {
  def area(): Double

  def perimeter(): Double
}

object ShapeExample {
  def main(args: Array[String]) {
    printShapeData(Circle(3, Color.Black))
    printShapeData(Rectangle(3, 4, Color.Black))
    printShapeData(new Square(5, Color.Black))

    val mutableSquare = new MutableSquare(5, Color.Black)
    mutableSquare.width = 99

    /** STOP! What does this MEAN?!
      *
      * MutableSquare should NOT inherit MutableRectangle
      * because a Rectangle is allowed to mutate in ways that a Square is not.
      *
      * This means that calling one of the MutableRectangle mutators on a MutableSquare
      * may yield non-trivial results.
      */
    printShapeData(mutableSquare)

    /*    val canvas = new Canvas(1024, 768)
        val delegate = canvas.getGraphicsContext2D
        val gc = new scalafx.scene.canvas.GraphicsContext(delegate)
        mutableSquare.draw(gc)
        gc.wait(5)*/
  }

  def printShapeData(s: Shape) {
    println(s"Area = ${s.area()}")
    println(s"Perimeter = ${s.perimeter()}")
  }
}

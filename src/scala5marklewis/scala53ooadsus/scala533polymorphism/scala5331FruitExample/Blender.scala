package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5331FruitExample

/**
  * scala-project
  * Created by admin on 2016-11-19.
  */
class Blender {

  def +=(content: Liquifiable): Blender = {
    // inc. liquid content
    this
  }

  def blend() {

  }


  def makeBreakfastShake[F <: Fruit](fruit: Fruit, juice: Juice[F]) {
    if (!fruit.canEatSkin) fruit peel()
    this += fruit
    this += juice

    if (fruit.fractionalLiquidContent < 0.3)
      this += juice

    this += new Ice()

    blend()
  }

  def main(args: Array[String]) {
    makeBreakfastShake(new Banana, new Juice[Apple])
    makeBreakfastShake(new Apple, new Juice[Orange])
  }
}

package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5331FruitExample

/**
  * Default (Template) Project
  * Created by admin on 2016-11-19.
  */
class Banana() extends Fruit {

  var isPeeled = false

  override def canEatSkin: Boolean = false

  override def fractionalLiquidContent: Double = {
    val flc = super.fractionalLiquidContent
    if (isPeeled) flc - 0.1 else flc + 0.1
  }

  override def peel(): Skin = {
    isPeeled = true
    new BananaSkin()
  }
}

class BananaSkin() extends Skin

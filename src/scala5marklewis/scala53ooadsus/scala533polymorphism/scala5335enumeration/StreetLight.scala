package scala5marklewis.scala53ooadsus.scala533polymorphism.scala5335enumeration

import scala5marklewis.scala53ooadsus.scala533polymorphism.scala5335enumeration.StreetLightColor._

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */
class StreetLight(private var _color: StreetLightColor.Value) {

  /** accessor */
  def color = _color

  /** mutator */
  def color_=(c: StreetLightColor.Value) {
    _color = c
  }

  def cycle() {
    _color = _color match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
  }


}

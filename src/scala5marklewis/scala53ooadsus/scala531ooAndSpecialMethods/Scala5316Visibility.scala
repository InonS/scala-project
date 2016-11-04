package scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods

/**
  * scala-project
  * Created by admin on 2016-11-05.
  */
object Scala5316Visibility {

  class PublicClass

  private class PrivateClass

  private[scala53ooadsus] class PackagePrivateClass

  /** private + inheriting */
  protected class ProtectedClass

  protected[scala5marklewis] class PackageProtectedClass

  class ScopingClass {

    /** scoped by class: Visible only to instances of this class, not to inheriting ones */
    private[ScopingClass] class ScopedPrivateClass

    /** scoped by instance: Visible only to inheriting objects, not to others of same class */
    protected[this] class ScopedProtectedClass
  }
}

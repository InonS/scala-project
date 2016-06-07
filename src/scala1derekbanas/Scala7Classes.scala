package scala1derekbanas

/**
  * Created by admin on 2016-06-04.
  */
object Scala7Classes {

  // define class and primary (default) ctor.
  class Animal(var name: String, var sound: String) {
    this.setName(name)
    // initializer (block). Instead of needing: protected var name = "No Name"

    // call static method
    val id = Animal.newIdNum

    // accessors
    def getName(): String = name

    def getSound(): String = sound

    // mutators
    def setName(name: String) {
      if (!name.matches(".*\\d+.*")) // don't allow numbers in name
        this.name = name
      else
        this.name = "No Valid Name"
    }

    def setSound(sound: String) {
      this.sound = sound
    }

    // non-default ctor.s
    def this(name: String) {
      this(name, "No Sound")
    }

    def this() {
      this("No Name")
    }

    override def toString(): String = {
      "%s with the id %d says %s".format(this.name, this.id, this.sound)
    }
  }

  /**
    * companion object to Animal class:
    * A Singleton holding all static class members & methods.
    * The class definition holds all instance members & methods.
    */
  object Animal {
    private var idNumber = 0

    private def newIdNum = {
      idNumber += 1; idNumber
    }
  }

  def main(args: Array[String]) {

    val rover = new Animal
    rover.setName("Rover")
    rover.setSound("Woof")
    printf("%s says %s\n", rover.getName(), rover.getSound())

    val whiskers = new Animal("Whiskers", "Meow")
    // interpolated string
    println(s"${whiskers.getName()} with id ${whiskers.id} says ${whiskers.getSound()}")
    println(whiskers.toString())
    whiskers.setName("Whiskers1")
    println(whiskers.getName())
    whiskers.setName("WhiskersOne")
    println(whiskers.getName())

  } // end main

}

// end Scala7Classes

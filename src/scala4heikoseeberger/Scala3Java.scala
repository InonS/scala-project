package scala4heikoseeberger

/**
  * scala-project
  * Created by admin on 2016-06-07.
  */
object Scala3Java {

  case class Cell(x: Int, y: Int) {
    def neighbors: Set[Cell] = {
      val neighbors =
        for {
          xx <- x - 1 to x + 1 // look at xs from x-1 to x+1
          yy <- y - 1 to y + 1 // same for ys
          if xx != x || yy != y // exclude (x,y) itself
        } yield Cell(xx, yy) // get all such cells
      neighbors.toSet // convert to expected return type (Set)
    }
  }

  class Generation(val liveCells: Set[Cell] = Set.empty) {
    def next: Generation = new Generation(stayAlive ++ born)  // collection union is ++, XOR is +

    def stayAlive: Set[Cell] = liveCells filter isStayAlive

    def isStayAlive(cell: Cell): Boolean = Set(2, 3) contains livingNeighbors(cell).size

    def livingNeighbors(cell: Cell): Set[Cell] = cell.neighbors intersect liveCells

    /**
      * liveCells flatMap deadNeighbors filter isToBeBorn
      */
    def born: Set[Cell] = liveCells flatMap (cell => cell.neighbors) flatMap birthingNeighbors

    def isToBeBorn(cell: Cell): Boolean = cell.neighbors.size == 3

    def birthingNeighbors(cell: Cell): Set[Cell] = cell.neighbors filter isToBeBorn filterNot liveCells

    def deadNeighbors(cell: Cell): Set[Cell] = cell.neighbors diff liveCells
  }

  def main(args: Array[String]) {

  }
}

package derekbanas

/**
  * Created by admin on 2016-05-30.
  */
object Scala5Maps {
  def main(args: Array[String]) {

    // explicit immutable map constructor initialization
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Brown")

    if (employees.contains("Manager"))
    // accessing map element
      printf("Manager: %s\n", employees("Manager"))

    // iterating over key-value pairs
    for ((k, v) <- employees) {
      printf("%s: %s\n", k, v)
    }

    // mutable map
    val customers = collection.mutable.Map(100 -> "Paul Smith", 101 -> "Sally Smith")

    val key = 100
    printf("Customer %d: %s\n", key, customers(key))

    // mutating mutable map element
    customers(key) = "Tom Marks"

    // inserting mutable map element
    customers(102) = "Megan Swift"


  }
}

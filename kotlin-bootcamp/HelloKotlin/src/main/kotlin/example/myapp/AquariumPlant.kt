package example.myapp

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen : Boolean
    get() = color == "green"

fun AquariumPlant?.pull(){
    this?.apply {
        println("removing $this")
    }
}

fun main(){

    /*val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?

    println(aquariumPlant.isGreen)*/

    val plant: AquariumPlant? = null
    plant.pull()
}

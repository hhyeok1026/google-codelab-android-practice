package example

data class Fish(var name: String)

fun fishExamples(){
    val fish = Fish("splashy")
    /*myWith(fish.name){
        println(capitalize())
    }
    fish.run { name }

    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println(fish2.name)
*/
    println(fish.let { it.name.capitalize() }
        .let { it+"fish" }
        .let{it.length}
        .let { it+31 }
    )
    println(fish)
}

fun myWith(name: String, block: String.() -> Unit)
{
    name.block()
}

fun main(){
    //fishExamples()
    runExample()
}

fun runExample(){
    /*val runnable = object: Runnable{
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)*/

    JavaRun.runNow{
        println("Passing a lamda as a Runnable")
    }
}
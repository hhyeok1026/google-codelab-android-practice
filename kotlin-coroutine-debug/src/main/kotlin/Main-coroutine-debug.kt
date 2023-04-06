import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    val a = async {
        println("I'm computing part of the answer")
        6
    }
    val b = async {
        println("I'm computing another part of the answer")
        delayA()
        7
    }
    println("The answer is ${ a.await() * b.await() }")
}

suspend fun delayA() {
    val a = 1L
    delay(a)
    println("Slept for 1ms")
}
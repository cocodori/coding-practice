package kotlininaction.ch3

infix fun String.add(str: String) = this.plus(str)

fun main() {
    val infix = "infix"
    println(infix add " function!")
}
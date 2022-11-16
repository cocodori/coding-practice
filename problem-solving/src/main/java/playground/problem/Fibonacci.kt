package playground.problem

fun fibonacci(k: Int): Int {
    if (k <= 1) {
        return k
    }

    var first = 1
    var second = 0
    var result = 0

    for (i in 0 until k) {
        result = first + second
        second = first
        first = result
    }

    return result
}

fun main() {
    for (i in 0..10) {
        println(fibonacci(i))
    }
}
package playground.functionalkotlin.ch03

fun main() {
    println(toBinary(10))
}

fun toBinary(n: Int): Int {
    if (n <= 0) return n

    val binary = "${n % 2}"
    val divide = toBinary(n / 2)

    return (divide.toString() + binary).toInt()
}
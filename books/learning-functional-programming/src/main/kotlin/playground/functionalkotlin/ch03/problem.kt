package playground.functionalkotlin.ch03

fun main() {
    println(factorial(n = 10))
    println(power(x = 3.0, 10))
}

// 3-2 X의 n을 구하는 재귀 함수
/*
    x * power(x, n-1)
    x * power(x, n-1) * power(x, n-1)
    x * power(x, n-1) * power(x, n-1) * power(x, n-1)
    x * power(x, n-1) * power(x, n-1) * power(x, n-1) * power(x, n-1)
    x * power(x, n-1) * power(x, n-1) * power(x, n-1) * x
    x * power(x, n-1) * power(x, n-1) * x * x
    x * power(x, n-1) * x * x * x
    x * x * x * x * x
 */
fun power(x: Double, n: Int): Double {
    return when (n <= 1) {
        true -> x
        else -> x * power(x, n-1)
    }
}

fun factorial(n: Int): Int {
    if (n <= 2) return n
    return n * factorial(n-1)
}


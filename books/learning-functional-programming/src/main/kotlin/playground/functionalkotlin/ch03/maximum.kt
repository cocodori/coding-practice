package playground.functionalkotlin.ch03

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)

fun main() {
    val listOf = listOf(1, 3, 2, 4, 8)
}

fun maximum(items: List<Int>): Int = when {
    items.isEmpty() -> error("empty list")
    1 == items.size -> items[0]
    else -> {
        val head = items.head()
        val tail = items.tail()
        val maxValue = maximum(tail)
        if (head > maxValue) head else maxValue
    }
}
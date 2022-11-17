package playground.functionalkotlin.ch03

fun String.head() = first()
fun String.tail() = drop(1)

fun main() {
    println(reverse("abcd"))
}

/*
    "abcd" -> "dcb" + "a"
    "bcd" -> "dc" + "b"
    "cd" -> "d" + "c"
    "d" -> "" + "d"
    ""
 */
fun reverse(s: String): String = when {
    s.isEmpty() -> ""
    else -> reverse(s.tail()) + s.head()
}

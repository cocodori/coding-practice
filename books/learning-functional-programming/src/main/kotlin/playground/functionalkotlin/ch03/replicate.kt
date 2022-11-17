package playground.functionalkotlin.ch03

/**
 * 숫자 두개를 입력 받은 후 두 번째 숫자를 처음 숫자만큼 가지고 있는 리스트를 반환하는 함수
 */
fun replicate(n: Int, element: Int): List<Int> {
    if (n <= 1) return listOf(element)

    val replicate = replicate(n - 1, element)
    val list = mutableListOf(element)
    list.addAll(replicate)

    return list
}

fun main() {
    println(replicate(10, 10))
}
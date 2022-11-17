package playground.functionalkotlin.ch02

fun <T, R> customWith(receiver: T, block: T.() -> R): R = receiver.block()

data class TestCh03(
    var name: String,
    var age: Int
)

fun main() {
    val test = TestCh03("ACK", 10)

    val customWith = customWith(test) {
        name = "Lemon-Ade"
        age = 100
    }

    println(with(test) {
        name = "real with"
        return@with this
    })
}
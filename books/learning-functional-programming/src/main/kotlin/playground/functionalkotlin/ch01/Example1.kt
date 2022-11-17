package playground.functionalkotlin.ch01

/**
 * 1-14. 함수형 프로그래밍 계산기
 */
fun main() {
    val fpCalculator = FpCalculator()
    println(fpCalculator.calculate({ n1, n2 -> n1 + n2 }, 3, 1))
    println(fpCalculator.calculate({ n1, n2 -> n1 - n2 }, 3, 1))
}

class FpCalculator {
    fun calculate(
        calculator: (Int, Int) -> Int,
        num1: Int, num2: Int
    ) = calculator(num1, num2)
}
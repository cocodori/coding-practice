package programmers.level1

fun main() {
    println(NumberString().solution("one4seveneight")) // 1478
    println(NumberString().solution("23four5six7")) // 234567
    println(NumberString().solution("2three45sixseven")) // 234567
    println(NumberString().solution("123")) // 123
}

class NumberString {

    fun solution(s: String): Int {
        val result = StringBuilder()

        var index = 0
        while (true) {
            if (index >= s.length)
                break

            val char = s[index]

            val charToDigit = char.digitToIntOrNull()

            if (charToDigit != null) {
                result.append(charToDigit)
                index++
                continue
            }

            val firstAndSecond =
                if (index == s.length - 1)
                    s[index].toString()
                else
                    "${s[index]}${s[index + 1]}"
            val numbers = Numbers.of(firstAndSecond)
            index += numbers.spellingLength
            result.append(numbers.number)
        }

        return result.toString().toInt()
    }

    enum class Numbers(
        val number: Int,
        val spellingLength: Int
    ) {
        ZERO(number = 0, spellingLength = 4),
        ONE(number = 1, spellingLength = 3),
        TWO(number = 2, spellingLength = 3),
        THREE(number = 3, spellingLength = 5),
        FOUR(number = 4, spellingLength = 4),
        FIVE(number = 5, spellingLength = 4),
        SIX(number = 6, spellingLength = 3),
        SEVEN(number = 7, spellingLength = 5),
        EIGHT(number = 8, spellingLength = 5),
        NINE(number = 9, spellingLength = 4),
        ;

        companion object {
            fun of(str: String): Numbers {
                return when (str) {
                    "ze" -> ZERO
                    "on" -> ONE
                    "tw" -> TWO
                    "th" -> THREE
                    "fo" -> FOUR
                    "fi" -> FIVE
                    "si" -> SIX
                    "se" -> SEVEN
                    "ei" -> EIGHT
                    "ni" -> NINE
                    else -> throw IllegalArgumentException()
                }
            }
        }
    }
}




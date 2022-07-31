package programmers.level1.숫자_문자열과_영단어

fun main() {
    println(NumberString().solution("one4seveneight")) // 1478
    println(NumberString().solution("23four5six7")) // 234567
    println(NumberString().solution("2three45sixseven")) // 234567
    println(NumberString().solution("123")) // 123
}

/**
 * 내 풀이
 */
class NumberString {

    fun solution(s: String): Int {
        val result = StringBuilder()

        var index = 0

        while(true) {

            if (index >= s.length) break

            val char = s[index] //문자열의 i번째 문자

            //char를 Int로 캐스팅. 캐스팅할 수 없는 type이면 null 반환
            val charToDigit = char.digitToIntOrNull()

            //char가 숫자라면 그대로 결과에 삽입
            if (charToDigit != null) {
                result.append(charToDigit)
                index++
                continue
            }

            //문자열일 때
            //첫 두글자. one이라면 on, three라면 th
            val firstAAndSecond = "${s[index]}${s[index+1]}"
            //첫 두글자를 이용해서 어떤 숫자인지 판단
            val number = Numbers.of(firstAAndSecond)
            //결과에 숫자를 담는다.
            result.append(number.number)

            //index를 숫자의 영어 스펠링 개수 만큼 늘린다.(one이라면 +3, three라면 +5)
            index += number.spellingLength

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

        //첫 두글자를 받아서 알맞은 enum을 반환
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



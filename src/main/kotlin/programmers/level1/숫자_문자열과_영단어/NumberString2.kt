package programmers.level1.숫자_문자열과_영단어

/**
 * 다른 사람 풀이
 * replace를 사용해 훨씬 쉽게 풀 수 있었다.
 */

fun main() {
    println(NumberString2().solution("one4seveneight")) // 1478
    println(NumberString2().solution("23four5six7")) // 234567
    println(NumberString2().solution("2three45sixseven")) // 234567
    println(NumberString2().solution("123")) // 123
}

class NumberString2 {

    fun solution(
        s: String
    ): Int {
        var answer = s
        val dict = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )

        for ((k,v) in dict) {
            //answer에 있는 k(영어 문자열)을 v(숫자)로 변경
            answer = answer.replace(k, v.toString())
        }

        return answer.toInt()
    }

}
package playground.problem.leetcode.reverseword3

/*
 문자열 `s`가 주어지면 각 단어를 거꾸로 뒤집어라.
 공백과 단어 순서를 유지해야 한다.

 example:
    input "Let's take LeetCode contest"
    output "s'teL ekat edoCteeL tsetnoc"

 1. whitespace split
 2. 공백 기준으로 나누어진 배열들을 각각 모두 반대로 뒤집느다.
 3. 순서대로 합친다.
*/
class Solution {
    fun reverseWords(s: String): String {
        val strArr = s.split(" ")
        val builder = StringBuilder()

        for ((i, str) in strArr.withIndex()) {
            val charArr = str.toCharArray()
            var leftPointer = 0
            var rightPointer = charArr.size - 1

            while (leftPointer <= rightPointer) {
                if (charArr[leftPointer] == charArr[rightPointer]) {
                    leftPointer++
                    rightPointer--
                    continue
                }

                val temp = charArr[leftPointer]
                charArr[leftPointer++] = charArr[rightPointer]
                charArr[rightPointer--] = temp
            }

            val whitespace = if (i == strArr.lastIndex) "" else " "
            builder.append(String(charArr))
                .append(whitespace)
        }


        return builder.toString()
    }
}

fun main() {
    println(Solution().reverseWords("Let's take LeetCode contest"))
}
package leetcode.permutationinstring

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        //s2의 substring을 담을 hashMap
        val map = mutableMapOf<Char, Int?>()

        //substring 시작 인덱스
        var startIndex = -1

        while ((startIndex + s1.length) < s2.length) {
            startIndex++
            map.clear()

            //s2의 substring
            val s2Sub = s2.substring(startIndex, startIndex+s1.length)

            //substring 한 문자씩 map에 insert
            for(sub in s2Sub) {
                println(sub)
                map[sub] = map[sub]?.plus(1) ?: 1
            }

            println()

            //s1의 각 문자가 map에 있는지 확인
            for (i in s1.indices) {
                if (map[s1[i]] == null || map[s1[i]]!! <= 0) break

                map[s1[i]] = map[s1[i]]?.minus(1)

                if(i == s1.length-1)
                    return true

            }
        }

        return false
    }
}

fun main() {
    println(Solution().checkInclusion("hello", "ooolleoooleh"))
}
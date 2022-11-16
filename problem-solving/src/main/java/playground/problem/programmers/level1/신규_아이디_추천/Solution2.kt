package playground.problem.programmers.level1.신규_아이디_추천

import java.lang.StringBuilder


class Solution2 {
    fun solution(newId: String): String {
        return newId
            .lowercase()
            .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
            .replace("[.]*[.]".toRegex(), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .let {
                it.ifBlank { "aaa" }
            }
            .let {
                (if (it.length > 15)
                    it.substring(0 until 15)
                else
                    it).removeSuffix(".")
            }
            .let {
                if (it.length <= 2) {
                    StringBuilder(it).run {
                        while (length < 3)
                            append(it.last())
                        toString()
                    }
                } else {
                    it
                }
            }
    }
}

fun main() {
    println(Solution2().solution("...!@BaT#*..y.abcdefgh.ijklm"))
    println(Solution2().solution("...!@BaT#*..y.abcdefghijklm"))
    println(Solution2().solution("123_.def"))
}
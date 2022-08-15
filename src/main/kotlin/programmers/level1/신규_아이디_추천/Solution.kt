package programmers.level1.신규_아이디_추천


// 유저 아이디를 생성하는 업무.
// 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 유사한 아이디를 추천하는 프로그램
// **규칙**
// - 아이디의 길이는 3~15자 사이여야 한다.
// - 아이디는 알파벳 소문자, -, _, . 문자만 사용할 수 있다.
// - 마침표는 처음과 끝에 사용할 수 없고, 연속으로 사용할 수 없다.
// 7단계의 순차적인 처리 과정을 통해 규칙에 맞는지 검사하고, 맞지 않다면 새로운 아이디를 추천하려고 한다.
// 신규 유저가 입력한 아이디가 `new_id`라고 한다면,
// 1단계: `new_id`의 모든 대문자를 소문자로 치환
// 2단계: `new_id`에서 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자를 제거한다.
// 3단계: `new_id`에서 마침표가 두 번 이상 연속된 부분을 하나의 마침표로 치환한다.
// 4단계: `new_id`에서 마침표가 처음이나 끝에 위치한다면 제거한다.
// 5단계: `new_id`가 빈 문자열이라면, `new_id`에 "a"를 대입한다.
// 6단계: `new_id`의 길이가 16자 이상이라면 `new_id`의 첫 15개 문제를 제외한 나머지 문자를 모두 지운다.
// 7단계: `new_id`의 길이가 2자 이하라면, `new_id`의 마지막 문자를 `new_id`의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
class Solution {
    fun solution(newId: String): String {
        //1단계: 대문자 -> 소문자 치환
        var newId = newId.lowercase()

        //2단계: `new_id`에서 알파벳 소문자, 숫자, -, _, .를 제외한 문자 모두 제거
        newId = removeStr(newId)

        //3단계: `new_id`에서 마침표가 두 번 이상 연속된 부분을 하나의 마침표로 치환
        newId = replaceContinualDot(newId)

        //4단계: `new_id`에서 마침표가 처음, 끝에 위치한다면 제거
        newId = replacePrefixAndSuffix(newId)

        //5단계: `new_id`가 빈 문자열이면 a를 대입
        if (newId.isBlank()) {
            newId = "aaa"
        }

        //6단계: `new_id`의 길이가 16자 이상이라면 첫 15개 제외한 뒤 모두 지운다.
        if (newId.length > 15) {
            newId = newId.substring(0, 15)
            newId = newId.removeSuffix(".")
        }

        //7단계: `new_id`의 길이가 2자 이하라면, `new_id`의 마지막 문자를 `new_id`의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        newId = makeMinimumId(newId)

        return newId
    }

    //2
    private fun removeStr(newId: String): String {
        var result: String = newId
        val allowedChars = mutableListOf('-', '_', '.')

        for (c in 'a'..'z') {
            allowedChars.add(c)
        }

        for (i in '0'..'9') {
            allowedChars.add(i)
        }

        for (c in result) {
            if (!allowedChars.contains(c)) {
                result = result.replace("$c", "")
            }
        }

        return result
    }

    //3
    private fun replaceContinualDot(newId: String): String {
        var replaceId = newId
        while (true) {
            if (!replaceId.contains("..")) {
                break
            }
            replaceId = replaceId.replace("..", ".")
        }

        return replaceId
    }

    //4
    private fun replacePrefixAndSuffix(newId: String): String {
        var result = newId
        result = result.removePrefix(".")
        result = result.removeSuffix(".")
        return result
    }

    //7
    private fun makeMinimumId(newId: String): String {
        if (newId.length >= 3) return newId
        var minimumId = newId
        while (true) {
            if (minimumId.length >= 3)
                return minimumId

            minimumId += newId.last()
        }
    }
}

fun main() {
    println(Solution().solution("...!@BaT#*..y.abcdefgh.ijklm"))
    println(Solution().solution("...!@BaT#*..y.abcdefghijklm"))
    println(Solution().solution("123_.def"))
}
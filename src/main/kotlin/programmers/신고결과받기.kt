package programmers

fun main() {
    Solution().solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2)
}

class Solution {
    fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {

        val users = mutableSetOf<User>()

        //id를 User에 저장
        for (id in idList) {
            users.add(User(id))
        }

        for (r in report) {
            val split = r.split(" ")
            val reporter = split[0] //신고자
            val reported = split[1] //신고 당한 사람

            val reportUser = users.find { it.name == reporter }!!
            val reportedUser = users.find { it.name == reported }!!

            reportUser.addReport(reportedUser)
        }

        users.filter { it.isVen(k) }
            .forEach {
                it.reported.forEach { it.sendMail() }
            }

        return users.map { it.mailCount }.toIntArray()
    }
}

data class User(
    val name: String
) {
    var mailCount: Int = 0
    val reported = mutableSetOf<User>() //나를 신고한 사람
    private var report = mutableSetOf<User>() //내가 신고한 사람

    fun addReport(report: User) {
        this.report.add(report)
        report.addReported(this)
    }

    private fun addReported(user: User) {
        this.reported.add(user)
    }

    fun isVen(k: Int): Boolean =
        this.reported.size >= k

    fun sendMail() {
        this.mailCount++
    }
}

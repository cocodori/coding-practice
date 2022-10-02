package programmers.level2.순위검색

fun main() {
    Solution().solution(
        arrayOf("java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"),
        arrayOf("java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150")
    )
}

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        // 1. 지원자 리스트 생성
        val applicants = mutableListOf<Applicant>();
        saveAll(info, applicants)

        // 2. 쿼리 리스트 생성
        val querys = mutableListOf<Query>()
        createQuery(query, querys)
        println(querys)

        // 3. 각 쿼리를 지원자 리스트에 질의해보고, 결과 개수를 기록
        val q = querys.map { query ->
            val count = applicants.count { applicant ->
                val isSatisfiedLang = query.language?.let {
                    it == applicant.language
                } ?: true
                val isSatisfiedPosition = query.position?.let {
                    it == applicant.position
                } ?: true
                val isSatisfiedLevel = query.level?.let {
                    it == applicant.level
                } ?: true
                val isSatisfiedFood = query.soulFood?.let {
                    it == applicant.soulFood
                } ?: true
                val isSatisfiedScore = query.score?.let {
                    it <= applicant.score
                } ?: true

                isSatisfiedLang && isSatisfiedPosition && isSatisfiedLevel && isSatisfiedFood && isSatisfiedScore
            }



            count
        }

        println(q)

        return intArrayOf()
    }

    private fun saveAll(info: Array<String>, applicants: MutableList<Applicant>) {
        for (data in info) {
            val split = data.split(" ")
            applicants.add(
                Applicant(
                    language = split[0],
                    position = split[1],
                    level = split[2],
                    soulFood = split[3],
                    score = split[4].toInt()
                )
            )
        }
    }

    private fun createQuery(queryArray: Array<String>, querys: MutableList<Query>) {
        for (query in queryArray) {
            val query = query.replace(" and", "")
            val split = query.split(" ")

            querys.add(
                Query(
                    language = if (split[0] == "-") null else split[0].trim(),
                    position = if (split[1] == "-") null else split[1].trim(),
                    level = if (split[2] == "-") null else split[2].trim(),
                    soulFood = if (split[3] == "-") null else split[3].trim(),
                    score = if (split[4] == "-") null else split[4].trim().toInt()
                )
            )
        }
    }
}

data class Applicant(
    val language: String,
    val position: String,
    val level: String,
    val soulFood: String,
    val score: Int
)

data class Query(
    val language: String?,
    val position: String?,
    val level: String?,
    val soulFood: String?,
    val score: Int?
)

// 1. 지원자 정보를 담은 데이터 클래스를 정의한다.
// 2. 배열 info를 파싱하여 지원자 리스트에 저장한다.
// 3. 쿼리를 파싱하여 검색 조건을 찾는다.
// 4. 지원자 리스트에서 대상을 찾는다.
// * 너무 느려지지 않을까? Hash 같은 걸 이용할 순 없나? 최대 10만 개의 쿼리가 들어올 수도 있는데.


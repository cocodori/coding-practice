package programmers.피로도

class Solution2 {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val isVisited = BooleanArray(dungeons.size)
        val result = mutableListOf(0)

        dfs(dungeons, isVisited, k, depth=0, result)

        return result[0]
    }

    private fun dfs(
        dungeons: Array<IntArray>,
        isVisited: BooleanArray,
        k: Int,
        depth: Int,
        result: MutableList<Int>
    ) {
        for ((i, d) in dungeons.withIndex()) {
            if (result[0] == dungeons.size) break
            if (isVisited[i] || d[0] > k) continue
            isVisited[i] = true
            dfs(dungeons, isVisited, k - d[1], depth=depth+1, result)
            isVisited[i] = false
        }

        result.add(maxOf(result.removeAt(0), depth))
    }
}
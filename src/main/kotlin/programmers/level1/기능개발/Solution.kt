package programmers.level1.기능개발

import java.util.LinkedList
import java.util.Queue
import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        //남은 날짜 계산해서 Queue에 입력
        for (i in progresses.indices) {
            val progress = progresses[i]
            val speed = speeds[i]
            val remainingDays = ceil((100.0-progress) / speed).toInt()
            queue.offer(remainingDays)
        }

        val result = mutableListOf<Int>()
        var deployedCount = 1

        //남은 날짜
        var remainingDays = queue.poll()

        while (remainingDays != null) {
            val next: Int? = queue.peek()
            //queue의 다음 요소가 남은 일수보다 작다면 이미 끝난 작업
            if (next != null && remainingDays >= next) {
                queue.poll()
                deployedCount++
            } else { //완료되지 않은 작업
                result.add(deployedCount)
                deployedCount = 1
                remainingDays = queue.poll()
            }
        }

        return result.toIntArray()
    }
}

fun main() {
    println(Solution().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).contentToString())
    println(Solution().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)).contentToString())
    println(Solution().solution(intArrayOf(99, 99, 99, 90, 90, 90), intArrayOf(1,1,1,1,1,1)).contentToString())
}
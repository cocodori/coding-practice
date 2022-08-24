package leetcode.sqauresofasortedarray

import kotlin.math.abs

class Solution {
    fun sortedSquares(
        nums: IntArray
    ): IntArray {
        val size = nums.size

        val result = IntArray(size)
        var start = 0
        var end = size-1
        var idx = size-1

        while (start <= end) {
            //start번째 요소와 end번째 요소 절댓값 비교
            if (abs(nums[start]) > abs(nums[end])) {
                result[idx--] = nums[start] * nums[start]
                start++
            } else {
                result[idx--] = nums[end] * nums[end]
                end--
            }
        }

        return result
    }
}

fun main() {
    println(Solution().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentToString())

}
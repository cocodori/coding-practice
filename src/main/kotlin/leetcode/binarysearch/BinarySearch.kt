package leetcode.binarysearch

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1
        var pivot = 0

        while (left <= right) {
            pivot = left + (right-left) / 2
            println("pivot=$pivot, left=$left, right=$right")
            println("pivot = $left + ($right-$left) / 2 = ${left + (right-left) / 2}")
            println()

            if (nums[pivot] == target)
                return pivot

            if (target < nums[pivot])
                right = pivot-1
            else
                left = pivot+1
        }

        return -1
    }
}

fun main() {
    println(Solution().search(intArrayOf(-1,0,3,5,9,12), target = 0))
}
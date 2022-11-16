package playground.problem.leetcode.rotatearray

/*
 배열이 주어지면 k단계 만큼 회전시켜라. k는 음수가 아니다.
 제자리에서 해결할 수 있는가?

 맨 뒷자리 숫자를 k번 만큼 맨 앞으로 보낸다.
 과정
 1. 맨 뒷자리 숫자를 지운다.
 2. 맨 앞부터 맨 뒷자리 숫자까지 오른쪽으로 한 칸씩 자리 이동시킨다.
 3. 맨 뒷자리 수를 맨 앞에 삽입한다.
*/
class Solution {
    fun rotate(nums: IntArray, k: Int): IntArray {
        val nums: IntArray = nums

        nums.shfitToRight(k)

        return nums
    }
}

//k번 만큼 오른쪽으로 이동
private fun IntArray.shfitToRight(k: Int) {
    if (this.isEmpty()) return
    val lastIndex = this.size - 1

    repeat(k) {
        val last = this[lastIndex]
        var prev = this[0]
        this[0] = last

        for (i in 1 until this.size) {
            val temp = this[i]
            this[i] = prev
            prev = temp

        }
    }
}
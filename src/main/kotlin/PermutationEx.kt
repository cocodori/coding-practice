class BacktrackingEx1 {

    fun permute(nums: IntArray) {
        val result = mutableListOf<MutableList<Int>>()

        backtracking(nums, result, mutableListOf<Int>())

        println(result)
    }

    private fun backtracking(
        nums: IntArray,
        result: MutableList<MutableList<Int>>,
        list: MutableList<Int>
    ) {
        if (list.size == nums.size) {
            result.add(ArrayList(list))
            return
        }

        for (num in nums) {
            if (list.contains(num))
                continue

            val c = "adsa"[0]

            list.add(num)
            backtracking(nums, result, list)
            list.remove(list.size - 1)
        }
    }
}

fun main() {
    BacktrackingEx1().permute(intArrayOf(1, 7))

    val str = "hello"


    println(str[0])


}
package playground.problem.leetcode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(4)
    root.right = TreeNode(6)

    val solution = Solution()
    val checkTree = solution.checkTree(root)
    println("checkTree = $checkTree")
}

class Solution() {
    fun checkTree(root: TreeNode?): Boolean {
        return root!!.`val` == root.left?.`val`!! + root.right?.`val`!!
    }
}
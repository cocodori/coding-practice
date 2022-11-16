package playground.problem.programmers.level1.키패드_누르기

import kotlin.math.abs

class Solution2 {

    fun solution(
        numbers: IntArray, hand: String
    ): String {
        val answer = StringBuilder()
        var left = Position(3, 0)
        var right = Position(3,2)
        //찾을 숫자의 위치
        var numPos: Position

        for (num in numbers) {
            //찾을 숫자의 위치 계산
            numPos = Position((num-1)/3 , (num-1)%3)
            //0일 때는 직접 처리해야 함
            if (num == 0) {
                numPos = Position(3, 1)
            }

            val finger = numPos.getFinger(hand, left, right)

            answer.append(finger)

            //left or right의 위치를 갱신
            if (finger == "L") {
                left = numPos
            } else {
                right = numPos
            }
        }

        return answer.toString()
    }

    //손의 위치를 담는 객체
    inner class Position(
        var row: Int,
        var col: Int
    ) {

        fun getFinger(hand: String, left: Position, right: Position): String {
            //주로 쓰는 손이 default
            var finger = if (hand == "right") "R" else "L"

            return if (this.col == 0) { //col = 0이면 첫번째 열이라는 뜻이므로 무조건 L
                finger = "L"

                finger
            }
            else if (this.col == 2) { //col = 2면 마지막 열이라는 뜻이므로 무조건 R
                finger = "R"

                finger
            }
            else { //2,5,8,0일 때
                //이 코드는 약간 가독성이 떨어진다.
                //여기서 this는 getDistance 안에서는 p가 되고,
                //getDistance 안에서의 this는 getDistance를 호출한 left가 된다.
                val leftDist = left.getDistance(this)
                val rightDist = right.getDistance(this)

                if (leftDist < rightDist) {
                    finger = "L"
                } else if (rightDist < leftDist) {
                    finger = "R"
                }

                return finger
            }
        }

        //주어진 position부터 this까지의 거리
        private fun getDistance(p: Position): Int =
            abs(this.row - p.row) + abs(this.col - p.col)
    }
}
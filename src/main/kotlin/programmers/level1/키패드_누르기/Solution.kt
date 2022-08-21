package programmers.level1.키패드_누르기

/*

[1][2][3]
[4][5][6]
[7][8][9]
[*][0][#]

1. currentLeft = 1, currentRight = #, resultBuilder = "L"
2. currentLeft = 1, currentRight = 3, resultBuilder = "LR"
3. currentLeft = 4, currentRight = 3, resultBuilder = "LRL"
4. currentLeft = 5, currentRight = 3, resultBuilder = "LRLL"

[00][01][02]
[10][11][12]
[20][21][22]
[30][31][32]

1. currentLeft = 00, currentRight = 32, resultBuilder = "L"
2. currentLeft = 00, currentRight = 02, resultBuilder = "LR"
3. currentLeft = 10, currentRight = 02, resultBuilder = "LRL"

2,5,8,0일 때
- 왼손잡이면 currentLeft, 오른손잡이면 currentRight부터,
- 현재 위치에서 상,하,좌,우를 모두 살펴서 찾으려는 숫자가 있는지 확인한다.
- left, right 둘 다 없다면 대각선 위치에 있는지 확인한다.
- 없다면 어디에 있든 거리는 같아진다. 따라서 사용하는 손을 반환한다.
*/
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val keypad = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(99, 0, 99),
        )

        val resultBuilder = StringBuilder()
        var currentLeft = 3 to 0 // 왼손 현재 위치, 시작은 키패드 * 위치
        var currentRight = 3 to 2 // 왼손 현재 위치, 시작은 키패드 # 위치

        for (findNumber in numbers) {
            when (findNumber) {
                1 -> {
                    currentLeft = 0 to 0
                    resultBuilder.append("L")
                    continue
                }
                4 -> {
                    currentLeft = 1 to 0
                    resultBuilder.append("L")
                    continue
                }
                7 -> {
                    currentLeft = 2 to 0
                    resultBuilder.append("L")
                    continue
                }
                3 -> {
                    currentRight = 0 to 2
                    resultBuilder.append("R")
                    continue
                }
                6 -> {
                    currentRight = 1 to 2
                    resultBuilder.append("R")
                    continue
                }
                9 -> {
                    currentRight = 2 to 2
                    resultBuilder.append("R")
                    continue
                }
            }

            //현재 위치에서 상,하,좌,우 탐색
            //왼손잡이면 왼손부터, 오른손잡이면 오른손부터 탐색
            if (hand == "left") {
                val searchWithLeft = searchKeypad(currentLeft, keypad, findNumber)

                if (searchWithLeft != null) {
                    currentLeft = searchWithLeft
                    resultBuilder.append("L")
                    continue
                }

                val searchWithRight = searchKeypad(currentRight, keypad, findNumber)

                if (searchWithRight != null) {
                    currentRight = searchWithRight
                    resultBuilder.append("R")
                    continue
                }

                //상하좌우에도 없으면 대각선 탐색
                val diagonalWithLeft = searchDiagonal(currentLeft, keypad, findNumber)

                if (diagonalWithLeft != null) {
                    currentLeft = diagonalWithLeft
                    resultBuilder.append("L")
                    continue
                }

                val diagonalWithRight = searchDiagonal(currentRight, keypad, findNumber)
                if (diagonalWithRight != null) {
                    currentRight = diagonalWithRight
                    resultBuilder.append("R")
                    continue
                }

                currentLeft = getIndex(findNumber)
                resultBuilder.append("L")

            } else {
                val searchWithRight = searchKeypad(currentRight, keypad, findNumber)

                if (searchWithRight != null) {
                    currentRight = searchWithRight
                    resultBuilder.append("R")

                    continue
                }

                val searchWithLeft = searchKeypad(currentLeft, keypad, findNumber)

                if (searchWithLeft != null) {
                    currentLeft = searchWithLeft
                    resultBuilder.append("L")
                    continue
                }

                //상하좌우에도 없으면 대각선 탐색
                val diagonalWithRight = searchDiagonal(currentRight, keypad, findNumber)
                if (diagonalWithRight != null) {
                    currentRight = diagonalWithRight
                    resultBuilder.append("R")
                    continue
                }

                val diagonalWithLeft = searchDiagonal(currentLeft, keypad, findNumber)

                if (diagonalWithLeft != null) {
                    currentLeft = diagonalWithLeft
                    resultBuilder.append("L")

                    continue
                }


                currentRight = getIndex(findNumber)
                resultBuilder.append("R")
            }

        }

        return resultBuilder.toString()
    }

    private fun searchDiagonal(current: Pair<Int, Int>, keypad: Array<IntArray>, findNumber: Int): Pair<Int, Int>? {
        //우측 상단 왼쪽
        if (current.first > 0 && current.second > 0) {
            val topLeft = keypad[current.first - 1][current.second - 1]
            if (topLeft == findNumber) {
                return current.first - 1 to current.second - 1
            }
        }

        //우측 상단 오른쪽
        if (current.first > 0 && current.second < 2) {
            val topRight = keypad[current.first - 1][current.second + 1]
            if (topRight == findNumber) {
                return current.first - 1 to current.second + 1
            }
        }

        //좌측 하단 왼쪽
        if (current.second > 0 && current.first < 3) {
            val bottomLeft = keypad[current.first + 1][current.second - 1]
            if (bottomLeft == findNumber) {
                return current.first + 1 to current.second - 1
            }
        }

        //좌측 하단 오른쪽
        if (current.second < 2 && current.first < 3) {
            val bottomRight = keypad[current.first + 1][current.second + 1]
            if (bottomRight == findNumber) {
                return current.first + 1 to current.second + 1
            }
        }

        return null
    }

    private fun searchKeypad(
        current: Pair<Int, Int>,
        keypad: Array<IntArray>,
        findNumber: Int,
    ): Pair<Int, Int>? {
        //상단이 있는 경우
        if (current.first > 0) {
            //상단 키패드가 찾는 숫자일 경우
            val top = keypad[current.first - 1][current.second]
            if (top == findNumber) {
                return current.first - 1 to current.second
            }
        }

        //왼쪽이 있는 경우
        if (current.second > 0) {
            val left = keypad[current.first][current.second - 1]
            if (left == findNumber) {
                return current.first to current.second - 1
            }
        }

        //오른쪽이 있는 경우
        if (current.second < 2) {
            val right = keypad[current.first][current.second + 1]
            if (right == findNumber) {
                return current.first to current.second + 1
            }
        }

        //하단이 있는 경우
        if (current.first < 3) {
            val right = keypad[current.first + 1][current.second]
            if (right == findNumber) {
                return current.first + 1 to current.second
            }
        }

        return null
    }

    fun getIndex(number: Int) = when (number) {
        1 -> 0 to 0
        2 -> 0 to 1
        3 -> 0 to 2
        4 -> 1 to 0
        5 -> 1 to 1
        6 -> 1 to 2
        7 -> 2 to 0
        8 -> 2 to 1
        9 -> 2 to 2
        0 -> 3 to 1
        else -> -1 to -1
    }

}

fun main() {
    println(Solution().solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}


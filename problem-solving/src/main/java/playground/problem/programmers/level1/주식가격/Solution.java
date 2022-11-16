package playground.problem.programmers.level1.주식가격;

import java.util.Arrays;

// 초 단위로 기록된 주식가격 배열 prices. 가격이 떨어지지 않은 기간은 몇 초인지 반환해야 한다.
// prices=[1,2,3,2,3]으로 주어질 때, result=[4,3,1,1,0]이 된다.
// 풀이
// 주어진 시간은 총 5초
// 1. 1초 시점 $1는 끝까지 가격이 떨어지지 않는다. -> 4
// 2. 2초 시점 $2도 끝까지 가격이 떨어지지 않는다. -> 3
// 3. 3초 시점 $3은 바로 다음 초에 가격이 떨어지지만, 그 다음초에 다시 회복한다. -> 1
// 4. 4초 시점 $2는 끝까지 가격이 떨어지지 않는다. -> 1
// 5. 5초 시점 $3은 마지막이기 때문에 비교할 수 없다. -> 0
// result=[4,3,1,1,0]
class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        //각 요소를 반복하면서, prevPrice에 저장한다.
        //선택된 요소의 다음 요소부터 비교하면서 크거나 같은 가격의 수를 저장한다.
        int prevIdx = 0;
        int prevPrice = prices[prevIdx];
        int startIdx = 1;
        int idx = startIdx;
        while (true) {
            if (idx == prices.length) {
                idx = ++startIdx;

                if (startIdx == prices.length) {
                    break;
                }

                prevPrice = prices[++prevIdx];
            }

            int nextPrice = prices[idx];
            if (prevPrice <= nextPrice) {
                result[prevIdx] += 1;
            }

            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{5, 4, 3, 5, 5})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{3,3,3,3,3})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{0,0,0,0,0,0})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{5,4,3,2,1})));
        //6, 1, 4, 0, 2, 0, 0
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1,7,1,7,1,4,2})));
    }
}

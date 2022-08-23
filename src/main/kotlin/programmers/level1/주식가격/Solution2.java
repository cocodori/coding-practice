package programmers.level1.주식가격;

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
class Solution2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        //마지막 요소는 무조건 0
        for (int i=0; i<prices.length-1; i++) {

            for(int j=i+1; j<prices.length; j++) {
                answer[i] += 1;
                //가격 떨어지면 break
                if (prices[i] > prices[j])
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().solution(new int[]{5, 4, 3, 5, 5})));
        System.out.println(Arrays.toString(new Solution2().solution(new int[]{1, 2, 3, 2, 3})));

    }
}

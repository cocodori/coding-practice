package programmers.혼자놀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }

    public int solution(int[] cards) {

        // 방문한 요소의 인덱스를 기록
        boolean[] isVisited = new boolean[cards.length];
        int[] groups = new int[cards.length];

        dfs(cards, isVisited, groups);

        return Arrays.stream(groups)
                .filter(i -> i!=0)
                .reduce(1, (a,b) -> a*b);
    }

    private void dfs(int[] cards, boolean[] isVisited, int[] groups) {
        for (int i = 0; i < cards.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(cards[i]);

            while (!stack.isEmpty()) {
                int n = stack.pop();
                if (isVisited[n-1]) break;
                isVisited[n-1] = true;
                groups[i]++;
                stack.push(cards[n-1]);
            }
        }

    }
}

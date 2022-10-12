package programmers.피로도;

import java.util.*;

class Solution {

    static int count = 0;
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        List<Integer> result = new ArrayList<>();
        result.add(0);

        dfs(dungeons, isVisited, k, 0, result);

        return result.get(0);
    }

    void dfs(int[][] dungeons, boolean[] isVisited, int k, int depth, List<Integer> result) {
        for(int i = 0; i < dungeons.length; i++) {
            if (result.get(0) == dungeons.length) break;
            if (isVisited[i] || k < dungeons[i][0]) continue;
            isVisited[i] = true;
            dfs(dungeons, isVisited, k - dungeons[i][1], depth+1, result);
            isVisited[i] = false;
        }

        result.add(Math.max(result.remove(0), depth));
    }
}

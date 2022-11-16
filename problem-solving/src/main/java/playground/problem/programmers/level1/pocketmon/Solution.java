package playground.problem.programmers.level1.pocketmon;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int canHaveNumber = nums.length / 2;

        if (set.size() > canHaveNumber) {
            return canHaveNumber;
        } else {
            return set.size();
        }
    }

    public static void main(String[] args) {
        new Solution().solution(new int[] {3,1,2,3});
        new Solution().solution(new int[] {3,3,3,2,2,4});
        new Solution().solution(new int[] {3,3,3,2,2,2});
    }
}

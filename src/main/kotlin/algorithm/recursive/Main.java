package algorithm.recursive;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,1,1,1,1}, 3));
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        return sumCount(numbers, target, 0, 0);
    }

    private int sumCount(int[] numbers, int target, int i, int sum) {
        if (i == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }

        return sumCount(numbers, target, i+1, sum + numbers[i])
                + sumCount(numbers, target, i+1, sum - numbers[i]);
    }
}

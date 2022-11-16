package playground.problem.programmers.타겟넘버;

/*

[4,1,2,1], 4

+4+1+2+1=8
+4+1+2-1=6

+4+1-2+1=4 //
+4+1-2-1=2

+4-1+2+1=6
+4-1+2-1=4 //
+4-1-2+1=2
+4-1-2-1=0

-4+1+2+1=0
-4+1+2-1=-2
-4+1-2+1=-4
-4-1+2+1=-2
-4-1+2-1=-4
-4-1-2+1=-2
-4+1-2-1=-6
-4-1-2-1=-8


sum = 0
sum += 4
sum += 1
sum += 2
sum += 1

sum += -4
sum += -1
sum += -2
sum += -1
*/
public class Solution {
    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(solution);
    }
    public int solution(int[] numbers, int target) {
        return countSum(numbers, target, 0, 0);
    }

    private int countSum(int[] numbers, int target, int i, int sum) {
        if (i == numbers.length) {
            System.out.println("sum: " + sum);
            if (sum == target) return 1;
            return 0;
        }

        int number = numbers[i];

        int i1 = countSum(numbers, target, i + 1, sum + number);

        int i2 = countSum(numbers, target, i + 1, sum - number);

        return i1+i2;
    }
}
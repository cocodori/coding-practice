package playground.problem.javaex.array;

import java.util.Arrays;

public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = new int[20];

        for (int i = 0; i < 20; i++) {
            numArr[i] = i+1;
        }

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 20);
            int tmp = numArr[0];
            numArr[0] = numArr[n];
            numArr[n] = tmp;
        }

        System.out.println(Arrays.toString(numArr));
    }

}

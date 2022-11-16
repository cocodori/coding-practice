package playground.problem.javaex.array;

import java.util.Arrays;

public class ArrayEx11 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] count = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 10);
        }

        for (int i = 0; i < numArr.length; i++) {
            count[numArr[i]]++;
        }

        System.out.println(Arrays.toString(numArr));

        for (int i = 0; i < count.length; i++)
            System.out.printf("%d의 개수: %d\n", i, count[i]);
    }
}

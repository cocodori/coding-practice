package javaex.array;

import java.util.Arrays;

public class ArrayEx10 {
    public static void main(String[] args) {
        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int)(Math.random() * 10);
        }

        for (int i = 0; i < numArr.length; i++) {
            boolean changed = false;

            for (int j = 0; j < numArr.length-1-i; j++) {
                if (numArr[j] > numArr[j+1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j+1];
                    numArr[j+1] = temp;
                    changed = true;
                }
            }

            if (!changed) break;
        }

        System.out.println(Arrays.toString(numArr));
    }
}

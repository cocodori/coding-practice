package javaex.array;

public class ArrayEx8 {
    public static void main(String[] args) {
        int[] ball = new int[45];

        for (int i = 0 ; i < 45; i++)
            ball[i] = i+1;

        int temp = 0;
        int j = 0;

        for (int i = 0; i < 6; i++) {
            j = (int)(Math.random() * 45);
            temp = ball[i];
            ball[i] = ball[j];
            ball[j] = temp;

            System.out.print(ball[i] + ", ");
        }
    }
}

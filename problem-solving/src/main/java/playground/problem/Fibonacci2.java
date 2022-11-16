package playground.problem;

public class Fibonacci2 {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    private static int fibonacci(int k) {
        if (k<=1) {
            System.out.print(k+" ");
            return k;
        }

        return fibonacci(k -2) + fibonacci(k - 1);
    }
}

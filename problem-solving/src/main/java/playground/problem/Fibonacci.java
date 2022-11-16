package playground.problem;

public class Fibonacci {
    int fibonacci(int k) {
        return fibonacci(k, new int[k+1]);
    }

    private int fibonacci(int k, int[] cache) {
        if (k <= 1) {
            return k;
        } else if (cache[k] > 0) {
            return cache[k];
        }

        cache[k] = fibonacci(k-2, cache) + fibonacci(k -1, cache);

        return cache[k];
    }

    public static void main(String[] args) {

        for (int i=0; i<100; i++) {
            System.out.println();
            System.out.println("i="+i);
            System.out.println(new Fibonacci().fibonacci(i));
        }

    }
}

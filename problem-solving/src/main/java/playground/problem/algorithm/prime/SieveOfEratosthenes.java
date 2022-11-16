package playground.problem.algorithm.prime;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 10;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        makePrime(n, isPrime);

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) System.out.println(i+1);
        }

    }

    private static void makePrime(int n, boolean[] isPrime) {
        isPrime[0] = false;
        if (n < 2) return;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j * i <= n; j++) {
                isPrime[(i * j)-1] = false;
            }
        }

    }
}

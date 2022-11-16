package playground.problem.baekjoon.basic;

import java.util.*;

public class Main {

    private static int maxValue = 0;

    private static class Item {
        final int weight;
        final int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] isVisited = new boolean[N];

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            items.add(new Item(sc.nextInt(), sc.nextInt()));
        }

        search(items, K, isVisited, 0, 0);
        System.out.println(maxValue);
    }

    private static void search(List<Item> items, int k, boolean[] isVisited, int totalWeight, int totalValue) {
        for (int i = 0; i < items.size(); i++) {
            if (isVisited[i]) continue;
            Item item = items.get(i);
            if (totalWeight + item.weight > k) continue;

            isVisited[i] = true;
            maxValue = Math.max(maxValue, totalValue + item.value);
            search(items, k, isVisited, totalWeight + item.weight, totalValue+item.value);
            isVisited[i] = false;
        }
    }
}
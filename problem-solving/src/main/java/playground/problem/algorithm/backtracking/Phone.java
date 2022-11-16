package playground.problem.algorithm.backtracking;

import java.util.*;

public class Phone {
    public static void main(String[] args) {
        Map<Integer, char[]> keypad = new HashMap<>();
        keypad.put(2, new char[]{'A', 'B', 'C'});
        keypad.put(3, new char[]{'D', 'E', 'F'});
        keypad.put(4, new char[]{'G', 'H', 'I'});
        keypad.put(5, new char[]{'J', 'K', 'L'});
        keypad.put(6, new char[]{'M', 'N', 'O'});
        keypad.put(7, new char[]{'P', 'Q', 'R', 'S'});
        keypad.put(8, new char[]{'T', 'U', 'V'});
        keypad.put(9, new char[]{'W', 'X', 'Y', 'Z'});

        int[] inputBtn = {2,5,9,3};
        List<String> letters = new ArrayList<>();
        backtracking(keypad, inputBtn, letters, 0, "");
        System.out.println(letters);
    }

    private static void backtracking(final Map<Integer, char[]> keypad, final int[] inputBtn, final List<String> letters, int i, String letter) {
        if (i >= inputBtn.length) {
            letters.add(letter);
            return;
        }

        int num = inputBtn[i];
        char[] chars = keypad.get(num);
        for (char c : chars)
            backtracking(keypad, inputBtn, letters, i+1, letter+c);
    }
}

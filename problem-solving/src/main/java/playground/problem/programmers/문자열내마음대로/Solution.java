package playground.problem.programmers.문자열내마음대로;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public void solution() {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        String[] str = (String[]) Arrays.stream(strings)
                .sorted(Comparator.comparingInt(s -> s.charAt(n)))
                .map(String::toString)
                .toArray();


        System.out.println(Arrays.toString(strings));
    }
}

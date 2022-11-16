package playground.problem.programmers.level1.올바른_괄호;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        //주어진 문자열을 split
        //!! split을 쓰면 효율성 검사에서 실패한다.
        String[] split = s.split("");

        //첫 번째 문자가 )라면 무조건 틀린 짝
        if (split[0] == ")") return false;

        Queue<String> queue = new LinkedList<>();

        for (String c : split) {
            if (c.equals("("))
                queue.offer(s);
            else if (queue.size() == 0 && c.equals(")")) {
                return false;
            } else {
                if (queue.poll() == null) {
                    return false;
                }
            }
        }

        return queue.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("()())("));
        System.out.println(new Solution().solution("(()("));
        System.out.println(new Solution().solution("()()"));
        System.out.println(new Solution().solution("(())()"));
        System.out.println(new Solution().solution(")()("));
    }
}

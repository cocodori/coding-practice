package programmers.level1.올바른_괄호;

import java.util.Stack;

// queue or stack의 문제가 아니라 split을 쓰면 효율성 검사에 실패하는구나
public class Solution2 {
    boolean solution(String s) {
        s.split("");
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if (stack.size() == 0 && c == ')') return false;

            if (c == '(')
                stack.push(c);
            else
                if (stack.pop() == null)
                    return false;
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution("(()("));
        System.out.println(new Solution2().solution("()()"));
        System.out.println(new Solution2().solution("(())()"));
        System.out.println(new Solution2().solution(")()("));
    }
}

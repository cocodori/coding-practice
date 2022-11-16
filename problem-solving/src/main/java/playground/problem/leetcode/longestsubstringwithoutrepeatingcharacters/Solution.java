package playground.problem.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.*;

//Slide Window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;

        int res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            //key: r, value: 지난 r의 개수 + 1, 없으면 1
            chars.put(r, chars.getOrDefault(r,0)+1);

            // r이 중복일 때
            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        new SolutionK().lengthOfLongestSubstring("pwwkew");
    }
}
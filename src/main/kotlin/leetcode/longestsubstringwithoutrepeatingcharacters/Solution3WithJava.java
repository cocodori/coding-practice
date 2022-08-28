package leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

//Slide Window
class Solution3WithJava {
    public int lengthOfLongestSubstring(String s) {
        final Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];

            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3WithJava().lengthOfLongestSubstring("pwwkew"));
    }
}
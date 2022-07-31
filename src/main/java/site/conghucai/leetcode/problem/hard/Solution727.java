package site.conghucai.leetcode.problem.hard;

import java.util.HashMap;
import java.util.Map;

// 和76一模一样题目，滑动窗口解决。
public class Solution727 {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int pos = -1, len = Integer.MAX_VALUE;

        while (right < n) {
            char rightChar = s1.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            while (checkWindow(need, window)) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    pos = left;
                }

                char leftChar = s1.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }

            right++;
        }

        return pos == -1 ? "" : s1.substring(pos, pos + len);
    }

    private boolean checkWindow(Map<Character, Integer> need, Map<Character, Integer> window) {
        for (char c : need.keySet()) {
            int windowCharCnt = window.getOrDefault(c, 0);
            int needCharCnt = need.get(c);
            if (needCharCnt > windowCharCnt) {
                return false;
            }
        }
        return true;
    }
}

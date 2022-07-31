package site.conghucai.leetcode.problem.hard;

// 76. 最小覆盖子串

// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

// 注意：

// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
public class Solution76 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] need = new int[256]; // char 和对应出现的次数
        int[] window = new int[256]; // window内char和对应出现的次数

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int pos = -1;
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right);
            window[c]++;

            while (checkWindow(need, window)) { // 窗口符合要求，记录最小窗口、尝试将左边界收紧
                if (right - left + 1 < len) {
                    pos = left;
                    len = right - left + 1;
                }

                window[s.charAt(left)]--;
                left++; // 收紧左边界
            }

            right++;
        }

        return pos == -1 ? "" : s.substring(pos, pos + len);
    }

    private boolean checkWindow(int[] need, int[] window) {
        int charsetLen = need.length;

        for (int i = 0; i < charsetLen; i++) {
            if (need[i] != 0 && need[i] > window[i]) {
                return false;
            }
        }

        return true;
    }

}

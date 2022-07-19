package site.conghucai.leetcode.problem.hard;

// 10. 正则表达式匹配
// 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

public class Solution10 {
    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        boolean ans = dp(s, 0, p, 0);
        return ans;
    }

    int[][] memo;

    // s[x...] 能否被p[y...]匹配
    private boolean dp(String s, int x, String p, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y] > 0;
        }

        if (y == p.length()) {
            memo[x][y] = (x == s.length() ? 1 : -1);
            return x == s.length();
        }

        boolean res;
        boolean firstMatch = x < s.length() && (s.charAt(x) == p.charAt(y) || p.charAt(y) == '.');

        if (y + 1 < p.length() && p.charAt(y + 1) == '*') {
            res = dp(s, x, p, y + 2) || (firstMatch && dp(s, x + 1, p, y));
        } else {
            res = firstMatch && dp(s, x + 1, p, y + 1);
        }

        memo[x][y] = res ? 1 : -1;
        return res;
    }
}

package site.conghucai.leetcode.problem.middle;

// 5. 最长回文子串
// 给你一个字符串 s，找到 s 中最长的回文子串。

// 提示：
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成

public class Solution5 {
  public String longestPalindrome(String s) {
    // 经验证 最长回文字串和最长回文子序列 都需要二维dp...

    // dp[i][j] = s[i] - s[j]是否构成一个子串
    // dp[i][j] = s[i] == s[j] && dp[i+1][j-1]

    // 最长回文子序列是:dp[i][j]是最大回文子序列长度
    // dp[i][j] = dp[i+1][j-1] + 2 or max(dp[i+1][j], dp[i][j-1])
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    int maxLen = 1, startPos = 0;
    for (int i = 0; i < n - 1; i++) {
      dp[i][i] = true;
      dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);

      if (dp[i][i + 1]) {
        maxLen = 2;
        startPos = i;
      }
    }
    dp[n - 1][n - 1] = true;

    for (int i = n - 3; i >= 0; i--) {
      for (int j = i + 2; j < n; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

        if (dp[i][j] && maxLen < j - i + 1) {
          maxLen = j - i + 1;
          startPos = i;
        }
      }
    }

    return s.substring(startPos, startPos + maxLen);

  }
}

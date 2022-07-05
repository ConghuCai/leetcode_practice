package site.conghucai.leetcode.problem.middle;

// 516. 最长回文子序列
// 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
public class Solution516 {
  public int longestPalindromeSubseq(String s) {
    // dp[i][j]：s[i]-s[j]之间，最长回文子序列
    // 所以，状态转移方程：
    // dp[i][j] = dp[i+1][j-1] + 2, if s[i] == s[j]
    // dp[i][j] = max(dp[i+1][j], dp[i][j-1]), if s[i] != s[j]

    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    int ans = 1;
    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
        }

        ans = Math.max(dp[i][j], ans);
      }
    }

    return ans;
  }
}

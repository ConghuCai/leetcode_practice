package site.conghucai.leetcode.problem.hard;

// 32. 最长有效括号
// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
public class Solution32 {
  public int longestValidParentheses(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n];
    dp[0] = 0;

    int ans = 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '(') {
        dp[i] = 0;
      } else {
        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') { // 和前面的(构成有效括号对
          dp[i] = dp[i - 1] + 2;
          if (i - dp[i - 1] - 2 >= 0) { // 再和 ( 前面的最长有效括号对 构成新的最长有效对
            dp[i] += dp[i - dp[i - 1] - 2];
          }

        } else { // ) 无法和前面构成有效括号对
          dp[i] = 0;
        }
      }

      ans = Math.max(ans, dp[i]);
    }

    return ans;
  }
}

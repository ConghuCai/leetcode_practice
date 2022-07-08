package site.conghucai.leetcode.problem.hard;

// 买卖股票的最佳时机 III

// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
public class Solution123 {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n][3][2];

    for (int i = 0; i <= 2; i++) {
      dp[0][i][0] = Integer.MIN_VALUE;
      dp[0][i][1] = Integer.MIN_VALUE;
    }
    dp[0][0][0] = 0;
    dp[0][1][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= 2; j++) {
        int sale = dp[i - 1][j][1] != Integer.MIN_VALUE ? (dp[i - 1][j][1] + prices[i]) : Integer.MIN_VALUE; // 确保负无穷+-任何数，仍然是负无穷
        dp[i][j][0] = Math.max(dp[i - 1][j][0], sale);// sale vs stay

        if (j > 0) {
          int buy = dp[i - 1][j - 1][0] != Integer.MIN_VALUE ? (dp[i - 1][j - 1][0] - prices[i]) : Integer.MIN_VALUE;
          dp[i][j][1] = Math.max(dp[i - 1][j][1], buy); // stay vs buy
        } else {
          dp[i][j][1] = Integer.MIN_VALUE;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i <= 2; i++) {
      ans = Math.max(ans, dp[n - 1][i][0]);
    }

    return ans;
  }
}

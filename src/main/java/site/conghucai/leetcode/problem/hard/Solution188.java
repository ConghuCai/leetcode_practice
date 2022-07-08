package site.conghucai.leetcode.problem.hard;

// 188. 买卖股票的最佳时机 IV
// 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

public class Solution188 {
  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n == 0 || k == 0) {
      return 0;
    }

    int[][][] dp = new int[n][k + 1][2];

    for (int j = 0; j <= k; j++) {
      dp[0][j][0] = Integer.MIN_VALUE;
      dp[0][j][1] = Integer.MIN_VALUE;
    }
    dp[0][0][0] = 0;
    dp[0][1][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= k; j++) {
        int sale = dp[i - 1][j][1] != Integer.MIN_VALUE ? (dp[i - 1][j][1] + prices[i]) : Integer.MIN_VALUE;
        dp[i][j][0] = Math.max(dp[i - 1][j][0], sale);

        if (j > 0) {
          int buy = dp[i - 1][j - 1][0] != Integer.MIN_VALUE ? (dp[i - 1][j - 1][0] - prices[i]) : Integer.MIN_VALUE;
          dp[i][j][1] = Math.max(dp[i - 1][j][1], buy);
        } else {
          dp[i][j][1] = Integer.MIN_VALUE;
        }
      }
    }

    int ans = 0;
    for (int j = 0; j <= k; j++) {
      ans = Math.max(ans, dp[n - 1][j][0]);
    }

    return ans;
  }
}

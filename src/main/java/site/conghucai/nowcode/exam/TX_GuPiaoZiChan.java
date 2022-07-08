package site.conghucai.nowcode.exam;

// 现在有一个长度为n的价格数组a，表示某只股票每天的价格,
//你每天最多买入或卖出该只股票的1手股票，
// 买入或者卖出没有手续费，且卖出股票前必须手里已经有股票才能卖出,但是持有的股票数目不受限制，
// 并且初始资金为m元,你在任意时刻都不能进行透支,所以你的资金必须始终大于等于0。

// 请问你在n天结束之后,拥有最大的总资产是多少?(总资产:股票数目*股票价格+现金)

// dp[i][j]: 持有
public class TX_GuPiaoZiChan {
  public static void main(String[] args) {
    int n = 6;
    int m = 2;
    int[] prices = { 2, 3, 1, 1, 1, 2 };

    long[][] dp = new long[n][n + 2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n + 2; j++) {
        dp[i][j] = Integer.MIN_VALUE;
      }
    }

    // 第1天的情况
    dp[0][0] = m;
    if (m >= prices[0]) { // 第一天可以买入
      dp[0][1] = m;
    }

    // 第i天的情况
    for (int i = 1; i < n; i++) {
      // 第i天 持有股票数的所有情况
      for (int j = 0; j <= i + 1; j++) { // 第i天，至多持有i+1只股票（因为每天只能买一次 i=0最多就是持有1支）
        int mins = prices[i] - prices[i - 1]; // 涨幅

        long stay = dp[i - 1][j] + mins * j; // 今天不动

        long buy = Integer.MIN_VALUE;
        if (j > 0 && (dp[i - 1][j - 1] - prices[i - 1] * (j - 1)) >= prices[i]) { // 今天买入
          buy = dp[i - 1][j - 1] + mins * (j - 1);
        }

        long sale = dp[i - 1][j + 1] + mins * (j + 1); // 今天卖出

        dp[i][j] = Math.max(stay, Math.max(buy, sale)); // 第i天获取的最大资产
      }
    }

    long ans = Integer.MIN_VALUE;
    for (long res : dp[n - 1]) {
      ans = Math.max(ans, res);
    }

    System.out.println(ans);
  }
}

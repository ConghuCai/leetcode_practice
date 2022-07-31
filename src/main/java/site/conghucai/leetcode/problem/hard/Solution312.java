package site.conghucai.leetcode.problem.hard;

// 312. 戳气球
// 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
// 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

// 求所能获得硬币的最大数量。
public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n + 2];
        int m = coins.length;
        System.arraycopy(nums, 0, coins, 1, n);
        coins[0] = 1;
        coins[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + coins[i] * coins[j] * coins[k]);
                }
            }
        }

        return dp[0][m - 1];
    }
}

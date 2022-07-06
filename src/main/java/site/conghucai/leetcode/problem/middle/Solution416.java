package site.conghucai.leetcode.problem.middle;

// 416. 分割等和子集
// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class Solution416 {
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 != 0) {
      return false;
    }

    int target = sum / 2;
    int[][] dp = new int[n + 1][target + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        if (nums[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
        }
      }
    }

    return dp[n][target] == target;
  }
}

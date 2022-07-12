package site.conghucai.leetcode.problem.middle;

// 523. 连续的子数组和
// 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

// 子数组大小 至少为 2 ，且
// 子数组元素总和为 k 的倍数。
// 如果存在，返回 true ；否则，返回 false 。

// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
public class Solution523 {
  public boolean checkSubarraySum(int[] nums, int k) {
    int n = nums.length;

    int dp, temp; // 用0d的dp数组来计算dp[i][j]: i到j之间的数组和
    for (int i = 0; i < n; i++) {
      temp = nums[i];

      for (int j = i + 1; j < n; j++) {
        dp = temp + nums[j];

        // 子数组长度至少>=2 这里的子数组长度才能>=2
        if (dp % k == 0) {
          return true;
        }

        temp = dp;
      }

      // i 到 n之间的和仍小于k i+1 到n 也一定小于k 可以提前终止
      // 这里要注意 可能后面存在连续的 0 ，结果仍为true
      if (temp < k) {
        for (int x = 0; x < n - 1; x++) {
          if (nums[x] + nums[x + 1] == 0) {
            return true;
          }
        }

        return false;
      }

    }

    return false;
  }
}

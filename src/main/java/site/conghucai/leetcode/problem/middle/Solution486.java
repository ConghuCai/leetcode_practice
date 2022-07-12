package site.conghucai.leetcode.problem.middle;

// 预测赢家

// 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。

// 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
// 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
// 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。

// 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
public class Solution486 {
  public boolean PredictTheWinner(int[] nums) {
    int n = nums.length;

    int[][][] dp = new int[n][n][2];
    int[][] sum = new int[n][n];

    for (int i = 0; i < n; i++) {
      sum[i][i] = nums[i];

      dp[i][i][0] = nums[i]; // 1先手，1在i-j范围内能够得到的最大分数
      dp[i][i][1] = nums[i]; // 2后手，2在i-j范围内能够得到的最大分数

      for (int j = i + 1; j < n; j++) {
        sum[i][j] = sum[i][j - 1] + nums[j];
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (dp[i + 1][j][1] <= dp[i][j - 1][1]) { // 判断对手下一轮先手的较小情况
          dp[i][j][0] = sum[i][j] - dp[i + 1][j][1];
        } else {
          dp[i][j][0] = sum[i][j] - dp[i][j - 1][1];
        }

        if (dp[i + 1][j][0] <= dp[i][j - 1][0]) {
          dp[i][j][1] = sum[i][j] - dp[i + 1][j][0];
        } else {
          dp[i][j][1] = sum[i][j] - dp[i][j - 1][0];
        }
      }
    }

    return dp[0][n - 1][0] * 2 >= sum[0][n - 1];
  }
}

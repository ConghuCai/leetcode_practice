package site.conghucai.leetcode.problem.middle;

// 198. 打家劫舍
// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
// 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

// 思路：动态规划-dp_i = 到i房，偷到的最大金额。
public class S198_HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }
        return dp[dp.length - 1];
    }
}

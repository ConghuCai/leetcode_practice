package site.conghucai.leetcode.problem.middle;

import java.util.List;

// 120. 三角形最小路径和
// 给定一个三角形 triangle ，找出自顶向下的最小路径和。

// 每一步只能移动到下一行中相邻的结点上。
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
// 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];
        int[] dpI = new int[n];
        int[] temp;

        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int left = j == 0 ? Integer.MAX_VALUE : dp[j - 1];
                int right = j == i ? Integer.MAX_VALUE : dp[j];

                dpI[j] = Math.min(left, right) + triangle.get(i).get(j);
            }

            temp = dp;
            dp = dpI;
            dpI = temp;
        }

        int ans = dp[0];
        for (int j = 1; j < n; j++) {
            ans = Math.min(ans, dp[j]);
        }

        return ans;
    }
}

package site.conghucai.leetcode.problem.middle;

// 221. 最大正方形

// 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

// 思路：
// dp_ij  ij为左上角的最大正方形边长

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i] - '0';
            if (dp[m - 1][i] == 1) {
                ans = 1;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            dp[i][n - 1] = matrix[i][n - 1] - '0';
            if (dp[i][n - 1] == 1) {
                ans = 1;
            }
        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 2; i >= 0; i--) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                if (dp[i + 1][j] == dp[i][j + 1]) {
                    int len = dp[i + 1][j];
                    dp[i][j] = matrix[i + len][j + len] == '1' ? len + 1 : len;

                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }

                ans = Math.max(ans, dp[i][j] * dp[i][j]);
            }
        }

        return ans;

    }
}

package site.conghucai.leetcode.problem.hard;

// 85. 最大矩形
// 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
public class Solution85 {
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;

    int[][] dpLen = new int[m][n]; // 以i,j为左上标的最大1-长度（横向）

    // 1. 计算每个位置的左侧最长连续1-长度
    for (int i = 0; i < m; i++) {
      dpLen[i][n - 1] = (matrix[i][n - 1] - '0');
    }

    for (int i = 0; i < m; i++) {
      for (int j = n - 2; j >= 0; j--) {
        if (matrix[i][j] == '0') {
          dpLen[i][j] = 0;
        } else {
          dpLen[i][j] = dpLen[i][j + 1] + 1;
        }
      }
    }

    // 向上对比 计算每个位置最小左侧连续1-长度
    int ans = 0;
    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        int minLen = dpLen[i][j];

        for (int k = i; k >= 0; k--) {
          minLen = Math.min(dpLen[k][j], minLen);
          int area = minLen * (i - k + 1);

          ans = Math.max(ans, area);
        }
      }
    }

    return ans;
  }
}

package site.conghucai.problem.middle;

// 48. 旋转图像
// 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
public class Solution48 {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    // 1.矩阵转置
    int temp;
    for (int row = 0; row <= n - 2; row++) {
      for (int col = row + 1; col <= n - 1; col++) {
        temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }

    // 2.每一行翻转
    for (int row = 0; row < n; row++) {
      for (int i = 0, j = n - 1; i < j; i++, j--) {
        temp = matrix[row][i];
        matrix[row][i] = matrix[row][j];
        matrix[row][j] = temp;
      }
    }
  }
}

package site.conghucai.leetcode.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	51. N 皇后
//	n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//	给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//	每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
public class Solution51 {
  public List<List<String>> solveNQueens(int n) {
    ans = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], '.');
    }

    dfs(board, 0, n);
    return ans;
  }

  private List<List<String>> ans;

  private void dfs(char[][] board, int row, int n) {
    if (row == n) {
      List<String> res = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        res.add(new String(board[i])); // 注意：字符数组可以直接转为str
      }

      ans.add(res);
      return;
    }

    for (int col = 0; col < n; col++) {
      if (!vaild(board, row, col)) {
        continue;
      }

      // 有效位置
      board[row][col] = 'Q';

      dfs(board, row + 1, n);

      board[row][col] = '.'; // 回溯
    }
  }

  private boolean vaild(char[][] board, int row, int col) {
    int n = board.length;
    // 上下左右
    for (int i = 0; i < n; i++) {
      if (board[row][i] == 'Q' && i != col) {
        return false;
      }

      if (board[i][col] == 'Q' && i != row) {
        return false;
      }
    }

    // 左上方
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q')
        return false;
    }

    // 左下
    for (int i = row, j = col; i < n && j >= 0; i++, j--) {
      if (board[i][j] == 'Q')
        return false;
    }

    // 右上
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 'Q')
        return false;
    }

    // 右下
    for (int i = row, j = col; i < 0 && j < n; i++, j++) {
      if (board[i][j] == 'Q')
        return false;
    }
    return true;
  }
}

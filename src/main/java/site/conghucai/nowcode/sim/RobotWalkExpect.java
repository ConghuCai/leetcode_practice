package site.conghucai.nowcode.sim;

import java.util.Scanner;

// [编程题]随机的机器人
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 有一条无限长的纸带,分割成一系列的格子,最开始所有格子初始是白色。
// 现在在一个格子上放上一个萌萌的机器人(放上的这个格子也会被染红),机器人一旦走到某个格子上,就会把这个格子涂成红色。
// 现在给出一个整数n,机器人现在会在纸带上走n步。
// 每一步,机器人都会向左或者向右走一个格子,两种情况概率相等。机器人做出的所有随机选择都是独立的。现在需要计算出最后纸带上红色格子的期望值。
public class RobotWalkExpect {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    res = new int[n + 2];

    boolean[] grid = new boolean[2 * n + 1];
    grid[n] = true;

    dfs(grid, n, n, 1);

    int sum = 0;
    double expSum = 0;
    for (int i = 0; i < n + 2; i++) {
      sum += res[i];
      expSum += (i * res[i]);
    }

    double ans = expSum / sum;
    System.out.println(String.format("%.1f", ans));
  }

  private static int[] res;

  // dp(boolean[] grid, int start, int step)
  private static void dfs(boolean[] grid, int start, int step, int red) {
    if (step == 0) {
      res[red]++;
      return;
    }

    // 向左
    if (grid[start - 1]) {
      dfs(grid, start - 1, step - 1, red);
    } else {
      grid[start - 1] = true;
      dfs(grid, start - 1, step - 1, red + 1);
      grid[start - 1] = false;
    }

    // right
    if (grid[start + 1]) {
      dfs(grid, start + 1, step - 1, red);
    } else {
      grid[start + 1] = true;
      dfs(grid, start + 1, step - 1, red + 1);
      grid[start + 1] = false;
    }
  }

}

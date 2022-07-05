package site.conghucai.nowcode.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HW_Battle {
  // [编程题]汽水瓶
  // 时间限制：C/C++ 1秒，其他语言2秒

  // 空间限制：C/C++ 32M，其他语言64M

  // 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
  // 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
  // 数据范围：输入的正整数满足 1 <= n <= 100

  // 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n;
    List<Integer> inps = new ArrayList<>();
    int max = 0;
    while (true) {
      n = Integer.parseInt(reader.readLine());
      if (n == 0)
        break;
      inps.add(n);
      max = Math.max(max, n);
    }

    int[] dp = new int[max + 1];
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    for (int i = 3; i <= max; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3]) + 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int num : inps) {
      sb.append(dp[num]);
      sb.append('\n');
    }

    writer.write(sb.toString());
    writer.flush();
  }

}

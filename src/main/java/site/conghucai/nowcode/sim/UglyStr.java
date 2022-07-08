package site.conghucai.nowcode.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [编程题]丑陋的字符串
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 牛牛喜欢字符串,但是他讨厌丑陋的字符串。对于牛牛来说,一个字符串的丑陋值是字符串中相同连续字符对的个数。比如字符串“ABABAABBB”的丑陋值是3,因为有一对"AA"和两对重叠的"BB"。
// 现在给出一个字符串,字符串中包含字符'A'、'B'和'?'。牛牛现在可以把字符串中的问号改为'A'或者'B'。牛牛现在想让字符串的丑陋值最小,希望你能帮帮他。
public class UglyStr {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s = in.readLine();
    int n = s.length();
    in.close();

    int[][] dp = new int[n][2]; // 0 - 'A' 1-'B'
    if (s.charAt(0) == 'A') {
      dp[0][1] = n; // n代表max
    }
    if (s.charAt(0) == 'B') {
      dp[0][0] = n;
    }

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1]);
      dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0]);

      if (s.charAt(i) == 'A') {
        dp[i][1] = n;
      } else if (s.charAt(i) == 'B') {
        dp[i][0] = n;
      }
    }

    int ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
    System.out.println(ans);
  }
}

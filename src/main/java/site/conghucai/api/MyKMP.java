package site.conghucai.api;

// KMP
public class MyKMP {
  private String pat;
  private int[][] dp; // i状态时，遇到j字符，转到dp[i][j]状态

  public MyKMP(String pat) {
    this.pat = pat;
    int n = pat.length();
    dp = new int[n][256];

    dp[0][pat.charAt(0)] = 1;
    int x = 0; // 影子 用来匹配最长前缀

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 256; j++) {
        dp[i][j] = dp[x][j]; // 其他情况都不能推进状态 依赖x回退到最长前缀的状态
      }
      dp[i][pat.charAt(i)] = i + 1; // 只有命中下一个字符才能推进状态

      x = dp[x][pat.charAt(i)]; // 注意：对x进行更新，如果和i碰到相同字符，则前缀变长：x前进；否则前缀变短，x回退
    }
  }

  public int search(String txt) {
    int n = txt.length(), m = pat.length();

    int stat = 0;
    for (int i = 0; i < n; i++) {
      stat = dp[stat][txt.charAt(i)]; // 按照状态转换图 向前移动状态

      if (stat == m) { // 在i处匹配成功 返回之前的位置
        return i - m + 1;
      }
    }

    return -1;
  }
}

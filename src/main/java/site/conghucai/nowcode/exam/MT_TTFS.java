package site.conghucai.nowcode.exam;

import java.util.Arrays;
import java.util.Scanner;

// [编程题]淘汰分数
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 256M，其他语言512M

// 某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。

// 但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。

// 显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。

// 数据范围：n : 1-50000， 1 <= x <= y <= n
// 进阶：时间复杂度O(nlogn)，空间复杂度O(n)

public class MT_TTFS {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // String s1 = in.nextLine();
    // String s2 = in.nextLine();
    // throw new RuntimeException(s1 + ", " + s2);

    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();

    int[] scores = new int[n];
    for (int i = 0; i < n; i++) {
      scores[i] = in.nextInt();
    }
    in.close();

    Arrays.sort(scores);
    int ans = -1;

    for (int m = x; m <= y; m++) {
      int line = scores[m - 1];
      int num = m;
      for (int i = m; i < n; i++) {
        if (scores[i] == line) {
          num++;
        } else {
          break;
        }
      }

      if (num <= y) {
        ans = scores[num - 1];
        break;
      }
    }

    System.out.println(ans);

  }
}

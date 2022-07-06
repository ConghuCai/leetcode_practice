package site.conghucai.nowcode.exam;

import java.util.Scanner;

// 又是上班的早高峰，现在有N只在一楼的牛想要乘坐电梯上楼，已知第i只牛乘电梯到达目标楼层至电梯返回—楼所需要的时间为ai。
// 公司里有两个电梯，但由于疫情防控需要，牛牛们只能依次乘坐电梯。也就是说，对
// 于每头牛，他可以选择空闲的电梯乘坐，若此时无电梯空闲，则他需要等待。
// 现在牛牛们想知道需要多长时间所有的牛才能都上楼(结束时两个电梯都回到—楼且—
// 楼没有牛)
// 输入描述:
// 第一行一个整数N，表示牛的个数接下来一行N个整数，第i个数表示ai
// 输出描述:
// 输出一个整数表示答案
public class NIO_CowElevator {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] nums = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextInt();
      sum += nums[i];
    }
    in.close();

    int target = sum / 2;
    int[][] dp = new int[n + 1][target + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        if (nums[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
        }
      }
    }

    int ans = sum - dp[n][target];
    System.out.println(ans);

  }
}

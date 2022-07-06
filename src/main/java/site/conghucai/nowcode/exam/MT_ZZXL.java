package site.conghucai.nowcode.exam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// [编程题]正则序列
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 256M，其他语言512M

// 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序

// 有一天小团得到了一个长度为n的任意序列s，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。

// 请问他最少用多少次操作可以把这个序列变成正则序列？

// 数据范围：n = 1 - 20000，  nums[i] : -10000 - +10000
// 进阶：时间复杂度O(nlogn)，空间复杂度O(n)
public class MT_ZZXL {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextInt();
    }
    in.close();

    Arrays.sort(nums);

    Set<Integer> set = new TreeSet<>();
    boolean[] has = new boolean[n];
    boolean flag;

    for (int num = 1; num <= n; num++) { // 每一个num是否在nums中出现
      flag = false;
      for (int i = 0; i < n; i++) {
        if (nums[i] == num) {
          has[i] = true;
          flag = true;
          break; // 出现了

        } else if (nums[i] > num) {
          break;
        }
      }

      if (!flag) {
        set.add(num);
      }
    }

    int ans = 0;
    Iterator<Integer> it = set.iterator();
    for (int i = 0; i < n; i++) {
      if (has[i]) {
        continue;
      }

      ans += Math.abs(nums[i] - it.next());
    }

    System.out.println(ans);
  }
}

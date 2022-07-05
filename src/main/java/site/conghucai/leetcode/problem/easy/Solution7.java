package site.conghucai.leetcode.problem.easy;

// 7. 整数反转
// 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
//
// 假设环境不允许存储 64 位整数（有符号或无符号）。

public class Solution7 {
  public int reverse(int x) {
    int res = 0, num = 0;
    while (x != 0) {
      // 防止溢出 我们只需要每次对res进行判断即可，在res行将溢出前，return 0
      if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) { // 因为下次res会*10 所以这里判断溢出边界的1/10
        return 0;

        // 疑问：这里为判断条件为什么不是 >= Integer.MAX_VALUE / 10 ？ 是否有可能res * 10 =
        // Integer.MAX_VALUE，res*10 + num后发生溢出？
        // 解答：不可能。如果真的res=边界，那么res此时为214748364，输入的x是它的倒序，只可能为(1)463847412。
        // 开头1的话，res*10+1=2147483641，不会溢出。
      }

      // 反转
      num = x % 10;
      res = res * 10 + num;

      x /= 10;
    }

    return res;
  }
}
package site.conghucai.leetcode.problem.easy;
// 476. 数字的补数

// 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。

// 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
// 给你一个整数 num ，输出它的补数。

public class Solution476 {
  public int findComplement(int num) {
    int n = num;

    // 求n的全1形式
    // n = -1 >>> Integer.numberOfLeadingZeros(n); //这方式可以

    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16; // 这方式也可以

    return n ^ num;
  }
}

package site.conghucai.leetcode.problem.middle;

// 165. 比较版本号
// 给你两个版本号 version1 和 version2 ，请你比较它们。

// 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
// 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
//例如，2.5.33 和 0.1 都是有效的版本号。

// 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
// 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
// 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

// 返回规则如下：

// 如果 version1 > version2 返回 1，
// 如果 version1 < version2 返回 -1，
// 除此之外返回 0。
public class Solution165 {
  public int compareVersion(String version1, String version2) {
    int n1 = version1.length(), n2 = version2.length();
    int[] res1, res2;
    int v1, v2;
    int pos1 = 0, pos2 = 0;
    do {
      res1 = getEditNum(version1, pos1);
      res2 = getEditNum(version2, pos2);

      v1 = res1[0]; // 扫描的编辑号结果
      pos1 = res1[1]; // 扫描后游标位置
      v2 = res2[0];
      pos2 = res2[1];

      if (v1 != v2) {
        return v1 - v2 > 0 ? 1 : -1;
      }

      // 版本号相等
      pos1 = pos1 == n1 ? n1 : pos1 + 1; // 扫描之后的游标不在末尾 则一定在'.'上 向后走一位
      pos2 = pos2 == n2 ? n2 : pos2 + 1;
    } while (pos1 != n1 || pos2 != n2); // 注意循环条件

    return 0;
  }

  // 从pos位置开始，解析版本号。返回解析结果和解析后游标的位置
  private int[] getEditNum(String version, int pos) {
    int n = version.length();
    if (pos == n) {
      return new int[] { 0, pos };
    }

    int end = pos;
    for (; end + 1 < n && version.charAt(end + 1) != '.'; end++) // end向后走 下一位就是.时停下
      ;

    // 不用去前导零：parseInt自带去前导零的功能。。。
    // for (; start < end && version.charAt(start) == '0'; start++) ;//
    // [start, end]之间的字符串就可以进行转换了
    String num = version.substring(pos, end + 1);
    int v = Integer.parseInt(num);
    return new int[] { v, end + 1 };
  }

}

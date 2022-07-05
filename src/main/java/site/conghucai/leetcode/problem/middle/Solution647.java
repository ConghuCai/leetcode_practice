package site.conghucai.leetcode.problem.middle;

// 647. 回文子串
// 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

// 回文字符串 是正着读和倒过来读一样的字符串。

// 子字符串 是字符串中的由连续字符组成的一个序列。

// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

// 提示：
// 1 <= s.length <= 1000
// s 由小写英文字母组成
public class Solution647 {
  public int countSubstrings(String s) {
    int n = s.length();
    int count = 0;

    for (int end = 0; end < n; end++) {
      for (int start = end; start >= 0; start--) {
        if (isCircle(s, start, end)) {
          count++; // s[start] - s[end] 构成回文
        }
      }
    }

    return count;
  }

  private boolean isCircle(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }

      start++;
      end--;
    }
    return true;
  }
}

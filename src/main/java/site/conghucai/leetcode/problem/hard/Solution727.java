package site.conghucai.leetcode.problem.hard;

// 727. 最小窗口子序列
// 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。

// 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。

// 示例 1：
// 输入：
// S = "abcdebdde", T = "bde"
// 输出："bcde"
// 解释：
// "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
// "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。

// 思路：滑动窗口。确定left和right边界，然后检查s1[left ... right]是否是s2的子序列。
// 求子序列这里的时间复杂度为O(n)，滑动窗口是O(n)，解法时间复杂度为O(n^2)。

// 这里第一次提交超时，于是进行优化：
// right处的char一定是s2最后一个char、left处的char一定是s2第一个char。不符合这个要求就直接调整窗口，不要进入序列检查。
public class Solution727 {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int left = 0, right = 0;
        int pos = -1, len = Integer.MAX_VALUE;

        char firstChar = s2.charAt(0), lastChar = s2.charAt(m - 1);

        while (right < n) {
            // 优化：right处的char一定是s2最后一个char s1[left...right]才有可能是最终答案
            if (right - left + 1 < m || s1.charAt(right) != lastChar) {
                right++;
                continue;
            }

            while (checkWindow(s2, s1, left, right)) {
                // System.out.println(s1.substring(left, right+1));
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    pos = left;
                }

                left++;
                // 优化：left处的char一定是s2第一个char s1[left...right]才有可能是最终答案
                while (left <= right && s1.charAt(left) != firstChar) {
                    left++;
                }
            }
            right++;
        }

        return pos == -1 ? "" : s1.substring(pos, pos + len);
    }

    private boolean checkWindow(String s2, String s1, int left, int right) {
        int i = left, j = 0;
        while (i <= right && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == s2.length();
    }
}

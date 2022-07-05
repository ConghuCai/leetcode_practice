package site.conghucai.leetcode.problem.middle;

import java.util.HashMap;
import java.util.Map;

// 3. 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    // map记录字符最后一次出现的位置
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();

    int startPos = 0;
    int ans = 0;
    for (int end = 0; end < n; end++) {
      if (map.containsKey(s.charAt(end))) {
        startPos = Math.max(startPos, map.get(s.charAt(end)) + 1); // max防止start回退
      }

      map.put(s.charAt(end), end);
      ans = Math.max(ans, end - startPos + 1);
    }

    return ans;
  }
}

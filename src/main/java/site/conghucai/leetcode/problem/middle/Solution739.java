package site.conghucai.leetcode.problem.middle;

import java.util.ArrayDeque;
import java.util.Deque;

//	739. 每日温度
//	请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
public class Solution739 {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] ans = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        stack.pop();
      }

      int higherDays = stack.isEmpty() ? 0 : stack.peek() - i;
      ans[i] = higherDays;

      stack.push(i);
    }

    return ans;
  }
}

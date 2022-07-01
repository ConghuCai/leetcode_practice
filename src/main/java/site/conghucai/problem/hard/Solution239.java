package site.conghucai.problem.hard;
// 239. 滑动窗口最大值

import java.util.ArrayDeque;
import java.util.Deque;

// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

// 返回 滑动窗口中的最大值 。
public class Solution239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    MyQueue queue = new MyQueue();
    int[] ans = new int[n - k + 1];

    // 先填入前k个
    for (int i = 0; i < k - 1; i++) {
      queue.offer(nums[i]);
    }

    int max;
    int index = 0;
    for (int i = k - 1; i < n; i++) {
      queue.offer(nums[i]);
      max = queue.peek();
      ans[index++] = max;

      queue.poll(nums[i - k + 1]);
    }

    return ans;

  }

  class MyQueue {
    Deque<Integer> queue = new ArrayDeque<>();

    void offer(int e) {
      while (!queue.isEmpty() && queue.peekLast() < e) { // 这个地方一定不能是= 因为那样的话可能造成出队时弹出别人的值
        queue.removeLast();
      }
      queue.offer(e);
    }

    void poll(int e) {
      if (e == queue.peek()) {
        queue.poll();
      }
    }

    int peek() {
      return queue.peek();
    }
  }
}

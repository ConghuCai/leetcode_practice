package site.conghucai.leetcode.problem.middle;

// 寻找重复数
// 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。

// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
public class Solution287 {
  public int findDuplicate(int[] nums) {
    // 逻辑上认为 i -> nums[i]是一条链，因此必定有环
    // 1. 环入口的上一个节点就是重复数：环入口被两个节点指向，这题由于存在重复数，因此两个重复数的next就是环入口。
    // 环入口的值是nums[i]，因此环入口就是i，也就是slow和fast“指针”。
    // 2. 0不存在 因此nums[0]是链表起点
    int slow = 0, fast = 0;

    slow = nums[slow];
    fast = nums[nums[fast]];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    slow = 0;
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
}

package site.conghucai.leetcode.problem.middle;

import java.util.ArrayDeque;
import java.util.Deque;

// 581. 最短无序连续子数组
// 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

// 请你找出符合题意的 最短 子数组，并输出它的长度。

// 示例 1：

// 输入：nums = [2,6,4,8,10,9,15]
// 输出：5
// 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

//思路：
//单调栈。
//单调栈可以在入站时，pop出前面无序元素。start记录递增单调栈最前面的那个被pop出来的元素位置
//end记录递减单调栈最后面被pop出来的元素位置。
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);

        int start = n, end = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                // i前存在无序关系
                int index = stack.pop();
                start = Math.min(start, index);
            }

            if (start == 0) {
                break;
            }

            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // i后存在无序关系
                end = Math.max(stack.pop(), end);
            }

            if (end == n - 1) {
                break;
            }

            stack.push(i);
        }

        return start == n ? 0 : (end - start + 1);
    }
}

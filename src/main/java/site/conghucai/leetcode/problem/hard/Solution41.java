package site.conghucai.leetcode.problem.hard;

// 41. 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

// 思路：使用nums作为哈希表，num对应的就是nums[num-1]
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将< 1 > n全部改成n+1 全部变成正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // 这里abs是防止之前有num将nums[num-1]变成了负数
            if (num >= 1 && num <= n) {
                nums[num - 1] *= -1; // 将nums[num-1]变成负数 意味着nums中含有num这个数
            }
        }

        for (int i = 0; i < n; i++) { // 遍历所有存在的数
            if (nums[i] < 0) {
                continue;
            }

            return i + 1;
        }

        return n + 1;
    }
}

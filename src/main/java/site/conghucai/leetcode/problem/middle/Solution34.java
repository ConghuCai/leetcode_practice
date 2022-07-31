package site.conghucai.leetcode.problem.middle;

// 34. 在排序数组中查找元素的第一个和最后一个位置
// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

// 如果数组中不存在目标值 target，返回 [-1, -1]。

// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = myBinarySearch(nums, target, true);
        int right = myBinarySearch(nums, target, false);

        if (left == -1) {
            return new int[] { -1, -1 };
        }
        if (right == -1) {
            return new int[] { left, nums.length - 1 };
        }

        return new int[] { left, right - 1 };
    }

    private int myBinarySearch(int[] nums, int target, boolean flag) { // flag代表是否寻找的是第一个等于target的数 flag纯纯是为了代码复用
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target || (flag && nums[mid] == target)) {
                if ((flag && nums[mid] == target) || !flag) {
                    res = mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    // // 如果不考虑代码复用，
    // // 那寻找第一个比target大的数：
    // private int func1(int[] nums, int target) {
    // int low = 0, high = nums.length - 1;
    // int res = -1;

    // while (low <= high) {
    // int mid = (low + high) / 2;

    // if (nums[mid] > target) {
    // res = mid;
    // high = mid - 1;
    // } else {
    // low = mid + 1;
    // }
    // }

    // return res;
    // }

    // // 寻找第一个等于target的数
    // private int func2(int[] nums, int target) {
    // int low = 0, high = nums.length - 1;
    // int res = -1;

    // while (low <= high) {
    // int mid = (low + high) / 2;

    // if (nums[mid] >= target) {
    // if (nums[mid] == target) {
    // res = mid;
    // }

    // high = mid - 1;
    // } else {
    // low = mid + 1;
    // }
    // }

    // return res;
    // }
}

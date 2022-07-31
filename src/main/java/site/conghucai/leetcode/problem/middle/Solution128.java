package site.conghucai.leetcode.problem.middle;

import java.util.HashMap;
import java.util.Map;

// 128. 最长连续序列
// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int[][] indexes = new int[n][2]; // 0记录前驱index，1记录后继index

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            indexes[i][0] = map.getOrDefault(nums[i] - 1, -1);
            indexes[i][1] = map.getOrDefault(nums[i] + 1, -1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (indexes[i][0] != -1) { // 存在前驱就直接跳过，它肯定不是答案需要找的
                continue;
            }

            int res = 1;
            for (int next = indexes[i][1]; next != -1; next = indexes[next][1]) { // 不存在前驱则一直寻找后继
                res++;
            }
            ans = Math.max(ans, res);
        }

        // 不用担心上面这个双重for的时间复杂度，实际上每个数字只被访问了至多两次，时间复杂度还是On的。

        return ans;
    }
}

package site.conghucai.leetcode.problem.middle;

import java.util.HashMap;
import java.util.Map;

// 560. 和为 K 的子数组
// 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
// 思路：前缀和。
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int pre = 0; // i的前缀和.

        // 思路：以i结尾的子数组要满足和为k，就要满足：pre_i - k = pre_x，其中x为i之前的一个前缀和
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pre = nums[i] + pre;

            if (map.containsKey(pre - k)) { // 查找之前有没有前缀和为pre_i - k的
                ans += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1); // map记录pre作为前缀和的出现次数
        }

        return ans;
    }

}

package site.conghucai.leetcode.problem.middle;

// 11. 盛最多水的容器
// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

// 返回容器可以储存的最大水量。

// 说明：你不能倾斜容器。
public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;

        int ans = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);

            if (height[left] < height[right]) { // 移动较小边才有面积变大可能性
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else { // 两个边一样大，同时移动才有面积变大可能性
                left++;
                right--;
            }
        }

        return ans;
    }
}

package site.conghucai.leetcode.problem.hard;

import java.util.ArrayDeque;
import java.util.Deque;

// 84. 柱状图中最大的矩形
// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

// 求在该柱状图中，能够勾勒出来的矩形的最大面积。

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        // 单调栈，找某个方向第一个比i小的数，因此以h[i]为边的，这个方向的最大矩形就确定了。
        // 然后再反方向再找一遍，相加即可。
        int[] maxArea = new int[n];
        maxArea[0] = heights[0];

        int ans = 0;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int pos = stack.pop(); // pos找到了右边第一个比h[pos]小的数
                maxArea[pos] += heights[pos] * (i - pos); // 以pos向右的最大矩形确定 加到pos的area答案中

                maxArea[pos] -= heights[pos]; // 答案一定已经包含了从pos向左的最大部分，去掉中间的重复部分，即为最终答案
                ans = Math.max(ans, maxArea[pos]);
            }

            if (!stack.isEmpty()) {
                int pos = stack.peek(); // i找到了左边第一个比h[i]小的数 (这里有问题：peek可能是等于h[i]的数字)
                maxArea[i] = (i - pos) * heights[i]; // 以i向左的最大矩形确定
            } else {
                maxArea[i] = (i + 1) * heights[i]; // 左边没有比它更小的了
            }

            stack.push(i);
        }

        // 还留在单调栈里的说明：pos向左的矩形已经确定，向右没有比他更小的h[pos]了
        while (!stack.isEmpty()) {
            int pos = stack.pop();
            maxArea[pos] += (n - pos) * heights[pos];

            maxArea[pos] -= heights[pos]; // 去重复部分
            ans = Math.max(ans, maxArea[pos]);
        }

        return ans;

    }
}

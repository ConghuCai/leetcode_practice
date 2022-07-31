package site.conghucai.leetcode.problem.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 85. 最大矩形
// 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

// 思路：n次求柱状图最大面积（solution85）
// 求出每一行的柱状图高度。然后计算这个柱状图高度形成的最大面积。
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        int[] maxArea = new int[n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            // 第i行的柱状图高度计算（以matrxi[i][j]为底的柱子高度）
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }

            int res = getMaxRectangleArea(heights, stack, maxArea);
            ans = Math.max(ans, res);
        }

        return ans;
    }

    private int getMaxRectangleArea(int[] heights, Deque<Integer> stack, int[] maxArea) {
        int n = heights.length;

        Arrays.fill(maxArea, 0);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int areaRight = (i - index) * heights[index]; // i是index右边第一个比index小的

                maxArea[index] = maxArea[index] + areaRight - heights[index];
                ans = Math.max(ans, maxArea[index]); // 左右边界（第一个比index小的）都确定了，index的面积就确定了
            }

            int index = stack.isEmpty() ? -1 : stack.peek();
            int areaLeft = (i - index) * heights[i]; // index是i左边第一个比i小的
            maxArea[i] = areaLeft;
            stack.push(i);
        }

        // 栈里剩下的就意味着右边没找到比它更小的柱子，因此宽度直接拉到最右边
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int areaRight = (n - index) * heights[index];
            maxArea[index] = maxArea[index] + areaRight - heights[index];
            ans = Math.max(ans, maxArea[index]);
        }

        return ans;
    }
}

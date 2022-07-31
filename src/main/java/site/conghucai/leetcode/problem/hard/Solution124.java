package site.conghucai.leetcode.problem.hard;

import site.conghucai.leetcode.struct.TreeNode;

// 124. 二叉树中的最大路径和
// 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

// 路径和 是路径中各节点值的总和。

// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        maxPathSumTo(root);
        return ans;
    }

    private int ans = Integer.MIN_VALUE;

    private int maxPathSumTo(TreeNode root) { // 从root出发的路径的最大值
        if (root == null) {
            return 0;
        }

        int leftPath = maxPathSumTo(root.left);
        int rightPath = maxPathSumTo(root.right);

        int rootPath = Math.max(root.val, root.val + Math.max(leftPath, rightPath)); // 从root出发的路径的最大值作为返回值

        int rootAns = Math.max(rootPath, root.val + leftPath + rightPath); // 计算经由root的路径值作为答案
        ans = Math.max(ans, rootAns);

        return rootPath;
    }
}

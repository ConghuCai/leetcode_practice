package site.conghucai.leetcode.problem.middle;

import site.conghucai.leetcode.struct.TreeNode;

// 333. 最大 BST 子树
// 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。

// 二叉搜索树（BST）中的所有节点都具备以下属性：

// 左子树的值小于其父（根）节点的值。

// 右子树的值大于其父（根）节点的值。

// 注意：子树必须包含其所有后代。
public class Solution333 {
    public int largestBSTSubtree(TreeNode root) {
        dp(root);
        return ans;
    }

    private int ans = 0;

    private int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, 1);
            return 1;
        }

        int res = 0;
        int left = dp(root.left);
        int right = dp(root.right);

        // 计算左右子树的最大、最小值
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        TreeNode p = root.left;
        while (p != null) {
            leftMax = Math.max(leftMax, p.val);
            p = p.right;
        }
        p = root.right;
        while (p != null) {
            rightMin = Math.min(rightMin, p.val);
            p = p.left;
        }

        if (root.left == null && right != 0) { // 仅存在右子树 且右子树是BST
            res = root.val < rightMin ? (right + 1) : 0;
        }
        if (root.right == null && left != 0) { // 仅存在左子树且左子树是BST
            res = root.val > leftMax ? (left + 1) : 0;
        }

        if (root.left != null && root.right != null && left != 0 && right != 0) { // 两个子树都存在 且都是BST
            res = (root.val < rightMin && root.val > leftMax) ? (left + right + 1) : 0;
        }

        ans = Math.max(ans, res);
        return res;
    }
}

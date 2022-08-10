package site.conghucai.leetcode.problem.hard;

import site.conghucai.leetcode.struct.TreeNode;

// 1373. 二叉搜索子树的最大键值和
// 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。

// 二叉搜索树的定义如下：

// 任意节点的左子树中的键值都 小于 此节点的键值。
// 任意节点的右子树中的键值都 大于 此节点的键值。
// 任意节点的左子树和右子树都是二叉搜索树。

// 示例 1：
// 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
// 输出：20
// 解释：键值为 3 的子树是和最大的二叉搜索树。

// 示例 2：
// 输入：root = [4,3,null,1,2]
// 输出：2
// 解释：键值为 2 的单节点子树是和最大的二叉搜索树。

// 示例 3：
// 输入：root = [-4,-2,-5]
// 输出：0
// 解释：所有节点键值都为负数，和最大的二叉搜索树为空。

// 示例 4：
// 输入：root = [2,1,3]
// 输出：6

// 示例 5：
// 输入：root = [5,4,8,3,null,6,3]
// 输出：7
public class Solution1373 {
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        bst(root);
        return ans;
    }

    private int ans = 0;

    // int[] : {bst的最大值，bst的最小值，bst的和}。
    // 如果bst(root)函数返回null，则说明root为根的树不是一个bst。
    private int[] bst(TreeNode root) {
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, root.val);
            return new int[] { root.val, root.val, root.val };
        }

        if (root.left == null) {
            int[] rightBst = bst(root.right);
            if (rightBst == null || root.val >= rightBst[0]) {
                return null;
            }

            int sum = root.val + rightBst[2];
            ans = Math.max(ans, sum);
            return new int[] { root.val, rightBst[1], sum };
        }

        if (root.right == null) {
            int[] leftBst = bst(root.left);
            if (leftBst == null || root.val <= leftBst[1]) {
                return null;
            }

            int sum = root.val + leftBst[2];
            ans = Math.max(ans, sum);
            return new int[] { leftBst[0], root.val, sum };
        }

        int[] leftBst = bst(root.left);
        int[] rightBst = bst(root.right);
        if (leftBst == null || rightBst == null || root.val <= leftBst[1] || root.val >= rightBst[0]) {
            return null;
        }

        int sum = root.val + leftBst[2] + rightBst[2];
        ans = Math.max(ans, sum);
        return new int[] { leftBst[0], rightBst[1], sum };

    }
}

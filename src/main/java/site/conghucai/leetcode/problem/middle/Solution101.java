package site.conghucai.leetcode.problem.middle;

import site.conghucai.leetcode.struct.TreeNode;

//	101. 对称二叉树
//	给定一个二叉树，检查它是否是镜像对称的。
public class Solution101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;

    return compare(root.left, root.right);
  }

  // 比较两个节点是否对称
  private boolean compare(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null || root1.val != root2.val) {
      return false;
    }

    // 比较对称位置的子树 是否完全对称
    return compare(root1.right, root2.left) && compare(root1.left, root2.right);
  }

}

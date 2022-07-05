package site.conghucai.leetcode.struct;

public class TreeNode {
  public int val;
  public TreeNode left, right, next;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

package site.conghucai.problem.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import site.conghucai.struct.TreeNode;

//	102. 二叉树的层序遍历
//	给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class Solution102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    int size;
    while (!queue.isEmpty()) {
      size = queue.size();
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        res.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      ans.add(res);
    }

    return ans;
  }

}

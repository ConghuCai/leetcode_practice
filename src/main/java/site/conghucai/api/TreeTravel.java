package site.conghucai.api;

import java.util.ArrayDeque;
import java.util.Deque;

import site.conghucai.leetcode.struct.TreeNode;

public class TreeTravel {

    public void preTravel(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                travel(p);
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void orderTravel(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                travel(p);
                p = p.right;
            }
        }
    }

    public void postTravel(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root, r = null;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right != null && r != p.right) {
                    p = p.right;
                } else {
                    p = stack.pop();
                    travel(p);
                    r = p;
                    p = null;
                }
            }
        }
    }

    private void travel(TreeNode p) {
    }

}

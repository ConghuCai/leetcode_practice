package site.conghucai.leetcode.problem.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import site.conghucai.leetcode.struct.TreeNode;

// 297. 二叉树的序列化与反序列化
// 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
// 输入：root = [1,2,3,null,null,4,5]
// 输出：[1,2,3,null,null,4,5]

public class Solution297 {
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
}

class Codec {

    private final String NULL = "null";
    private final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        queue.offer(root);
        res.add(root.val + "");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                res.add(node.left.val + "");
                queue.offer(node.left);
            } else {
                res.add(NULL);
            }

            if (node.right != null) {
                res.add(node.right.val + "");
                queue.offer(node.right);
            } else {
                res.add(NULL);
            }
        }

        // 这段代码纯纯是为了让string更像leetcode的那种格式。。
        while (res.get(res.size() - 1).equals(NULL)) {
            res.remove(res.size() - 1);
        }

        sb.append('[');
        for (String s : res) {
            sb.append(s);
            sb.append(SEP);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');

        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        String[] nodeVals = data.substring(1, data.length() - 1).split(SEP);
        int n = nodeVals.length;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));

        queue.add(root);
        int pos = 1;
        while (pos < n) {
            TreeNode node = queue.poll();
            if (!nodeVals[pos].equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(nodeVals[pos]));
                queue.offer(node.left);
            }

            pos += 1;
            if (pos < n && !nodeVals[pos].equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(nodeVals[pos]));
                queue.offer(node.right);
            }

            pos += 1;
        }

        return root;
    }
}
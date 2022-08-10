package site.conghucai.leetcode.problem.middle;

import java.util.HashMap;
import java.util.Map;

import site.conghucai.leetcode.struct.TreeNode;

// 337. 打家劫舍 III
// 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
// 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。

// 思路：rob(root)定义为：从root开始偷，最大能够偷到的金额。
// 所以rob(root) = max(rob(孩子节点),  root.val + rob(孙子节点) )
// 需要注意的是，一个root有两个切进来的路径：父节点、爷爷节点，因此可能出现重复计算问题。需要使用memo剪枝。
public class S337_HouseRobber_Tree {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 偷本节点 、 孙子节点。
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += rob(root.left.left);
            robRoot += rob(root.left.right);
        }

        if (root.right != null) {
            robRoot += rob(root.right.left);
            robRoot += rob(root.right.right);
        }

        // 不偷本届点，从孩子节点开始偷
        int notRobRoot = rob(root.left) + rob(root.right);

        int res = Math.max(robRoot, notRobRoot);
        memo.put(root, res);

        return res;
    }
}

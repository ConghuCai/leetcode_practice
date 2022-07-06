package site.conghucai.nowcode.exam;

import java.util.Arrays;
import java.util.Scanner;

// [编程题]最优二叉树II
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 256M，其他语言512M

// 小团有一个由N个节点组成的二叉树，每个节点有一个权值。定义二叉树每条边的开销为其两端节点权值的乘积，二叉树的总开销即每条边的开销之和。
// 小团按照二叉树的中序遍历依次记录下每个节点的权值，即他记录下了N个数，第i个数表示位于中序遍历第i个位置的节点的权值。
// 之后由于某种原因，小团遗忘了二叉树的具体结构。在所有可能的二叉树中，总开销最小的二叉树被称为最优二叉树。现在，小团请小美求出最优二叉树的总开销。
public class MT_BestBinaryTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextInt();
    }
    in.close();

    memo = new int[n][n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(memo[i][j], -1);
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int root = 0; root < n; root++) {
      int res = dp(nums, 0, n - 1, root);
      ans = Math.min(ans, res);
    }
    System.out.println(ans);
  }

  private static int[][][] memo;

  private static int dp(int[] nums, int sta, int end, int root) { // sta - end范围内 求root为根时的最右树
    if (memo[sta][end][root] != -1) {
      return memo[sta][end][root];
    }

    if (sta == end) {
      memo[sta][end][root] = 0;
      return 0;
    }

    int leftCost = Integer.MAX_VALUE;
    for (int left = sta; left <= root - 1; left++) {
      if (nums[root] * nums[left] > leftCost) {
        continue;
      }

      dp(nums, sta, root - 1, left);
      int res = nums[root] * nums[left] + memo[sta][root - 1][left];
      leftCost = Math.min(leftCost, res);
    }
    if (leftCost == Integer.MAX_VALUE) {
      leftCost = 0;
    }

    int rightCost = Integer.MAX_VALUE;
    for (int right = root + 1; right <= end; right++) {
      if (nums[root] * nums[right] > rightCost) {
        continue;
      }

      dp(nums, root + 1, end, right);
      int res = nums[root] * nums[right] + memo[root + 1][end][right];
      rightCost = Math.min(rightCost, res);
    }
    if (rightCost == Integer.MAX_VALUE) {
      rightCost = 0;
    }

    int ans = leftCost + rightCost;
    memo[sta][end][root] = ans;

    return ans;
  }

}

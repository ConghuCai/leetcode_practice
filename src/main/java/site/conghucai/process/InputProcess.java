package site.conghucai.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

import site.conghucai.leetcode.struct.TreeNode;

public class InputProcess {
    public static int[] readLimitInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        int i = 0;
        while (n-- > 0) {
            arr[i++] = scanner.nextInt();
        }

        scanner.close();
        return arr;
    }

    /**
     * 根据牛客的构造树的方法返回一颗树。
     * 输入格式：
     * n_node
     * [node val list]
     * [node father list: number-th node above is my father node]
     * 
     * @return
     * @throws IOException
     */
    public static TreeNode buildTreeNowcode() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String data = in.readLine();
        String fathers = in.readLine();

        int[] vals = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(vals[i]);
        }
        int[] fatherIndexes = Arrays.stream(fathers.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < n; i++) {
            TreeNode father = nodes[fatherIndexes[i] - 1];
            if (father.left == null) {
                father.left = nodes[i];
            } else {
                father.right = nodes[i];
            }
        }

        return nodes[0];
    }

    /**
     * 根据力扣的树的格式，返回一颗树。
     * 输入格式：
     * [node val list by level travel]
     * [1, 2, null, 3, 5, 7, null, 9, null, 11, null, 13]
     * 
     * @param data
     * @return
     * @throws IOException
     */
    public static TreeNode buildTreeLeetcode() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String data = in.readLine();

        if (data.trim().equals("[]")) {
            return null;
        }

        String[] nodeVals = data.substring(1, data.length() - 1).split(",");
        int n = nodeVals.length;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0].trim()));

        queue.add(root);
        int pos = 1;
        while (pos < n) {
            TreeNode node = queue.poll();
            if (!nodeVals[pos].trim().equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodeVals[pos].trim()));
                queue.offer(node.left);
            }

            pos += 1;
            if (pos < n && !nodeVals[pos].trim().equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodeVals[pos].trim()));
                queue.offer(node.right);
            }

            pos += 1;
        }

        return root;
    }

}
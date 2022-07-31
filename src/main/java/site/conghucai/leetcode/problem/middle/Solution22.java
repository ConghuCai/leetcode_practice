package site.conghucai.leetcode.problem.middle;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder());
        return ans;
    }

    private List<String> ans;

    private void dfs(int l, int r, int n, StringBuilder path) {
        if (r == n) {
            ans.add(path.toString());
            return;
        }

        if (l == r) { // 只能(
            path.append('(');

            dfs(l + 1, r, n, path);

            path.deleteCharAt(path.length() - 1);
        } else if (l > r) {
            if (l < n) { // 可以加) 也可以(
                path.append('(');
                dfs(l + 1, r, n, path);
                path.deleteCharAt(path.length() - 1);

                path.append(')');
                dfs(l, r + 1, n, path);
                path.deleteCharAt(path.length() - 1);

            } else if (l == n) { // 只能加 ）
                path.append(')');

                dfs(l, r + 1, n, path);

                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}

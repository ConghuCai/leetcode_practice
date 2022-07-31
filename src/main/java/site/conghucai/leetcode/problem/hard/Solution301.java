package site.conghucai.leetcode.problem.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 301. 删除无效的括号
// 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

// 返回所有可能的结果。答案可以按 任意顺序 返回。

// 示例 1：
// 输入：s = "()())()"
// 输出：["(())()","()()()"]
// 示例 2：

// 输入：s = "(a)())()"
// 输出：["(a())()","(a)()()"]
// 示例 3：

// 输入：s = ")("
// 输出：[""]

//思路：BFS，针对每一层的节点（字符串），每次删去一个括号字符，将产生的字符串作为下一层的节点，判断每一层的是否有节点（字符串）符合要求。
// 最先符合要求的一定是最长的答案字符串。（因为是BFS）
// 注意：queue中可能会存在重复的str，导致答案超时，这时就需要一个set帮助queue去重。
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> ans = new HashSet<>();
        Set<String> memo = new HashSet<>(); // 帮助queue来去重的，如果没有这个set去重，queue中可能存在大量重复的str。

        queue.offer(s);

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                if (memo.contains(str)) {
                    continue; // queue中去重
                }
                memo.add(str);

                if (valid(str)) { // 一旦发现str是有效的，由于bfs每次只删除一个字符，因此第一次发现有效str一定就是最长的str。
                    ans.add(str);

                    // 检查queue中剩下的、长度和str相同的字符串有没有也符合要求的。
                    for (i = i + 1; i < size; i++) {
                        str = queue.poll();
                        if (valid(str)) {
                            ans.add(str);
                        }
                    }
                    return new ArrayList<>(ans);
                }

                // 将str删去一个括号字符的子结果，作为其孩子节点，入队，提供给下一层遍历
                for (int pos = 0; pos < str.length(); pos++) {
                    if (str.charAt(pos) != '(' && str.charAt(pos) != ')') {
                        continue;
                    }

                    // if (pos > 0 && s.charAt(pos) == s.charAt(pos - 1)) {
                    // continue; //这个地方可以适当去重，当出现(((..))时，左边3个(只去掉一个，结果都是一样的
                    // } //由于queue也有set帮忙去重，所以其实不用这一段也可以，只是效率会低一些

                    StringBuilder sb = new StringBuilder(str.substring(0, pos));
                    sb.append(str.substring(pos + 1));
                    queue.offer(sb.toString()); // 孩子入队
                }
            }

            memo.clear();
        }

        return null;
    }

    private boolean valid(String s) { // 验证字符串是否有效
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}

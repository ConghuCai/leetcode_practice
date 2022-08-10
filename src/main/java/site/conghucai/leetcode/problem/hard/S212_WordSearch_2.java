package site.conghucai.leetcode.problem.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
// 212. 单词搜索 II
// 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。

// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

// 示例 1：
// 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// 输出：["eat","oath"]

// 示例 2：
// 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
// 输出：[]

// 思路：沿袭 单个单词在网格中的dfs搜索思路，但是这里存在一个问题：words可能是由大量前缀相同的单词组成的。前缀相同就意味着路径相同，那么dfs可能存在大量重复工作。
// 优化思路：使用前缀树，在dfs时，只要当前dfs路径作为前缀的情况下，后面还存在的字母就全部都dfs搜索，找到前缀树中的完整单词，就计入答案。
// 注意问题：1.可能存在重复被找到的word，因此使用set做去重。
// 2.注意如果dfs中发现当前的前缀树节点是某个单词的最后一个字母，那一定还要判断一下当前的路径是否为单词表中的单词。不然可能是前缀
public class S212_WordSearch_2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length, n = board[0].length;
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<int[]> record = map.getOrDefault(board[i][j], new ArrayList<int[]>());
                record.add(new int[] { i, j });

                map.put(board[i][j], record);
            }
        }

        StringBuilder path = new StringBuilder();
        ans = new HashSet<>();
        for (int c = 0; c < 26; c++) {
            Trie child = trie.children[c];
            if (child == null) {
                continue;
            }

            char ch = (char) (c + 'a');
            List<int[]> positions = map.get(ch);
            if (positions == null) {
                continue;
            }

            for (int[] pos : positions) {
                board[pos[0]][pos[1]] = '#';
                path.append(ch);

                dfs(board, pos[0], pos[1], trie, child, path);

                board[pos[0]][pos[1]] = ch;
                path.deleteCharAt(path.length() - 1);
            }
        }

        return new ArrayList<>(ans);
    }

    private Set<String> ans;
    private static final int[][] DIRECTS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void dfs(char[][] board, int x, int y, Trie trie, Trie curNode, StringBuilder path) {
        int m = board.length, n = board[0].length;
        if (curNode.end) {
            String word = path.toString();
            if (trie.search(word)) { // 还要确认一下一定是单词表中的完整单词 不然可能是前缀
                ans.add(word);
            }
        }

        for (int c = 0; c < 26; c++) { // 遍历所有curNode的后续字母
            Trie child = curNode.children[c];
            if (child == null) {
                continue;
            }

            // 发现一个以curNode之前的路径为前缀的字母 对其dfs进行查找
            char ch = (char) (c + 'a');

            for (int[] direct : DIRECTS) {
                int i = direct[0] + x, j = direct[1] + y;

                if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#' || board[i][j] != ch) {
                    continue;
                }

                // 发现字母表中和ch相同的可访问字母
                board[i][j] = '#';
                path.append(ch);

                dfs(board, i, j, trie, child, path);

                board[i][j] = ch;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    class Trie {
        private Trie[] children;
        private boolean end;

        private Trie() {
            children = new Trie[26];
            end = false;
        }

        private void insert(String word) {
            Trie node = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                Trie child = node.children[word.charAt(i) - 'a'];
                if (child == null) {
                    node.children[word.charAt(i) - 'a'] = new Trie();
                    child = node.children[word.charAt(i) - 'a'];
                }

                node = child;
            }

            node.end = true;
        }

        private boolean search(String word) {
            Trie node = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                Trie child = node.children[word.charAt(i) - 'a'];
                if (child == null) {
                    return false;
                }

                node = child;
            }

            return node.end;
        }
    }
}

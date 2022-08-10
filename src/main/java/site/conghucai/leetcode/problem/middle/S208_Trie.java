package site.conghucai.leetcode.problem.middle;

// 208. 实现 Trie (前缀树)
// Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

// 请你实现 Trie 类：

// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

// 解释
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // 返回 True
// trie.search("app");     // 返回 False
// trie.startsWith("app"); // 返回 True
// trie.insert("app");
// trie.search("app");     // 返回 True

public class S208_Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
    }
}

// 前缀树，也叫字典树，就是一个多节点的数。
class Trie {
    private Trie[] children; // 至多26个孩子，每个位置若为null则表示没有这个孩子
    private boolean end; // 表示当前即为单词结尾。

    public Trie() {
        children = new Trie[26];
        end = false;
    }

    public void insert(String word) {
        int n = word.length();
        Trie node = this;
        for (int i = 0; i < n; i++) {
            Trie child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new Trie();
                node.children[word.charAt(i) - 'a'] = child;
            }

            node = child;
        }

        node.end = true;
    }

    public boolean search(String word) {
        int n = word.length();
        Trie node = this;
        for (int i = 0; i < n; i++) {
            Trie child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }

            node = child;
        }

        return node.end; // 对于精准搜索 必须找到以最后一个字母结尾的路径
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Trie node = this;
        for (int i = 0; i < n; i++) {
            Trie child = node.children[prefix.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }

            node = child;
        }

        return true; // 找前缀 只要存在这条路径就可以了
    }
}

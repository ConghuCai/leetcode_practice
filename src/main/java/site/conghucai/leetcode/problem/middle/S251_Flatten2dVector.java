package site.conghucai.leetcode.problem.middle;

// 251. 展开二维向量

// 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。

// 示例：

// Vector2D iterator = new Vector2D([[1,2],[3],[4]]);

// iterator.next(); // 返回 1
// iterator.next(); // 返回 2
// iterator.next(); // 返回 3
// iterator.hasNext(); // 返回 true
// iterator.hasNext(); // 返回 true
// iterator.next(); // 返回 4
// iterator.hasNext(); // 返回 false
public class S251_Flatten2dVector {
    public static void main(String[] args) {
        int[][] vec = { { 1, 2 }, { 3 }, { 4 } };

        Vector2D v = new Vector2D(vec);
        while (v.hasNext()) {
            System.out.println(v.next());
        }

    }
}

class Vector2D {

    private int size;
    private int i;
    private int j;
    private int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.i = 0; // 数组pos
        this.j = 0; // 数组中的元素pos

        for (int[] arr : vec) {
            size += arr.length;
        }
    }

    public int next() {
        while (j == vec[i].length) { // 中间可能存在空的[] 一直迭代到length不为0的数组上
            i++;
            j = 0;
        }
        size--;

        return vec[i][j++];
    }

    public boolean hasNext() {
        return size != 0;
    }
}

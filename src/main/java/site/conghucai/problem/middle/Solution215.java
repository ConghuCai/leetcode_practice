package site.conghucai.problem.middle;

//	215. 数组中的第K个最大元素
//	给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//	请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
public class Solution215 {
  public int findKthLargest(int[] nums, int k) {
    int n = nums.length;
    MyQueue pq = new MyQueue(k); // 小根堆

    // 安排前k个入堆
    for (int i = 0; i < k; i++) {
      pq.offer(nums[i]);
    }

    // 后k个和堆根比较即可 大于堆的根则说明当前的堆根并不是前k大的数，出堆，安排这个更大的数入堆
    for (int i = k; i < n; i++) {
      if (nums[i] > pq.peek()) {
        pq.poll();
        pq.offer(nums[i]);
      }
    }

    return pq.poll();
  }

  static class MyQueue {
    int size;
    int[] pq;

    public MyQueue(int cap) {
      size = 0;

      pq = new int[cap + 1];
    }

    public int poll() {
      int root = pq[1];
      swap(size, 1);
      size--;
      sink(1);
      return root;
    }

    public void offer(int e) {
      pq[++size] = e;
      swim(size);
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int peek() {
      return pq[1];
    }

    private void swim(int pos) {
      while (pos > 1 && less(pos, parent(pos))) {
        swap(pos, parent(pos));
        pos = parent(pos);
      }
    }

    private void sink(int pos) {
      while (left(pos) <= size) {
        int smaller = right(pos) <= size ? (less(left(pos), right(pos)) ? left(pos) : right(pos)) : left(pos);
        if (less(pos, smaller)) {
          break;
        }
        swap(pos, smaller);
        pos = smaller;
      }

    }

    private boolean less(int i, int j) {
      return pq[i] < pq[j];
    }

    private int right(int pos) {
      return 2 * pos + 1;
    }

    private int left(int pos) {
      return 2 * pos;
    }

    private void swap(int i, int j) {
      int temp = pq[i];
      pq[i] = pq[j];
      pq[j] = temp;
    }

    private int parent(int pos) {
      return pos / 2;
    }
  }

  public static void main(String[] args) {
    int[] ms = { 1, 4, 5, 675, 546, 45, 34, 332, 23, 24, 3, 54, 54, 546, 1 };
    MyQueue q = new MyQueue(ms.length);

    for (int i = 0; i < ms.length; i++) {
      q.offer(ms[i]);
    }

    while (!q.isEmpty()) {
      System.out.println(q.poll());
      ;
    }
  }
}

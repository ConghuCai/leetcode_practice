package site.conghucai.api;

//优先队列的实现（二叉堆）
public class MyPriorityQueue<K extends Comparable<K>> {
  private K[] pq; // 二叉树
  private int size; // 元素个数

  @SuppressWarnings("unchecked") // 关闭类型强转警告
  public MyPriorityQueue(int cap) {
    pq = (K[]) new Comparable[cap + 1]; // 使用数组存储二叉树 索引0不用
    size = 0;
  }

  public K peek() {
    return pq[1];
  }

  public void add(K e) {
    pq[++size] = e;
    swim(size);
  }

  public K delPeek() {
    K top = pq[1];
    swap(1, size);
    pq[size--] = null;
    sink(1);
    return top;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // 上浮操作:上浮pq[k]实现自底向下调整 （用于插入）
  private void swim(int k) {
    while (k > 1 && less(k, parent(k))) {
      swap(parent(k), k);
      k = parent(k);
    }
  }

  // 下沉操作:下沉pq[k]实现自顶向下调整 （用于删除）
  private void sink(int k) {
    // left(k) > size 那就是沉到底 就无法继续下沉了
    while (left(k) <= size) {
      int smaller = right(k) > size ? left(k) : (less(left(k), right(k)) ? left(k) : right(k)); // 默认左孩子比较小；如果有右孩子，则比较出最小
      if (less(k, smaller))
        break; // k符合定义 调整完毕

      // 否则交换父节点和最小子节点
      swap(smaller, k);
      k = smaller; // 指向子节点位置，继续向下调整
    }
  }

  private int right(int k) {
    return 2 * k + 1;
  }

  private int left(int k) {
    return 2 * k;
  }

  private void swap(int s, int k) {
    K temp = pq[s];
    pq[s] = pq[k];
    pq[k] = temp;
  }

  private boolean less(int k, int s) {
    return pq[k].compareTo(pq[s]) < 0;
  }

  private int parent(int k) {
    return k / 2;
  }

}

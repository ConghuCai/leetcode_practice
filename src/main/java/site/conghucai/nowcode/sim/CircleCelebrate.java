package site.conghucai.nowcode.sim;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// [编程题]庆祝61
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 牛家庄幼儿园为庆祝61儿童节举办庆祝活动,庆祝活动中有一个节目是小朋友们围成一个圆圈跳舞。
// 牛老师挑选出n个小朋友参与跳舞节目,已知每个小朋友的身高h_i。为了让舞蹈看起来和谐,牛老师需要让跳舞的圆圈队形中相邻小朋友的身高差的最大值最小,牛老师犯了难,希望你能帮帮他。
// 如样例所示:
// 当圆圈队伍按照100,98,103,105顺时针排列的时候最大身高差为5,其他排列不会得到更优的解

public class CircleCelebrate {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    Queue<Integer> pq = new PriorityQueue<>(n);
    for (int i = 0; i < n; i++) {
      pq.offer(in.nextInt());
    }
    in.close();

    Node head = new Node(pq.poll());
    head.next = new Node(pq.poll());
    head.next.next = new Node(pq.poll());
    Node tail = head.next.next;
    tail.next = head;

    int len = 3;

    while (!pq.isEmpty()) {
      int height = pq.poll();

      // 确定插入位置
      Node bestPoint = head, p = head;
      int minCri = Integer.MAX_VALUE;
      for (int i = 0; i < len; i++) {
        int cri = Math.abs(height - p.val) + Math.abs(height - p.next.val);

        if (cri < minCri) {
          minCri = cri;
          bestPoint = p;
        }

        p = p.next;
      }

      // 插入队列
      Node newNode = new Node(height);
      newNode.next = bestPoint.next;
      bestPoint.next = newNode;

      if (bestPoint == tail) {
        tail = newNode;
      }

      // 更新最小值
      len++;
    }

    int ans = 0;
    Node p = head;
    do {
      ans = Math.max(Math.abs(p.val - p.next.val), ans);
      p = p.next;
    } while (p != head);

    System.out.println(ans);

  }

}

class Node {
  Node next;
  int val;

  public Node(int val) {
    this.val = val;
  }
}

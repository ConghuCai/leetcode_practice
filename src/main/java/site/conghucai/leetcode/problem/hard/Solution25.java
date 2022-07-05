package site.conghucai.leetcode.problem.hard;

import site.conghucai.leetcode.struct.ListNode;

// 25. K 个一组翻转链表
// 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
public class Solution25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    // 首先从head开始 向后找一组节点 用last指向最后一个
    // 然后将head ~ last范围内的节点逆转即可。
    if (head == null)
      return null;

    // 找一组节点
    ListNode last = head;
    for (int i = 0; i < k - 1; i++) { // head有了 向后再找k-1个就够一组了
      last = last.next;

      if (last == null) { // 说明后面不够一组了 不用逆转了
        return head;
      }
    }

    ListNode nextHead = last.next; // 在逆转前先保存下一组的头节点
    last.next = null;
    last = reverse(head); // 逆转head~last的这一组

    head.next = reverseKGroup(nextHead, k); // 此时head是组内最后一个节点，连接下一组逆转后的头节点即可。
    return last;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode last = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }
}

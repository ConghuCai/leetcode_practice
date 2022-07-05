package site.conghucai.leetcode.problem.middle;

import site.conghucai.leetcode.struct.ListNode;

// 19. 删除链表的倒数第 N 个结点
// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class Solution19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dimmy = new ListNode(-1, head), front = dimmy, back = dimmy; // 先后指针 front在back前面n个节点处
    for (int i = 0; i < n; i++) {
      front = front.next;
    }

    while (front.next != null) {
      front = front.next;
      back = back.next;
    }
    back.next = back.next.next;
    return dimmy.next;
  }
}

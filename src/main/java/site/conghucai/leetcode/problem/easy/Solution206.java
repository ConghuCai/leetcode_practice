package site.conghucai.leetcode.problem.easy;

import site.conghucai.leetcode.struct.ListNode;

// 206. 反转链表
// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class Solution206 {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode last = reverseList(head.next); // head.next之后的链表都已经反转

    // 逆转head和head.next的指针关系即可
    head.next.next = head;
    head.next = null;

    return last;
  }
}

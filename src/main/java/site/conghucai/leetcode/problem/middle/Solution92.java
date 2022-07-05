package site.conghucai.leetcode.problem.middle;

import site.conghucai.leetcode.struct.ListNode;

// 92. 反转链表 II
// 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
public class Solution92 {
  public ListNode reverseBetween(ListNode head, int left, int right) { // 反转head后left ~ right范围内的节点，返回反转后链表头节点
    if (left == 1) {
      return reverseN(head, right);
    }

    ListNode last = reverseBetween(head.next, left - 1, right - 1); // 对于head.next 需要反转的是left-1 ~ right-1
    head.next = last;

    return head;
  }

  private ListNode sucList; // 保存前n个节点后的那部分链表信息

  // 反转前n个节点
  private ListNode reverseN(ListNode head, int n) {
    if (n == 1) { // n到1时，就已经来到前n个的最后一个节点
      sucList = head.next; // 这个地方必须要后面的链表保存 不然会丢失
      return head;
    }

    ListNode last = reverseN(head.next, n - 1);

    head.next.next = head;
    head.next = sucList; // 对于第一个节点 反转后是最后一个 连接上前n个节点后的那部分链表
    return last;
  }
}

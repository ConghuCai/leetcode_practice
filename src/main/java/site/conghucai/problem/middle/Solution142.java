package site.conghucai.problem.middle;

import site.conghucai.struct.ListNode;

// 142. 环形链表 II
// 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 
// 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

// 不允许修改 链表。
public class Solution142 {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        break;
      }
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    // 一个指针指向头节点，一个指向相遇的节点 同步向前遍历 遇到的地方就是环的入口

    // 证明：假设链表总长L，环长度占m，快慢指针相遇的节点距离入口距离（相隔节点的个数）为k。
    // 则：头节点到环入口的长度为L-m，相遇点到环入口长度为m-k。
    // 则：快指针相遇前走了L+k,慢指针相遇前走了L-m+k。
    // 已知：快指针能和慢指针相遇，说明快指针走过的距离=2 * 慢指针走过的距离
    // 即：L + k = 2(L - m + k)，即L = 2m - k
    // 得证：L - m = m - k。即头节点到环入口的长度 = 相遇点到环入口长度。
    // 只要一个指针指向头节点，一个指向相遇的节点 同步向前遍历，相遇的地方就是环入口。
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }
}

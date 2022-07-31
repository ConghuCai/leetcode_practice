package site.conghucai.leetcode.problem.middle;

import site.conghucai.leetcode.struct.ListNode;

//	148. 排序链表
//	给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class Solution148 {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 归并法
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next; // 分成两条
        slow.next = null;

        head = sortList(head);
        head2 = sortList(head2);

        ListNode dimmy = new ListNode(-1);
        ListNode p = head, q = head2, r = dimmy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }

            r = r.next;
        }

        r.next = p != null ? p : q;

        return dimmy.next;
    }
}

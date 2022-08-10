package site.conghucai.leetcode.problem.hard;

import java.util.PriorityQueue;
import java.util.Queue;

import site.conghucai.leetcode.struct.ListNode;

// 23. 合并K个升序链表
// 给你一个链表数组，每个链表都已经按升序排列。

// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dimmy = new ListNode(-1);
        ListNode r = dimmy;
        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            r.next = p;
            r = r.next;

            if (p.next != null) {
                pq.offer(p.next);
            }
        }

        return dimmy.next;
    }
}

package site.conghucai.acm;

import java.util.Scanner;

import site.conghucai.problem.easy.Solution141;
import site.conghucai.problem.easy.Solution206;
import site.conghucai.problem.easy.Solution7;
import site.conghucai.problem.hard.Solution25;
import site.conghucai.problem.middle.Solution142;
import site.conghucai.problem.middle.Solution19;
import site.conghucai.problem.middle.Solution92;
import site.conghucai.struct.ListNode;

/* Type your acm test func here. function name format: test + num.  eg: test101*/
public class AcmFunc {
  public AcmFunc() {
  }

  void test7() {
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int ans = new Solution7().reverse(x);
    System.out.println(ans);
    s.close();
  }

  void test206() {
    Scanner s = new Scanner(System.in);
    String inputStr = s.nextLine();
    s.close();

    String[] nums = inputStr.split(" ");
    ListNode dimmy = new ListNode(-1);
    ListNode p = dimmy;
    for (String n : nums) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;

    ListNode ans = new Solution206().reverseList(head);
    StringBuilder sb = new StringBuilder();
    for (p = ans; p.next != null; p = p.next) {
      sb.append(p.val);
      sb.append(' ');
    }
    sb.append(p.val);
    System.out.println(sb.toString());
  }

  void test92() {
    Scanner s = new Scanner(System.in);
    String[] inputs = s.nextLine().split(" ");
    int left = s.nextInt();
    int right = s.nextInt();
    s.close();

    ListNode dimmy = new ListNode(-1), p = dimmy;
    for (String n : inputs) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;

    ListNode ans = new Solution92().reverseBetween(head, left, right);

    StringBuilder sb = new StringBuilder();
    for (p = ans; p.next != null; p = p.next) {
      sb.append(p.val);
      sb.append(' ');
    }
    sb.append(p.val);
    System.out.println(sb.toString());
  }

  void test25() {
    Scanner s = new Scanner(System.in);
    String[] inputs = s.nextLine().split(" ");
    int k = s.nextInt();
    s.close();

    ListNode dimmy = new ListNode(-1), p = dimmy;
    for (String n : inputs) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;

    ListNode ans = new Solution25().reverseKGroup(head, k);

    StringBuilder sb = new StringBuilder();
    for (p = ans; p.next != null; p = p.next) {
      sb.append(p.val);
      sb.append(' ');
    }
    sb.append(p.val);
    System.out.println(sb.toString());
  }

  void test141() {
    Scanner s = new Scanner(System.in);
    String[] inputs = s.nextLine().split(" ");
    int pos = s.nextInt();
    s.close();
    ListNode dimmy = new ListNode(-1), p = dimmy;
    for (String n : inputs) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;
    if (pos != -1) {
      ListNode r = head;
      for (int i = 0; i < pos; i++) {
        r = r.next;
      }
      p.next = r;
    }

    boolean ans = new Solution141().hasCycle(head);

    System.out.println(ans);
  }

  void test142() {
    Scanner s = new Scanner(System.in);
    String[] ins = s.nextLine().split(" ");
    int pos = s.nextInt();
    s.close();
    ListNode dimmy = new ListNode(-1), p = dimmy;
    for (String n : ins) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;
    if (pos != -1) {
      ListNode r = head;
      for (int i = 0; i < pos; i++) {
        r = r.next;
      }
      p.next = r;
    }

    ListNode ans = new Solution142().detectCycle(head);

    System.out.println(ans == null ? ans : ans.val);
  }

  void test19() {
    Scanner s = new Scanner(System.in);
    String[] inputs = s.nextLine().split(" ");
    int k = s.nextInt();
    s.close();

    ListNode dimmy = new ListNode(-1), p = dimmy;
    for (String n : inputs) {
      p.next = new ListNode(Integer.parseInt(n));
      p = p.next;
    }
    ListNode head = dimmy.next;

    ListNode ans = new Solution19().removeNthFromEnd(head, k);
    if (ans == null) {
      System.out.println(ans);
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (p = ans; p.next != null; p = p.next) {
      sb.append(p.val);
      sb.append(' ');
    }
    sb.append(p.val);
    System.out.println(sb.toString());
  }

  //
}

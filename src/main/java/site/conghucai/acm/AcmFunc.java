package site.conghucai.acm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

import site.conghucai.leetcode.problem.easy.Solution141;
import site.conghucai.leetcode.problem.easy.Solution206;
import site.conghucai.leetcode.problem.easy.Solution7;
import site.conghucai.leetcode.problem.hard.Solution10;
import site.conghucai.leetcode.problem.hard.Solution224;
import site.conghucai.leetcode.problem.hard.Solution25;
import site.conghucai.leetcode.problem.hard.Solution301;
import site.conghucai.leetcode.problem.hard.Solution32;
import site.conghucai.leetcode.problem.hard.Solution51;
import site.conghucai.leetcode.problem.hard.Solution727;
import site.conghucai.leetcode.problem.hard.Solution76;
import site.conghucai.leetcode.problem.hard.Solution85;
import site.conghucai.leetcode.problem.middle.Solution142;
import site.conghucai.leetcode.problem.middle.Solution19;
import site.conghucai.leetcode.problem.middle.Solution92;
import site.conghucai.leetcode.struct.ListNode;

/* Type your acm test func here. function name format: test + num.  eg: test101*/
public class AcmFunc {
    public AcmFunc() {
    }

    void test301() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        List<String> ans = new Solution301().removeInvalidParentheses(s);

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(ans.toString());
        out.newLine();
        out.flush();
    }

    void test727() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s1 = in.readLine();
        String s2 = in.readLine();

        String ans = new Solution727().minWindow(s1, s2);

        System.out.println(ans);
    }

    void test76() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        String ans = new Solution76().minWindow(s, t);

        System.out.println(ans);
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

    void test224() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int ans = new Solution224().calculate(s);

        System.out.println(ans);
    }

    void test51() throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        List<List<String>> ans = new Solution51().solveNQueens(n);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (List<String> res : ans) {
            for (String str : res) {
                writer.write(str);
                writer.newLine();
            }
            writer.newLine();
            writer.flush();
        }
    }

    void test32() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int ans = new Solution32().longestValidParentheses(s);

        System.out.println(ans);
    }

    void test85() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String[] lines = s.split(",");
        String[] line = lines[0].trim().split(" ");
        int m = lines.length, n = line.length;
        char[][] matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            line = lines[i].trim().split(" ");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]) == 0 ? '0' : '1';
            }
        }

        int ans = new Solution85().maximalRectangle(matrix);

        System.out.println(ans);

    }

    void test10() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine(), p = in.readLine();

        boolean ans = new Solution10().isMatch(s, p);

        System.out.println(ans);

    }
    //
}

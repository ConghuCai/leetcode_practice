package site.conghucai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

import site.conghucai.api.MyKMP;
import site.conghucai.leetcode.problem.hard.Solution123;
import site.conghucai.leetcode.problem.hard.Solution188;
import site.conghucai.leetcode.problem.middle.Solution486;
import site.conghucai.leetcode.problem.middle.Solution523;

public class ApiTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(1 + '0');
        out.newLine();
        out.write(str);
        out.flush();
    }

    @Test
    public void testParseInt() {
        int res = Integer.parseInt("0000001");
        System.out.println(res);
    }

    @Test
    public void testKMP() {
        String pat = "ababc";
        String txt = "abcababaabcabab";
        MyKMP kmp = new MyKMP(pat);
        System.out.println(kmp.search(txt));
    }

    @Test
    public void myTest001() {
        double pi = 3.1415926;
        String str = String.format("|%2.2f|", pi);
        System.out.println(str);

        System.out.println(String.format("|%05.2f|", pi));
    }

    @Test
    public void testSoluve123() {
        int[] prices = { 5 };
        int ans = new Solution123().maxProfit(prices);
        System.out.println(ans);
    }

    @Test
    public void testSoluve188() {
        int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
        int k = 4;
        int ans = new Solution188().maxProfit(k, prices);
        System.out.println(ans);
    }

    @Test
    public void testSoluve486() {
        int[] nums = { 1, 3, 1 };

        boolean ans = new Solution486().PredictTheWinner(nums);

        System.out.println(ans);
    }

    @Test
    public void testSoluve523() {
        int[] nums = { 1, 2, 3, 4, 5, 0, 0, 7 };
        int k = 8;

        boolean ans = new Solution523().checkSubarraySum(nums, k);

        System.out.println(ans);

    }

    @Test
    public void remoteSSHTest() {
        System.out.println("ssh test...");
    }
}

package site.conghucai.nowcode.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//最长基因序列
//求最长的由ATCG构成的子串长度
public class LongestGeneLen {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int dp = isInSet(s.charAt(0)) ? 1 : 0;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            dp = isInSet(s.charAt(i)) ? dp + 1 : 0;
            ans = Math.max(ans, dp);
        }

        System.out.println(ans);

    }

    private static boolean isInSet(char c) {
        char[] set = { 'A', 'T', 'C', 'G' };
        for (char i : set) {
            if (c == i) {
                return true;
            }
        }
        return false;
    }
}

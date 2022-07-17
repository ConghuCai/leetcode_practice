package site.conghucai.nowcode.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [编程题]偶串
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
// 牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1个或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
public class MaxDuplicateStrLen {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = s.length();

        int ans = 0;
        for (int end = n - 3; end >= 1; end -= 2) {
            if (isDuplicate(s, end)) {
                ans = end + 1;
                break;
            }
        }
        System.out.println(ans);
    }

    private static boolean isDuplicate(String s, int end) {
        for (int i = 0, j = end / 2 + 1; j <= end; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}

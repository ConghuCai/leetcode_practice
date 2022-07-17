package site.conghucai.nowcode.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [编程题]制造回文
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 牛牛有一些字母卡片,每张卡片上都有一个小写字母,所有卡片组成一个字符串s。牛牛一直认为回文这种性质十分优雅,于是牛牛希望用这些卡片拼凑出一些回文串,但是有以下要求:
// 1、每张卡片只能使用一次
// 2、要求构成的回文串的数量最少
// 牛牛想知道用这些字母卡片,最少能拼凑出多少个回文串。
// 例如: s = "abbaa",输出1,因为最少可以拼凑出"ababa"这一个回文串
// s = "abc", 输出3,因为最少只能拼凑出"a","b","c"这三个回文串
public class MinNumOfCircleStr {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = s.length();
        int[] nums = new int[26];
        for (int i = 0; i < n; i++) {
            nums[s.charAt(i) - 'a']++;
        }

        int sum = 0;
        for (int i : nums) {
            i %= 2;
            sum += i;
        }

        int ans = (sum == 0 ? 1 : sum);
        System.out.println(ans);
    }
}

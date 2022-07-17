package site.conghucai.nowcode.sim;

import java.util.Scanner;

// [编程题]猜数游戏
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 牛牛和羊羊在玩一个有趣的猜数游戏。在这个游戏中,牛牛玩家选择一个正整数,羊羊根据已给的提示猜这个数字。第i个提示是"Y"或者"N",表示牛牛选择的数是否是i的倍数。
// 例如,如果提示是"YYNYY",它表示这个数是1,2,4,5的倍数,但不是3的倍数。
// 注意到一些提示会出现错误。例如: 提示"NYYY"是错误的,因为所有的整数都是1的倍数,所以起始元素肯定不会是"N"。此外,例如"YNNY"的提示也是错误的,因为结果不可能是4的倍数但不是2的倍数。
// 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
// 例如 n = 5:
// 合法的提示有:
// YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
// YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
// 所以输出12
public class NumMultiplesReminder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        // 当设定i<=n 当i：
        // i是质数，那么N和Y都一定对，一定有两种填入法。
        // i是质数的非幂倍数，那么i位置只能根据其质数因子决定，质数因子都为Y，它才能填Y；质数为N，才能填N；因此不会增加数量。
        // i是质数的幂，像2、4一定有3种：NN、YN、YY；2、4、8一定有4种：NNN、YNY、YYN、YYY；可知，如果质数最大存在n次幂，那么就存在n+1次的可能性。
        // 因此这题就转换为了：在一定范围内寻找质数、质数的幂。

        boolean[] memo = new boolean[n + 1];
        memo[1] = true;
        long ans = 1;

        for (int i = 2; i <= n; i++) {
            if (memo[i]) {
                continue;
            }

            // i是质数
            // 标记i的倍数
            long longNum = i;
            long doubleI = longNum * longNum;
            if (doubleI <= n) {
                for (int j = i * i; j <= n; j += i) {
                    memo[j] = true;
                }
            }

            // 寻找i是否在n范围内存在幂
            long mi = i;
            int level = 0; // 记录最大幂的次数
            while (mi <= n) {
                mi *= i;
                level++;
            }

            ans = (ans * (level + 1)) % 1000000007;
        }

        System.out.println(ans);
    }
}

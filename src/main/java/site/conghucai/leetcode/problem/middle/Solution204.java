package site.conghucai.leetcode.problem.middle;

// 204. 计数质数
// 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
public class Solution204 {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        boolean[] memo = new boolean[n];

        memo[1] = true;
        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (memo[i]) { // 被访问过了 是素数 跳过
                continue;
            }

            // 是质数
            ans++;

            // 质数的倍数都是非质数 全部进行标记
            long longNum = (long) i;
            long doubleSize = longNum * longNum; // 这里从n×n开始标记 因为2*n 3*n一定已经被之前的质数标记过了;long是为了避免溢出
            if (doubleSize >= n) { // n*n超过范围 就不用再标了 反正也访问不到
                continue;
            }

            // 标记质数的所有倍数
            for (int j = i * i; j < n; j += i) {
                memo[j] = true;
            }
        }

        return ans;
    }
}

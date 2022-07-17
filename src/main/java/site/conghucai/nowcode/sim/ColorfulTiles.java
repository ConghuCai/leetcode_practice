package site.conghucai.nowcode.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [编程题]彩色瓷砖
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 牛牛喜欢彩色的东西,尤其是彩色的瓷砖。牛牛的房间内铺有L块正方形瓷砖。每块砖的颜色有四种可能:红、绿、蓝、黄。给定一个字符串S, 
// 如果S的第i个字符是'R', 'G', 'B'或'Y',那么第i块瓷砖的颜色就分别是红、绿、蓝或者黄。
// 牛牛决定换掉一些瓷砖的颜色,使得相邻两块瓷砖的颜色均不相同。请帮牛牛计算他最少需要换掉的瓷砖数量。
public class ColorfulTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int dp = 0;
        boolean isChange = false;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) || isChange) {
                isChange = false;
                continue;
            } else {
                dp = dp + 1;
                isChange = true;
            }
        }

        System.out.println(dp);

    }
}

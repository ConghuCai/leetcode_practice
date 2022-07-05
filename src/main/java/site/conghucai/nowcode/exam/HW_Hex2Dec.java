package site.conghucai.nowcode.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// [编程题]进制转换
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。

// 数据范围：保证结果在 int32内
public class HW_Hex2Dec {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String hex = in.nextLine();
    in.close();

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.put((char) (i + '0'), i);
    }
    for (int i = 10; i < 16; i++) {
      map.put((char) (i - 10 + 'A'), i);
    }

    int dec = 0, base = 1;
    int n = hex.length();
    for (int i = n - 1; i >= 2; i--) {
      dec += map.get(hex.charAt(i)) * base;

      base <<= 4;
    }

    System.out.println(dec);
  }
}

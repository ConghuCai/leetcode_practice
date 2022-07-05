package site.conghucai.leetcode.problem.hard;

import java.util.ArrayDeque;
import java.util.Deque;

//基本计算器
// 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。

// 提示：
// 1 <= s.length <= 3 * 105
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
// 输入中不存在两个连续的操作符
// 每个数字和运行的计算将适合于一个有符号的 32位 整数

public class Solution224 {
  public int calculate(String s) {
    return myCalculate(s, 0)[0];
  }

  private int[] myCalculate(String s, int pos) {
    int n = s.length();
    Deque<Integer> stack = new ArrayDeque<>();

    char sign = '+';
    int num = 0;

    int i = pos;
    for (; i < n; i++) {
      char c = s.charAt(i);

      // 遇到左括号：递归此过程 计算结果作为num。
      if (c == '(') {
        int[] res = myCalculate(s, i + 1);
        num = res[0];
        i = res[1]; // 递归计算后的游标 更新
      }

      // c是数字
      if (c >= '0' && c <= '9') {
        num = 10 * num + (c - '0');
      }

      // c不是数字 是符号
      // 符号则将之前解析的单个数字存到栈里面
      // 或者i已经走到尽头也需要将解析的数字存到栈里
      // 在这里略过空格
      if ((c < '0' || c > '9') && c != ' ' || i == n - 1) { // 注意：题目已经说了输入一定是合法的 因此不用担心输入非法字符
        switch (sign) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;

          // 如果有加减乘除 加上两个分支就可以了 （但是对于除法 由于stack只能盛放整数 如果不是整除会计算错误。。。）
          case '*':
            stack.push(num * stack.pop());
            break;
          case '/':
            stack.push(stack.pop() / num);
            break;

        }

        // 遇到右括号：计算完成 将之前 返回结果就行了
        if (c == ')') { // 注意：此时已经将解析的数字放在了stack中了 所以不用担心num丢失
          break;
        }

        // 清空数字 更改符号为当前检测到的符号 方便下一次加入数字时判断正负
        sign = c;
        num = 0;
      }

    }

    int ans = 0;
    while (!stack.isEmpty()) {
      ans += stack.pop();
    }
    return new int[] { ans, i }; // 返回游标最后所扫描的位置
  }
}

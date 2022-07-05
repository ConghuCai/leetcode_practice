package site.conghucai.nowcode.exam;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 编程题]明明的随机数
// 时间限制：C/C++ 1秒，其他语言2秒

// 空间限制：C/C++ 32M，其他语言64M

// 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。

// 数据范围： 1 - 1000 ，输入的数字大小满足 1 - 500

public class HW_RandomDeleteSort {
  public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    Queue<Integer> pq = new PriorityQueue<>(n);
    for (int i = 0; i < n; i++) {
      pq.offer(s.nextInt());
    }
    s.close();

    StringBuilder sb = new StringBuilder();
    int num = pq.poll();
    sb.append(num);
    sb.append('\n');

    while (!pq.isEmpty()) {
      if (num == pq.peek()) { // 重复
        pq.poll();
        continue;
      }

      num = pq.poll();
      sb.append(num);
      sb.append('\n');
    }

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    writer.write(sb.toString());
    writer.flush();
  }

}

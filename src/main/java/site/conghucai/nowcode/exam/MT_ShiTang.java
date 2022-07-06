package site.conghucai.nowcode.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

// [编程题]公司食堂
// 时间限制：C/C++ 2秒，其他语言4秒

// 空间限制：C/C++ 256M，其他语言512M

// 小美和小团所在公司的食堂有N张餐桌，从左到右摆成一排，每张餐桌有2张餐椅供至多2人用餐，公司职员排队进入食堂用餐。
// 小美发现职员用餐的一个规律并告诉小团：当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；

// 当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；

// 无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐。现在食堂内已有若干人在用餐，另外M个人正排队进入食堂，小团会根据小美告诉他的规律预测排队的每个人分别会坐哪张餐桌。

// 进阶：时间复杂度nlogn,空间复杂度n

public class MT_ShiTang {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int groups = Integer.parseInt(in.readLine());
    for (int t = 0; t < groups; t++) {
      int n = Integer.parseInt(in.readLine());
      char[] tables = in.readLine().toCharArray();
      int m = Integer.parseInt(in.readLine());
      char[] emps = in.readLine().toCharArray();

      Queue<Integer> pq1 = new PriorityQueue<>(); // 1-座位索引
      Queue<Integer> pq0 = new PriorityQueue<>(); // 0-座位索引

      for (int i = 0; i < n; i++) {
        if (tables[i] == '0') {
          pq0.offer(i);
        } else if (tables[i] == '1') {
          pq1.offer(i);
        }
      }

      for (int i = 0; i < m; i++) {
        int select = -1;
        if ((emps[i] == 'M' && !pq1.isEmpty()) || (emps[i] == 'F' && pq0.isEmpty())) {
          // 找最左侧1-座位
          select = pq1.poll(); // 1座位->2座位 再也不用考虑这个位置了

        } else if ((emps[i] == 'F' && !pq0.isEmpty()) || (emps[i] == 'M' && pq1.isEmpty())) {
          // 找最左侧0-座位
          select = pq0.poll();
          pq1.offer(select); // 0座位变成了1座位 加入到1-座位堆中
        }

        sb.append(select + 1);
        sb.append('\n');
      }
    }
    out.write(sb.toString());
    out.flush();
  }
}

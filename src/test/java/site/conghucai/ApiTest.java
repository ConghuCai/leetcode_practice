package site.conghucai;

import org.junit.Test;

import site.conghucai.api.MyPriorityQueue;

public class ApiTest {
  public static void main(String[] args) {
    int[] nums = { 2, 3, 5, 7, 43, 54, 8, 6, 65, 53, 13, 66, 91, 80, 11, 10 };

    MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(30);
    for (int num : nums) {
      pq.add(num);
    }

    for (int num = pq.delPeek(); !pq.isEmpty(); num = pq.delPeek()) {
      System.out.println(num);
    }
  }

  @Test
  public void testParseInt() {
    int res = Integer.parseInt("0000001");
    System.out.println(res);
  }
}

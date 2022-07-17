package site.conghucai.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StreamOprateDemo {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i : nums) {
      System.out.print(i + "\t");
    }

    String[] strs = Arrays.stream(in.readLine().split(" ")).map(s -> s.substring(0, 1))
        .sorted((s1, s2) -> s1.charAt(0) - s2.charAt(0)).toArray(String[]::new);
    for (String i : strs) {
      System.out.print(i + "\t");
    }
  }
}

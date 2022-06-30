package site.conghucai.process;

import java.util.Scanner;

public class InputProcess {
  public int[] readLimitInput() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    int i = 0;
    while (n-- > 0) {
      arr[i++] = scanner.nextInt();
    }

    scanner.close();
    return arr;
  }
}
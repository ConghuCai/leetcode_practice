package site.conghucai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

import site.conghucai.api.MyKMP;

public class ApiTest {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String str = in.readLine();

    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    out.write(1 + '0');
    out.newLine();
    out.write(str);
    out.flush();
  }

  @Test
  public void testParseInt() {
    int res = Integer.parseInt("0000001");
    System.out.println(res);
  }

  @Test
  public void testKMP() {
    String pat = "ababc";
    String txt = "abcababaabcabab";
    MyKMP kmp = new MyKMP(pat);
    System.out.println(kmp.search(txt));
  }

}

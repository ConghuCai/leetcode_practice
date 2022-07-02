package site.conghucai.process;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputProcess {
  public void println(String str) throws IOException {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    writer.write(str);
    writer.flush();
  }
}

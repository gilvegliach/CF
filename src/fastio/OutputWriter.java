package fastio;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class OutputWriter {
  private final PrintWriter writer;

  public OutputWriter(OutputStream outputStream) {
    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
  }

  public OutputWriter(Writer writer) {
    this.writer = new PrintWriter(writer);
  }

  public void print(Object... objects) {
    for (int i = 0; i < objects.length; i++) {
      if (i != 0) writer.print(' ');
      writer.print(objects[i]);
    }
  }

  public void println(Object... objects) {
    print(objects);
    writer.println();
  }

  public void printf(String format, Object... objects) {
    writer.printf(format, objects);
  }

  public void printfln(String format, Object... objects) {
    writer.printf(format + "\n", objects);
  }

  public void close() {
    writer.close();
  }

  public void flush() {
    writer.flush();
  }
}

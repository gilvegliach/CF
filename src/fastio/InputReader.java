package fastio;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

// Fast I/O
// Taken and modified from here:
// https://www.quora.com/What-is-the-best-way-in-Java-to-take-input-and-write-output-for-an-Online-Judge
public class InputReader {
  private InputStream is;
  private byte[] buff = new byte[8 * 1024];
  private int curChar;
  private int numChars;

  public InputReader(InputStream is) {
    this.is = is;
  }

  public int read() {
    if (numChars == -1) throw new InputMismatchException();
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = is.read(buff);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (numChars <= 0) return -1;
    }
    return buff[curChar++];
  }

  public int nextInt() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    int res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public String nextString() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isSpaceChar(c));
    return res.toString();
  }

  public double nextDouble() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    double res = 0;
    while (!isSpaceChar(c) && c != '.') {
      if (c == 'e' || c == 'E')
        return res * Math.pow(10, nextInt());
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    }
    if (c == '.') {
      c = read();
      double m = 1;
      while (!isSpaceChar(c)) {
        if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
        if (c < '0' || c > '9') throw new InputMismatchException();
        m /= 10;
        res += (c - '0') * m;
        c = read();
      }
    }
    return res * sgn;
  }

  public long nextLong() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    long res = 0;
    do {
      if (c < '0' || c > '9') throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public boolean isSpaceChar(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  public String next() {
    return nextString();
  }

  public int[] nextIntArray(int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) arr[i] = nextInt();
    return arr;
  }
}

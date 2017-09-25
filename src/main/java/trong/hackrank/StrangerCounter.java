package trong.hackrank;

import java.util.Scanner;
public class StrangerCounter {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long t = in.nextLong();

    long length = 3;
    while (t > length) {
      t = t - length;
      length = length*2;
    }

    System.out.println(length - t +1);
  }
}

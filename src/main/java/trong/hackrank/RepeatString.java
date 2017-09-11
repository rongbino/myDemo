package trong.hackrank;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class RepeatString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    long n = in.nextLong();

    int length = s.length();
    // find the how many a in this string
    char[] ch = s.toCharArray();
    long times = n/length;
    long remainder = n%length;

    int count = 0;
    int remainderCount = 0;
    for (int i = 0; i <= ch.length-1; i++) {
      if (ch[i] == 'a') {
        if (i + 1 <= remainder) {
          count++;
          remainderCount++;
        } else {
          count++;
        }
      }
    }

    System.out.println(count*times+remainderCount);
  }
}

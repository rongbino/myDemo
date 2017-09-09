package trong.hackrank;

import java.util.Scanner;

/**
 * Created by tommy on 2017/9/9.
 */
public class extraLong {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();

    String result = String.valueOf(size);
    for (int i = size - 1; i > 1; i--) {
      result = multi(result, String.valueOf(i));
    }

    System.out.print(result);
  }

  /**
   * 乘法原理  53*34
   *          AB*CD = AC(AD+BC)BD = 15(29)12 "从后往前满10进1"= 1802
   *
   * @param a
   * @param b
   * @return
   */
  public static String multi(String a, String b) {
    char chars1[] = a.toCharArray();
    char chars2[] = b.toCharArray();

    // define the array for the result
    int result[] = new int[chars1.length + chars2.length];
    int n1[] = new int[chars1.length];
    int n2[] = new int[chars2.length];

    // change char to int
    for (int i = 0; i < chars1.length; i++) {
      n1[i] = chars1[i] - '0';
    }
    for (int i = 0; i < chars2.length; i++) {
      n2[i] = chars2[i] - '0';
    }

    // multi
    for (int i = 0; i < chars1.length; i++) {
      for (int j = 0; j < chars2.length; j++) {
        result[i+j] += n1[i]*n2[j];
      }
    }

    for (int i = result.length-1; i > 0; i--) {
      result[i-1] += result[i]/10;
      result[i] = result[i]%10;
    }

    String resultStr = "";
    for (int i = 0; i < result.length-1; i++) {
      resultStr += ""+result[i];
    }
    return resultStr;
  }
}

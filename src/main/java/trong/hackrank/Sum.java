package trong.hackrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sum {

  static int simpleArraySum(int n, int[] ar) {
    // Complete this function
    int result = 0;
    if (n == 0) {
      return 0;
    } else {
      for (int i = 0; i <= n-1; i++) {
        result += ar[i];
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for(int ar_i = 0; ar_i < n; ar_i++){
      ar[ar_i] = in.nextInt();
    }

    Sum s = new Sum();
    int result = s.simpleArraySum(n, ar);
    System.out.println(result);
  }
}
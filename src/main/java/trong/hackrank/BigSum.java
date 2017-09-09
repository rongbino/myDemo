package trong.hackrank;

/**
 * Created by tommy on 2017/9/9.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSum {

  static long aVeryBigSum(int n, long[] ar) {
    // Complete this function
    BigInteger result = BigInteger.ZERO;
    if (n == 0) {
      return 0;
    } else {
      for (int i = 0; i <= n-1; n++) {
        result = result.add(BigInteger.valueOf(ar[i]));
      }
      return result.longValueExact();
    }
  }

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    long[] ar = new long[n];
//    for(int ar_i = 0; ar_i < n; ar_i++){
//      ar[ar_i] = in.nextLong();
//    }
//    BigSum b = new BigSum();
//    long result = b.aVeryBigSum(n, ar);
//    System.out.println(result);
//
    int[][] matrix = {{0,0},{0,0}};
    System.out.println(matrix[1][1]);
  }
}
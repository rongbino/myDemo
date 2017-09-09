package trong.hackrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tommy on 2017/9/9.
 */
public class MInMaxSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arr = new int[5];
    for(int arr_i=0; arr_i < 5; arr_i++){
      arr[arr_i] = in.nextInt();
    }

    // sort
    Arrays.sort(arr);

    BigInteger minSum = BigInteger.ZERO;
    BigInteger maxSum = BigInteger.ZERO;
    for (int i = 0; i <= 4; i++) {
      if (i != 0) {
        maxSum = maxSum.add(BigInteger.valueOf(arr[i]));
      }
      if (i != 4) {
        minSum = minSum.add(BigInteger.valueOf(arr[i]));
      }
    }

    System.out.println(minSum);
  }
}

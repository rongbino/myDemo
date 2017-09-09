package trong.hackrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tommy on 2017/9/9.
 */
public class BirthdayCandle {
  static int birthdayCakeCandles(int n, int[] ar) {
    // Complete this function
    if (n == 0) {
      return 0;
    }
    Arrays.sort(ar);
    int nums = 1;
    int tmp = ar[ar.length-1];
    for (int i = ar.length-2; i >= 0; i--) {
      if (ar[i] == tmp) {
        nums++;
        tmp = ar[i];
      } else {
        break;
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for(int ar_i = 0; ar_i < n; ar_i++){
      ar[ar_i] = in.nextInt();
    }
    BirthdayCandle b = new BirthdayCandle();
    int result = b.birthdayCakeCandles(n, ar);
    System.out.println(result);
  }
}

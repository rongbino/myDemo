package trong.hackrank;

import java.util.ResourceBundle;
import java.util.Scanner;

public class NoDivSubSet {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[k];

    /**
     * 计算原理
     * 如果两个数之和可以整除K，说明两个数除K的余数之和=K
     */
    for (int i = 0; i <n; i++) {
      arr[sc.nextInt()%k]++;
    }

    int result = 0;
    /**
     * 如果K为偶数，则+1
     * 例如 4 = 2+2，但是2 只能有1个算入结果
     */
    if (k%2==0) {
      result++;
    }

    // 整除的数只能加1
    result = result+Math.min(arr[0], 1);
    // 余数合 != k 取最大值
    for (int j=1; j<=k/2; j++) {
      if (j != k-j) {
        result += Math.max(arr[j], arr[k-j]);
      }
    }
    System.out.println(result);
  }
}

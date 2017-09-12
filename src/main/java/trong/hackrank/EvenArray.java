package trong.hackrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EvenArray {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();

    int[] originalArray = new int[count];
    for (int i = 0; i <= count-1; i++) {
      originalArray[i] = scanner.nextInt();
    }

    // complete your code in follow area
    // sort the original
    Arrays.sort(originalArray);

    // count the sum of the array
    int sum = 0;
    for (int i = 0; i <= originalArray.length - 1; i++) {
      sum += originalArray[i];
    }

    // the half of the sum
    int halfSum = sum/2;
    int location = 0;
    sum = 0;
    for (int i = 0; i <= originalArray.length-1; i++) {
      if (sum < halfSum) {
        sum += originalArray[i];
      }
      if (sum >= halfSum) {
        location = i;
        break;
      }
    }

    for (int i = 0; i <= originalArray.length-1; i++) {
      System.out.print(originalArray[i] + " ");
      if (i == location) {
        System.out.println();
      }
    }
  }
}

package trong.hackrank;

import java.util.Scanner;

/**
 * Created by tommy on 2017/9/9.
 */
public class Dag {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int[][] matrix = new int[size][size];
    for (int row = 0; row <= size - 1; row++) {
      for (int c = 0; c <= size - 1; c++) {
        matrix[row][c] = scanner.nextInt();
      }
    }

    int dag_one = 0;
    int dag_sec = 0;
    int fromEnd = size - 1;
    for (int i = 0; i <= size - 1; i++) {
      dag_one += matrix[i][i];
      dag_sec += matrix[i][fromEnd - i];
    }
    System.out.print(Math.abs(dag_one - dag_sec));
  }
}

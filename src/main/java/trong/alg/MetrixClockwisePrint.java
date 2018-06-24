package trong.alg;

/**
 * Print the N*N metrix in clockwise direction
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * The print result as follow
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class MetrixClockwisePrint {
  public static void main(String[] args) {
    int[][] metrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11,12}, {13, 14, 15, 16}};
    MetrixClockwisePrint metrixClockwisePrint = new MetrixClockwisePrint();
    metrixClockwisePrint.printMetrix(metrix, metrix[0].length);
    System.out.println();
    metrixClockwisePrint.printMetrixInClockWise(metrix, metrix[0].length);
  }

  public void printMetrix(int[][] metrix, int size) {
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        System.out.print(metrix[x][y] + " ");
      }
    }
  }

  /**
   * print the arrays in the clock wise circle
   * @param metrix
   * @param size
   */
  public void printMetrixInClockWise(int[][] metrix, int size) {
    if (size == 0 || metrix.length != metrix[0].length) {
      System.out.println("The array must be N*N size");
      return;
    }

    int top = 0;  // top index
    int right = size - 1; // right index
    int bottom = size -1; // bottom index
    int left = 0; // left index
    int dir = 1; // 1: print top  2: print right  3: print bottom  4: print left

    while (left <= right || top <= bottom) {
      if (dir == 1) {  // print from left to right
        for (int i = left; i <= right; i++) {
          System.out.print(metrix[top][i] + " ");
        }
        // move to next
        dir = 2;
        top++;
      } else if (dir == 2) { // print from top to bottom
        for (int i = top; i <= bottom; i++) {
          System.out.print(metrix[i][right] + " ");
        }
        // move to next
        dir = 3;
        right--;
      } else if (dir == 3) { // print from right to left
        for (int i = right; i >= left; i--) {
          System.out.print(metrix[bottom][i] + " ");
        }
        // move to next
        dir = 4;
        bottom--;
      } else if (dir == 4) { // print from bottom to top
        for (int i = bottom; i >= top; i--) {
          System.out.print(metrix[i][left] + " ");
        }
        // move to next
        dir = 1;
        left++;
      }
    }
  }
}

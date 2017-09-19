package trong.hackrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BigIsGreater {
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      int num = Integer.parseInt(in.readLine());
      for (int i = 0; i <= num - 1; i++) {
        char[] letters = in.readLine().toCharArray();

        int position = -1;
        for (int n = letters.length-1; n >= 0; n--) {
          for (int m = n-1; m >= 0; m--) {
            if (letters[m] < letters[n]) {
              position = m;
              // swap the two letter
              char tmp = letters[m];
              letters[m] = letters[n];
              letters[n] = tmp;
              break;
            }
          }
          if (position != -1) {
            break;
          }
        }
        char[] beforeP = Arrays.copyOfRange(letters, 0, position+1);
        char[] afterP = Arrays.copyOfRange(letters, position+1, letters.length);
        if (position == -1) {
          System.out.print("no answer");
        } else {
          System.out.print(beforeP);
          Arrays.sort(afterP);
          System.out.print(afterP);
        }
        System.out.println();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

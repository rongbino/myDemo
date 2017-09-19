package trong.hackrank;

import com.sun.tools.javac.util.List;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BigIsGreater {
  public static void main(String[] args) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(in.readLine());

      for (int i = 0; i <= num-1; i++) {
        String word = in.readLine();
        char[] letters = word.toCharArray();

        int start = -1;
        for (int n = 0; n < letters.length-1; n++) {
          if (letters[n] < letters[n+1]) {
            start = n;
          }
        }

        // no answer
        if (start == -1) {
          System.out.println("no answer");
          continue;
        }

        int end = -1;
        // it must exist, because in the letter[n+1] > letter[n]
        for (int n = start+1; n <= letters.length-1; n++) {
          if (letters[n] > letters[start]) {
            end = n;
          }
        }

        // swap
        char tmp = letters[end];
        letters[end] = letters[start];
        letters[start] = tmp;

        // reserve
        char[] beforeP = Arrays.copyOfRange(letters, 0, start + 1);
        char[] afterP = Arrays.copyOfRange(letters, start + 1, letters.length);
        System.out.print(beforeP);
        for (int n = afterP.length-1; n >=0; n--) {
          System.out.print(afterP[n]);
        }
        System.out.println();
      }
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package trong.hackrank;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BigIsGreater {
  public static void main(String[] args) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(in.readLine());

      String[] words = new String[num];
      for (int i = 0; i <= num-1; i++) {
        words[i] = in.readLine();
      }
      in.close();

      String input = "";
      for (int i = 0; i <= num-1; i++) {
        input = words[i];
        char[] letters = input.toCharArray();

        // lexicographical sort
        int start = -1;
        // find the first different
        for (int n = 0; n < letters.length-1; n++) {
          if (letters[n] < letters[n+1]) {
            start = n;
          }
        }
        if (start == -1) {
          System.out.println("no answer");
          continue;
        }

        int end = -1;
        // find the smallest letter
        for (int n = start + 1; n <= letters.length-1; n++) {
          if (letters[start] < letters[n]) {
            end = n;
          }
        }
        char tmp = letters[end];
        letters[end] = letters[start];
        letters[start] = letters[end];
        char[] beforeP = Arrays.copyOfRange(letters, 0, start + 1);
        char[] afterP = Arrays.copyOfRange(letters, start + 1, letters.length);
        System.out.print(beforeP);
        Arrays.sort(afterP);
        System.out.print(afterP);
        System.out.println();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

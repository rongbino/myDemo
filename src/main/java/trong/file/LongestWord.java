package trong.file;

import com.google.common.base.Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWord {
  public static void main(String[] args) throws FileNotFoundException{
    // the longest word
    String longest_word = "";
    // the current word to compare with longest one
    String current;
    Scanner scanner = new Scanner(new File("D:/word.txt")).useDelimiter("\\t|\\s+|,|;|\n|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");;

    while (scanner.hasNext()) {
      current = scanner.next();
      if (Strings.isNullOrEmpty(current)) {
        continue;
      }
      if (current.length() > longest_word.length()) {
        longest_word = current;
      }
    }

    if (Strings.isNullOrEmpty(longest_word)) {
      System.out.println("We did not found any one");
    } else {
      System.out.println("The longest word is \'" + longest_word + "\'");
    }
  }
}

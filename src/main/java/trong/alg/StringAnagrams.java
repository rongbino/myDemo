package trong.alg;

import java.util.Arrays;

public class StringAnagrams {
  public static void main(String[] args) {
    StringAnagrams stringAnagrams = new StringAnagrams();
    if (stringAnagrams.isAnagrams("abc", "cab")) {
      System.out.println("Anagrams");
    } else {
      System.out.println("Not Anagrams");
    }

    if (stringAnagrams.isAnagramsByArrays("aabbcc", "abcabc")) {
      System.out.println("2 Anagrams");
    } else {
      System.out.println("2 Not Anagrams");
    }
  }

  /**
   * check the string anagrams
   * 1. sort the char
   * 2. if they are equal, then they are string anagrams
   * @param a
   * @param b
   * @return
   */
  public boolean isAnagrams(String a, String b) {
    return Arrays.equals(a.chars().sorted().toArray(), b.chars().sorted().toArray());
  }

  /**
   * Assume all the letter are ascii between 0~256
   * for string a: every position add one
   * for string b: every position minus one
   *
   * if every position of array is 0, they are equal
   * @param a
   * @param b
   * @return
   */
  public boolean isAnagramsByArrays(String a, String b) {
    if (a.length() != b.length()) {
      return false; // length is not equal, definitely not string anagrams
    }
    int[] zero = new int[256];
    // for the string a, ++
    for (int i = 0; i < a.length(); i++) {
      zero[a.charAt(i)]++;
    }
    // for the string b, --
    for (int i = 0; i < a.length(); i++) {
      zero[b.charAt(i)]--;
    }
    // check every position of char
    for (int i = 0; i < zero.length; i++) {
      if (zero[i] != 0) {
        return false;
      }
    }
    return true;
  }
}

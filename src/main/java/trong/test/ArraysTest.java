package trong.test;

import java.util.Arrays;

public class ArraysTest {
  public static void main(String[] args) {
    char[] aa = {'a','b','c','d','e','f'};
    System.out.println(Arrays.copyOfRange(aa, 0, 3));
    System.out.println(Arrays.copyOfRange(aa, 3, aa.length));
    System.out.println(aa);
  }
}

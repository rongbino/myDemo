package trong.test;

/**
 * Created by rongbin on 2017/5/27.
 */
public class IntTest {
  public static void main(String[] args) {
    int a = -1;
    System.out.println(0 - a);

    int b = 5;
    int ze_b = 0 - b;
    System.out.println(ze_b);

    try {
      int aInt = Integer.valueOf("aa");
    } catch (Exception e) {
      System.out.println("1:" + e.getMessage());
      System.out.println("2:" + e.getMessage());
    }
  }
}

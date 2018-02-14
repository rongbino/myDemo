package trong.test;

/**
 * Created by rongbin on 2017/6/16.
 */
public class ExceptionTest {

  public static void main(String[] args) {

//    try {
//      ExceptionTest.exception(1);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      ExceptionTest.exception(2);
//    }

    for (int i = 0; i < 10; i++) {
      try {
        if (i == 5) {
          ExceptionTest.exception(i);
        }
        System.out.println("I am in " + i);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void exception(int i) {
    throw new RuntimeException("I am wrong " + i);
  }
}

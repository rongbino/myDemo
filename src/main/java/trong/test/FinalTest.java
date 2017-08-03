package trong.test;

/**
 * Created by rongbin on 2017/5/12.
 */

class LongTest {
  long longTest;

  public long getLongTest() {
    return longTest;
  }

  public void setLongTest(long longTest) {
    this.longTest = longTest;
  }
}

public class FinalTest {

  public static void main(String[] args) {

    LongTest tt = new LongTest();
    if (tt.getLongTest() > 0) {
      System.out.println("win");
    } else {
      System.out.println("Lost");
    }

    //    System.out.println(JsonHelper.);

    try {
      String aa = "1";
      System.out.println(aa.substring(0, 1));
      //      int a  = Integer.valueOf("aaaa");
      System.out.println("aaa/aa/bb/cc".split("/").length);
    } catch (Exception e) {
      e.printStackTrace();
      return;
    } finally {
      System.out.println("I am still in");
    }
  }
}

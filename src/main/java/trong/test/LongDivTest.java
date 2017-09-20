package trong.test;

public class LongDivTest {
  public static void main(String[] args) {
    Long a = Long.valueOf("123456789");
    Long b = Long.valueOf("1123456");

    Long c = a%b;
    System.out.println(c);
  }
}

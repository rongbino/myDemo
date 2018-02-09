package trong.test;

import scala.Int;

import java.math.BigDecimal;

public class IntegerTest {
  public static void main(String[] args) {
    Integer one = 1;
    Integer two = 2;
    Integer four = 4;

    Integer result = (one | two | four);

    System.out.println(result);

    BigDecimal z = BigDecimal.ZERO;
    BigDecimal z1 = BigDecimal.ZERO;
    BigDecimal a1 = BigDecimal.valueOf(10000.01);
    BigDecimal a2 = BigDecimal.valueOf(20000.02);

    z = z.add(a1);
    System.out.println(z);
    z = z.add(a2);
    System.out.println(z);

    System.out.println(z.add(a1).add(a2).toString());
  }
}

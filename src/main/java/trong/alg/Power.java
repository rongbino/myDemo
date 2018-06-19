package trong.alg;

public class Power {

  public static void main(String[] args) {
    Power power = new Power();
    System.out.println(power.power(2,3));
  }

  /**
   * calculate the number power with base and exponent
   *
   * @param base
   * @param exponent
   * @return
   */
  public long power(int base, int exponent) {
    long result = 1;
    while (exponent != 0) {
      result *= base;
      exponent--;
    }
    return result;
  }
}

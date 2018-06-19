package trong.alg;

public class HexToDecimal {
  public static void main(String[] args) {
    HexToDecimal hexToDecimal = new HexToDecimal();
    System.out.println(hexToDecimal.hexToDecimal("FF01"));
  }

  public long hexToDecimal(String hexadecimal) {
    char[] init = hexadecimal.toCharArray();
    // result
    long result = 0;
    for (int i = 0; i < init.length; i++) {
      int value = getInt(init[i]);
      result += value*Math.pow(16, init.length-i-1);
    }
    return result;
  }

  public int getInt(char i) {
    switch (i) {
      case 'A':
        return 10;
      case 'B':
        return 11;
      case 'C':
        return 12;
      case 'D':
        return 13;
      case 'E':
        return 14;
      case 'F':
        return 15;
    }
    return Integer.parseInt(""+i);
  }
}

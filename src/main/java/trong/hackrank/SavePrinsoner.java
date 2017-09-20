package trong.hackrank;

import java.util.Scanner;

public class SavePrinsoner {
  /**
   *
   * @param n   number of prisoners
   * @param m   number of sweets
   * @param s   number of start prisoner
   * @return
   */
  static int saveThePrisoner(int n, int m, int s){
    // Complete this function
    int lastCircl = m%n;
    int result = 0;
    if (lastCircl != 0) {
      result = s+lastCircl-1;
      if (result > n) {
        result = result%n;
      }
    } else {
      if (s == 1) {
        result = n;
      } else { // 选择最后一个拿到糖的人
        result = s-1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      int m = in.nextInt();
      int s = in.nextInt();
      int result = saveThePrisoner(n, m, s);
      System.out.println(result);
    }
  }
}

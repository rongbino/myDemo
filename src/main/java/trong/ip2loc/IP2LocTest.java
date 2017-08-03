package trong.ip2loc;

import java.util.Arrays;

/**
 * Created by rongbin on 2017/8/3.
 */
public class IP2LocTest {
  public static void main(String[] args) {
    IP.load("mydata4vipweek2.dat");
    System.out.println(Arrays.toString(IP.find("117.136.62.141")));
  }
}

package trong.hackrank;

import java.util.Scanner;

public class TimeConvert {

  public static String convertion(String s) {
    String tArr[] = s.split(":");
    String AmPm = tArr[2].substring(2,4);
    int hh,mm,ss;
    hh = Integer.parseInt(tArr[0]);
    mm = Integer.parseInt(tArr[1]);
    ss = Integer.parseInt(tArr[2].substring(0,2));

    String checkPM = "PM",checkAM ="AM";
    int h = hh;
    if(AmPm.equals(checkAM) && hh==12)
      h=0;
    else if(AmPm.equals(checkPM)&& hh<12)
      h+=12;

    return String.format("%02d:%02d:%02d",h,mm,ss);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String aa = convertion(input);
    System.out.println(aa);
  }
}

package trong.hackrank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tommy on 2017/9/9.
 */
public class ForEach {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int length = scanner.nextInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= length-1; i++) {
      list.add(scanner.nextInt());
    }
    //DecimalFormat d = new DecimalFormat("#.000000");
    long p = list.stream().filter(x->x>0).count();
    System.out.println(String.format("%.6f",(float)p/length));
    long n = list.stream().filter(x->x<0).count();
    System.out.println((float)n/length);
    long z = list.stream().filter(x->x==0).count();
    System.out.println((float)z/length);
  }
}

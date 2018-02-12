package trong.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rongbin on 2017/8/11.
 */
public class FormatTest {
  public static void main(String[] args) {
    System.out.println(String.format("heheh  %%Y%%d%%m %s, %s", "1", "2"));

    try {
      Date date = null;
      String time = "2016-03-11 13:22:05.01";
      SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      date = df1.parse(time);
      System.out.println(df1.format(date));
      SimpleDateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
      String newTime = df2.format(date);
      System.out.println(newTime);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

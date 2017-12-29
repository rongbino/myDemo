package trong.test;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
  public static void main(String[] args) {
    String ts_sec = "1507348493957";

//    DateTime dd = new DateTime();
//    System.out.println(dd.);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    String time = format.format(new Date(Long.valueOf(ts_sec) - 604800000)) ;
    System.out.println(time);
  }
}

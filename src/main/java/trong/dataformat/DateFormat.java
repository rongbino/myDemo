package trong.dataformat;

import java.text.SimpleDateFormat;

public class DateFormat {


  public static void main(String[] args) {
    String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd";
    String timestamp = "2019-02-02";
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT);
      long epoch = sdf.parse(timestamp).getTime();
      System.out.println(String.valueOf(epoch/1000));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

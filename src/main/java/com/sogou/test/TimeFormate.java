package com.sogou.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rongbin on 2017/5/17.
 */
public class TimeFormate {
  
  public static void main(String[] args) {
//    Calendar calendar = Calendar.getInstance();
//    Date date = new Date();
//
//    String sql = "select a, b, c, d from t4 where day = '{yyyyMMdd}' and min = '{HHmmss.SSS}'";
//    sql = parseSourceURI(calendar, sql);
//
//    System.out.println(sql);
//
//    String utc = "2017-06-07T03:42:42.045Z";
//    String local = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    String to = "yyyy-MM-dd HH:mm:ss.SSS";
//    System.out.println("local time :" + parseUTC(utc, local, to));


    ///
    String tempSeconds = "1499215877699|1499223391077|1499307813460|1499321818938|1499393329394";
    String[] ss = tempSeconds.split("\\|");
    SimpleDateFormat format = new SimpleDateFormat(to);
    Calendar c = Calendar.getInstance();
    for (String t : ss) {
      System.out.println(t);
      c.setTimeInMillis(Long.valueOf(t));
      Date date2 = c.getTime();
      System.out.println(format.format(date2));
    }

  }
  
  public static String parseUTC(String utcTime, String localtime, String to) {
    String resultTime = null;
    DateFormat format = new SimpleDateFormat(localtime);
    DateFormat toFormat = new SimpleDateFormat(to);
    try {
      
      Date date = format.parse(utcTime);
      toFormat.setTimeZone(TimeZone.getTimeZone("GMT-8")) ;
      resultTime = toFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return resultTime;
  }
  
  
  public static String parseSourceURI(Calendar calendar, String uri) {
    String resultUri;
    if (uri.indexOf("{") != -1) {
      int start = uri.indexOf("{");
      int last = uri.indexOf("}");
      String replaseStr = uri.substring(start, last+1);
      String formater = replaseStr.replace("{","").replace("}", "").trim();
      
      SimpleDateFormat format = new SimpleDateFormat(formater);
      String dateStr = format.format(calendar.getTime());
      resultUri = uri.replace(replaseStr, dateStr);
      
      // recursion for the next replace str
      resultUri = parseSourceURI(calendar, resultUri);
    } else {
      resultUri = uri;
    }
    
    return resultUri;
  }
}

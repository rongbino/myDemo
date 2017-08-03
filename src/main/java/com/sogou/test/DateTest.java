package com.sogou.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by rongbin on 2017/6/15.
 */
public class DateTest {
  
  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.now();
    long time = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    System.out.println("Date 1 in seconds :" + time);
    try {
      Thread.currentThread().sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Date 2 in seconds :" + System.currentTimeMillis()/1000L);
    
    
    long start = System.currentTimeMillis();
    try {
      Thread.currentThread().sleep(1233);
    } catch (Exception e) {
      e.printStackTrace();
    }
    long a = 10001;
    long b = 10113;
    System.out.println(Math.ceil((b - a)/1000L));
    int aa = (int)Math.ceil((b - a)/1000L);
    System.out.println(aa);
  }
}

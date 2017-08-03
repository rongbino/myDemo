package trong.test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by rongbin on 2017/6/27.
 */
public class CheckErrorPhone {
  public static void main(String[] args) {
    try {
      HashMap<String, String> result = new HashMap();
      File file = new File("D:/26769-all-data-send.csv");
      BufferedReader reader = new BufferedReader(new FileReader(file));

      String temp = null;
      String lastPhone = null;
      int line = 0;

      List<Long> timeList = new ArrayList<>();
      while ((temp = reader.readLine()) != null) {
        line++;
        String[] aa = temp.split(",");
        String phone = aa[2].replace("\"", "").trim();
        String time = aa[0].replace("\"", "").trim();
        String returnCode = aa[8].replace("\"", "").trim();
        // new phone
        if (lastPhone == null || !phone.equals(lastPhone)) {
          timeList.clear();
          lastPhone = phone;
        } else {
          Date d = null;
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
          d = simpleDateFormat.parse(time);
          Long now = d.getTime();

          for (Long tt : timeList) {
            if (Math.abs(tt - now) < 60000 && !result.containsKey(phone)) {
              result.put(phone, time + " " + phone + " " + returnCode);
              System.out.println(time + " " + phone + " " + returnCode + ": " + Math.abs(tt - now));
            }
          }

          timeList.add(now);
        }
      }

      System.out.println(line);
      System.out.println("Map size:" + result.size());
      reader.close();

      //      File phoneFile = new File("D:/phone.txt");
      //      FileOutputStream outputStream = new FileOutputStream(phoneFile);
      FileWriter writer = new FileWriter("D:/phone.txt");
      for (String aa : result.keySet()) {
        writer.write(aa + "\r\n");
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

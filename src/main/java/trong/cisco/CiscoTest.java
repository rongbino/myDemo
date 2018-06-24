package trong.cisco;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CiscoTest {
  public static void main(String[] args) {
    try {
      // the hash map store the number
      HashMap<String, Integer> calculate = new HashMap<>();

      // load the file in java scanner line by line into memory
      Scanner scanner = new Scanner(new File("/Users/tommy/Desktop/log.json"));
      ObjectMapper mapper = new ObjectMapper();

      // parse the file
      while (scanner.hasNext()) {
        String log = scanner.nextLine();
        LogObj obj = mapper.readValue(log, LogObj.class);

        String[] paths = obj.getPh().split("/");
        for (String ph : paths) {
          if (Strings.isNullOrEmpty(ph)) {
            continue;
          }
          if (calculate.containsKey(ph)) {
            calculate.put(ph, calculate.get(ph)+1);
          } else {
            calculate.put(ph, 1);
          }
        }
      }

      // get the greatest
      Iterator<String> keys = calculate.keySet().iterator();
      String maxKey = "";
      int max = 0;
      while (keys.hasNext()) {
        String key = keys.next();
        int amount = calculate.get(key);
        if (amount > max) {
          maxKey = key;
          max = amount;
        }
      }

      System.out.printf("The maxKey %s with amount %d", maxKey, max);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

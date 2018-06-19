package trong.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class FileScanner {
  public static void main(String[] args) {
    HashMap<String, Integer> count = new HashMap<>();
    try {
      FileInputStream inputStream = new FileInputStream(new File("D:/word.txt"));
      Scanner scanner = new Scanner(inputStream).useDelimiter("\\t|\\s+|,|;|\n|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
      while(scanner.hasNext()) {
        String key = scanner.next();
        System.out.println(key);
        if (Strings.isNullOrEmpty(key)) {
          continue;
        }
        if (count.containsKey(key)) {
          count.put(key, count.get(key).intValue() + 1);
        } else {
          count.put(key, 1);
        }
      }
      ObjectMapper mapper = new ObjectMapper();
      System.out.println(mapper.writeValueAsString(count));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

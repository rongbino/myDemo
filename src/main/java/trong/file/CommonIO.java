package trong.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class CommonIO {
  public static void main(String[] args) {
    HashMap<String, Integer> count = new HashMap<>();
    try {
      LineIterator lineIterator = new LineIterator(new FileReader(new File("D:/word.txt")));
      while (lineIterator.hasNext()) {
        String line = lineIterator.next();
        String[] keys = line.split("\\t|\\s+|,|;|\n|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
        for (String key : keys) {
//          System.out.println(key);
          if (Strings.isNullOrEmpty(key)) {
            continue;
          }
          if (count.containsKey(key)) {
            count.put(key, count.get(key).intValue() + 1);
          } else {
            count.put(key, 1);
          }
        }
      }
      ObjectMapper mapper = new ObjectMapper();
      System.out.println(mapper.writeValueAsString(count));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}

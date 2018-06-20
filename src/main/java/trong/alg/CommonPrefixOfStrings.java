package trong.alg;

import com.fasterxml.jackson.core.JsonProcessingException;
import trong.utils.JsonMapperObj;

import java.util.Arrays;

public class CommonPrefixOfStrings {
  public static void main(String[] args) {
    String[] strs = {"geeekey", "geeaabb", "geeccadddcc", "geeac"};

    try {
      // find the greatest common prefix
      CommonPrefixOfStrings commonPrefixOfStrings = new CommonPrefixOfStrings();
      System.out.println(commonPrefixOfStrings.findCommonPrefix(strs));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public String findCommonPrefix(String[] args) throws JsonProcessingException {
    if (args == null) {
      return ""; // return "" for null
    }
    if (args.length == 1) {
      return args[0];
    }
    // result
    StringBuffer result = new StringBuffer();

    // sort the string as dic
    Arrays.sort(args);
    // print the string after sort
    System.out.println(JsonMapperObj.obj2Str(args));
    // the min length
    int min = Math.min(args[0].length(), args[args.length-1].length());
    for (int i = 0; i < min; i++) {
      if (args[0].charAt(i) == args[args.length-1].charAt(i)) {
        result.append(args[0].charAt(i));
      } else {
        break;
      }
    }
    return result.toString();
  }
}

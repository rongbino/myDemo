package trong.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rongbin on 2017/6/1.
 */
public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<String> s = new ArrayList<>();

    s.add("a=b");
    s.add("a=2");
    s.add("a=3");

    System.out.println(String.join(",", s));

    String bb = "aaa";
    Collections.addAll(s, bb.split("/"));
    System.out.println(String.join(",", s));

    String aa[] = {"1","2"};
    List<String> ss = Arrays.asList(aa);

    System.out.println(ss);
  }
}

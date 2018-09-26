package trong.test;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rongbin on 2017/6/1.
 */
public class ArrayListTest {
  public static void main(String[] args) {
    ArrayListTest.ArrayTest();
  }

  public static void ArrayTestOne() {
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

  public static void ArrayTest() {
    ArrayList<String> one = new ArrayList<>();
    one.add("1");
    one.add("2");

    ArrayList<String> two = new ArrayList<>(one);
    two.add("3");
    two.add("4");

    System.out.println("two=====");
    System.out.println(two);
    System.out.println("one+++++");
    System.out.println(one);
  }
}

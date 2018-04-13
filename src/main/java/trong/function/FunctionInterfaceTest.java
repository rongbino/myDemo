package trong.function;

import com.meidusa.amoeba.sqljep.function.In;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FunctionInterfaceTest {
  public static void main(String[] args) {
    Converter<String, Integer> convert = (from)->Integer.valueOf(from);
    Integer convered = convert.convert("123");
    System.out.println(convered);

    // test ::
//    Integer ii = new Integer(1);
    Converter<String, Integer> testConvert = Integer::valueOf;
    Integer returnInt = testConvert.convert("2222");
    System.out.println(returnInt);

    // predicated
    Predicate<String> predicate = (s)-> s != null && s.length()>0;
    System.out.println(predicate.test(null));
    System.out.println(predicate.test("1"));
    System.out.println(predicate.test(""));

    // stream filter and sort
    ArrayList<String> testList = new ArrayList<>();
    testList.add("caaa");
    testList.add("aaaa");
    testList.add("abbb");
    testList.add("bbbb");

    ArrayList<String> test2 = new ArrayList<>();
    // sort
    System.out.println("//////// test init sort");
    testList.stream().sorted().forEach((s)->{test2.add(s); System.out.println(s);});
    System.out.println("/////// test 2");
    test2.stream().forEach((s)->System.out.println(s));
    System.out.println("//////// filter with start a");
    test2.stream().filter((s)->s.startsWith("a")).forEach((s)->System.out.println(s));
    System.out.println("//////// map to up case");
    test2.stream().map((s)->s.toUpperCase()).forEach((s)->System.out.println(s));
  }
}

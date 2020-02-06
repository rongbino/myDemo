package trong.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        String test = "/5/aaa.csv";
        String[] vl = test.split("/");

        String vl_bucket = vl[1];
        String vl_path = Arrays.stream(vl).skip(2).collect(Collectors.joining("/"));

        System.out.println("vl_bucket :" + vl_bucket);
        System.out.println("vl_path :" + vl_path);
    }
}

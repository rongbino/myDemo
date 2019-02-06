package trong.list;

import java.util.ArrayList;
import java.util.List;

public class ListSub {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("1");
        all.add("2");
        all.add("3");
        all.add("4");
        all.add("5");
        all.add("6");
        all.add("7");

        int size = all.size();
        int start = 0;
        int offset = 2;

        List<String> tmp = new ArrayList<>();
        while (offset <= size) {
            /**
             * sublist
             * include the start index
             * exclude the to index
             */
            tmp = all.subList(start, offset);
            System.out.println(tmp);
            start = offset;
            offset = offset + 2;
        }
        if (start < size) {
            tmp = all.subList(start, size);
            System.out.println(tmp);
        }

    }
}

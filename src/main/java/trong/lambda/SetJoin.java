package trong.lambda;

import trong.obj.A;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetJoin {

    public static void main(String[] args) {
        HashSet<A> set = new HashSet<>();
        A a1 = new A();
        a1.setA("a1");
        A a2 = new A();
        a2.setA("a2");

        set.add(a1);
        set.add(a2);

        System.out.println(set.stream().map(n -> n.getA()).collect(Collectors.joining(" ,")));
    }
}



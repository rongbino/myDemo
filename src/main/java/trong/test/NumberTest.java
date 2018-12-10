package trong.test;

public class NumberTest {

    public static void main(String[] args) {
        NumberTest.LongTest();
    }

    public static void LongTest() {
        long one = 100;
        long two = 200;
        long three = two - 300;

        long re = 1000 - three;
        System.out.println(re);
    }
}

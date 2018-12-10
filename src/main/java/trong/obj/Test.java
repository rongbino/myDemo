package trong.obj;

public class Test {
    private A a;
    public static void main(String[] args) {
        A aa = new A();
        aa.setA("1");
        aa.setB("2");

        Test t = new Test();
        t.setA(aa);
        t.update();

        System.out.println("A:" + aa.getA());
        System.out.println("B:" + aa.getB());
    }

    public void setA(A a) {
        this.a = a;
    }

    public void update() {
        this.a.setA("3");
        this.a.setB("4");
    }
}

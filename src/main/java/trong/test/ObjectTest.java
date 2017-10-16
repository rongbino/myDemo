package trong.test;

public class ObjectTest {
  public static void main(String[] args) {
    A aa = new A("1");
    System.out.println("The original val is " + aa.getA());
    ObjectTest.changeVal(aa, "2");
    System.out.println("The newVal is " + aa.getA());
  }

  public static void changeVal(A a, String newVal) {
    a.setA(newVal);
  }
}

class A {
  private String a;
  public A(String a) {
    this.a = a;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }
}

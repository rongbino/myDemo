package trong.mr;

import com.sogou.upd.passport.common.utils.JacksonJsonMapperUtil;

public class ClassTest {
  public static void main(String[] args) {
    A a = new A();
    a.setAa("aa");
    a.setBb("bb");

    try {
      System.out.println(JacksonJsonMapperUtil.getMapper().writeValueAsString(a));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

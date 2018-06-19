package trong.apache;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

public class BeanUtilsTest {


  public static void main(String[] args) {
    BeanUtilsTest b = new BeanUtilsTest();

    // init the bean
    Bean a = new Bean();
    a.setAa("a");
    a.setBb("b");

    String[] params = {"aa","bb","cc","aa","bb"};
    for (int i = 0; i < params.length; i++) {
      try {
        String s = BeanUtils.getSimpleProperty(a, params[i]);
        System.out.println(params[i] + " = " + s);
      }catch (Exception e) {
        params = ArrayUtils.remove(params, ArrayUtils.indexOf(params, params[i]));
        i--;
        e.printStackTrace();
      }
    }
  }
}



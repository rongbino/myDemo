package trong.mr;

import com.sogou.upd.passport.common.utils.JacksonJsonMapperUtil;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import java.time.format.DateTimeFormatter;

public class ClassTest {
  public static void main(String[] args) {
    A a = new A();
    a.setAa("aa");
    a.setBb("bb");

    System.out.println(a.getTime().format(DateTimeFormatter.ISO_DATE_TIME));
    try {
      System.out.println(JacksonJsonMapperUtil.getMapper().writeValueAsString(a));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package trong.annotation;

import com.google.common.reflect.Reflection;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Field;

public class AnnotationTest {

  @UserAnnotation(id = 100, desc = "Tommy")
  public String user = "";

  @UserAnnotation
  public String defaultUser = "";

  public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

    AnnotationTest test = new AnnotationTest();
    Field userFiled = AnnotationTest.class.getField("user");

    UserAnnotation userAnnotation = userFiled.getAnnotation(UserAnnotation.class);
    System.out.println("id: " + userAnnotation.id() + " desc: " + userAnnotation.desc());

    Field defaultUserFile = AnnotationTest.class.getField("defaultUser");
    UserAnnotation defaultUserAnnotation = defaultUserFile.getAnnotation(UserAnnotation.class);
    System.out.println("default id: " + defaultUserAnnotation.id() + " default desc: " + defaultUserAnnotation.desc());
  }
}

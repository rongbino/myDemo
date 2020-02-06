package trong.annotation;

import java.lang.reflect.Field;

@Hint("111")
@Hint("222")
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

    Hint[] hints = AnnotationTest.class.getAnnotationsByType(Hint.class);
    System.out.println(hints.length);
  }
}

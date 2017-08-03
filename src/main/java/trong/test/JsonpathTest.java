package trong.test;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by rongbin on 2017/7/11.
 */
public class JsonpathTest {
  public static void main(String[] args) {
    JsonpathTest t = new JsonpathTest();
    String json = t.readString("D:/suss.json");
    System.out.println(json);

    int code = JsonPath.read(json, "$.code");
    Object msg = JsonPath.read(json, "$.message");
    System.out.println(code);
    System.out.println(msg);

    Integer id = JsonPath.read(json, "$.data.id");
    System.out.println(id);
    String email = JsonPath.read(json, "$.data.email");
    System.out.println(email);
    List<Object> passportPerm = JsonPath.read(json, "$.data.grantPerms[?(@.entity == '1120')]");
    System.out.println(passportPerm);
    Map<String, Object> map = (Map<String, Object>) passportPerm.get(0);
    Integer permId = (Integer) map.get("permId");
    System.out.println(permId);
  }

  public String readString(String fileName) {
    String str = "";
    File file = new File(fileName);
    try {
      FileInputStream in = new FileInputStream(file);
      int size = in.available();
      byte[] buffer = new byte[size];
      in.read(buffer);
      in.close();
      str = new String(buffer, "UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return str;
  }
}

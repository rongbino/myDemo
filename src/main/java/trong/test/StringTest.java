package trong.test;

/**
 * Created by rongbin on 2017/5/22.
 */
public class StringTest {

  public static void main(String args[]) {
    //    String aa = 1 + "2";
    //    String bb = String.valueOf(1) + "2";
    //
    //    String cc = "\"" + 5;
    //
    //    String dd = "aaaaaa";
    //    String[] dde = dd.split("/");
    //
    //    System.out.println(dde.length);
    //    System.out.println(dde[0]);

    String parameters = "parameters:{transient_lastDdlTime=1494299894, totalSize=9187, EXTERNAL=TRUE, numFiles=26},viewOriginalText:null, viewExpandedText:null, tableType:EXTERNAL_TABLE)";
    parameters = parameters.replace("}", ",");
    parameters = parameters.substring(parameters.lastIndexOf("numFiles"));
    //    System.out.println(parameters);

    int start = parameters.indexOf("=");
    //    System.out.println(start);
    if (start != -1) {
      int end = parameters.indexOf(",");
      if (end != -1) {
        parameters = parameters.substring(start + 1, end);
        System.out.println(parameters);
      }

    }

    String[] aa = {"a"};
    System.out.println("{" + String.join(",", aa) + "}");

    String a = null;

    StringBuffer buffer = new StringBuffer();
    buffer.append("{");
    buffer.append(a);
    buffer.append("}");

    System.out.println(buffer.toString());
  }
}

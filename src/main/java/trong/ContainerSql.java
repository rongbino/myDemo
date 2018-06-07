package trong;

import org.springframework.core.env.ConfigurableEnvironment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContainerSql {
  public static void main(String[] args) {
    ContainerSql sql = new ContainerSql();
    sql.write5();
    sql.write6();
  }

  public void write5() {
    String sql = "INSERT INTO container (container_no, door_no, amount, additional_information) VALUES ";
    try {
      FileWriter fileWriter = new FileWriter("D://5.txt");
      for (int i = 4; i <= 27; i++) {
        String num = "";
        if (i < 10) {
          num = "50" + i;
        } else {
          num = "5" + i;
        }
        String str1 = sql + "(" + "'11-5'," + "'" + i + "', " +  "1, " + "'5号柜" + num + "门');\n";
        fileWriter.write(str1);
      }
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void write6() {
    String sql = "INSERT INTO container (container_no, door_no, amount, additional_information) VALUES ";
    try {
      FileWriter fileWriter = new FileWriter("D://6.txt");
      for (int i = 4; i <= 27; i++) {
        String num = "";
        if (i < 10) {
          num = "60" + i;
        } else {
          num = "6" + i;
        }
        String str1 = sql + "(" + "'11-6'," + "'" + i + "'," + "1, " + "'6号柜" + num + "门');\n";
        fileWriter.write(str1);
      }
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

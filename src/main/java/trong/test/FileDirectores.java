package trong.test;

import com.google.common.base.Strings;

import java.io.File;

/**
 * Created by rongbin on 2017/5/9.
 */
public class FileDirectores {

  public void readFiles(String filepath, String[] path, int level) {
    File file = new File(filepath);
    path[level] = file.getName();
    if (level < path.length - 1) {
      File[] files = file.listFiles();

      for (File f : files) {
        readFiles(f.getAbsolutePath(), path, level + 1);
      }
    } else {
      System.out.println(String.join("/", path));
      File[] files = file.listFiles();
      for (File f : files) {
        System.out.println(Strings.repeat("*", level) + f.getName());
      }

    }
  }

  public void readDirectories(String filepath, int partitions) {
    String[] path = new String[partitions];

    File ff = new File("D:/test");
    File[] files = ff.listFiles();
    for (File file : files) {
      readFiles(file.getAbsolutePath(), path, 0);
    }
  }

  public static void main(String args[]) {
    FileDirectores f = new FileDirectores();

    f.readDirectories("D:/test", 10);

    //    File ff = new File("D:/test");
    //    File[] files = ff.listFiles();
    //    for (File file : files) {
    //      f.readFiles(file.getAbsolutePath(), filepath, 0);
    //    }
  }
}

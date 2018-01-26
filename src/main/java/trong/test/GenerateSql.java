package trong.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateSql {
  public static void main(String[] args) {
//    GenerateSql.createSql();
    GenerateSql.createSigleSql();
  }

  public static void createSigleSql() {
    String sql = "";
    String output = "/search/data/opdir/dsj";
    String dbname = " sogou_passport.";
    String foramt = " CHARACTER SET utf8 FIELDS TERMINATED BY '\\t' LINES TERMINATED BY '\\n'';\n";
    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String tablename = "account" + "_" + num;
      String fileNum = dbname + tablename;
      sql += "select passport_id, mobile, reg_time, account_type from " + fileNum + " into outfile '" + output +
         "/" + tablename + foramt;
    }

    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String tablename = "account_info" + "_" + num;
      String fileNum = dbname + tablename;
      sql += "select passport_id, email, gender from " + fileNum + " into outfile '" + output +
        "/" + tablename + foramt;
    }

    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String tablename = "mobile_passportid_mapping" + "_" + num;
      String fileNum = dbname + tablename;
      sql += "select passport_id, email, gender from " + fileNum + " into outfile '" + output +
        "/" + tablename + foramt;
    }

    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String tablename = "passportid_unionid_mapping" + "_" + num;
      String fileNum = dbname + tablename;
      sql += "select passport_id, email, gender from " + fileNum + " into outfile '" + output +
        "/" + tablename + foramt;
    }

    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String tablename = "unionid_mobile_mapping" + "_" + num;
      String fileNum = dbname + tablename;
      sql += "select passport_id, email, gender from " + fileNum + " into outfile '" + output +
        "/" + tablename + foramt;
    }

    createFile("sql2", sql);
  }

  public static void createSql() {
    String sql = "";
    for (int i = 0; i < 32; i++) {
      String num = String.format("%02d", i);
      String fileNum = "sogou_passport.account" + "_" + num;
      sql = "select passport_id, mobile, reg_time, account_type from " + fileNum + ";";
      GenerateSql.createFile("account" + "_" + num, sql);
      fileNum = "sogou_passport.account_info" + "_" + num;
      sql = "select passport_id, email, gender from " + fileNum + ";";
      GenerateSql.createFile("account_info" + "_" + num, sql);
      fileNum = "sogou_passport.mobile_passportid_mapping" + "_" + num;
      sql = "select passport_id, mobile from " + fileNum + ";";
      GenerateSql.createFile("mobile_passportid_mapping" + "_" + num, sql);
      fileNum = "sogou_passport.passportid_unionid_mapping" + "_" + num;
      sql = "select passport_id, provider, unionid from " + fileNum + ";";
      GenerateSql.createFile("passportid_unionid_mapping" + "_" + num, sql);
      fileNum = "sogou_passport.unionid_mobile_mapping" + "_" + num;
      sql = "select unionid, provider, mobile from " + fileNum + ";";
      GenerateSql.createFile("unionid_mobile_mapping" + "_" + num, sql);
    }
  }

  public static void createFile(String filename, String sql) {
    String path = "D:/sql/" + filename+".sql";
    try {
      FileWriter w = new FileWriter(path, true);
      BufferedWriter bw = new BufferedWriter(w);
      bw.write(sql);
      bw.close();
      w.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

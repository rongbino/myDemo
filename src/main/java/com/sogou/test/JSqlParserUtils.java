package com.sogou.test;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

/**
 * Created by rongbin on 2017/4/19.
 */
      public class JSqlParserUtils {
        public static void main(String [] args) {
          try {
        
//            net.sf.jsqlparser.statement
//            net.sf.jsqlparser.statement.Statement statement = CCJSqlParserUtil.parse("create table table_name AS SELECT orderdata, price FROM orders GROUP BY orderdate");
//
//            Select selectStatement = (Select)statement;
//            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//            List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
//
//            tableList.forEach(n->System.out.println(n));
//            System.out.println();


//      net.sf.jsqlparser.statement.Statement statement = CCJSqlParserUtil.parse("WITH\n" +
//              "  t1 AS (SELECT udid FROM db1.dw_sign_orc where cdate=20170326),\n" +
//              "  t2 AS (SELECT a1 FROM db2.orc_spec where cdate=20170328)\n" +
//              "SELECT count(distinct t2.a1)\n" +
//              "FROM t1\n" +
//              "JOIN t2 ON upper(t1.udid) = upper(t2.a1)");
//
//      Select selectStatement = (Select)statement;
//      TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//      List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
//
//      tableList.forEach(n->System.out.println(n));
//      System.out.println();

//      statement = CCJSqlParserUtil.parse("SELECT a.time_updated_server/1000, \n" +
//              "content, \n" +
//              "nick, \n" +
//              "name \n" +
//              "FROM table1 a \n" +
//              "JOIN table2 b ON a.sender_id = b.user_id \n" +
//              "JOIN table3 c ON a.channel_id = c.channel_id \n" +
//              "JOIN table4 d ON c.store_id = d.store_id \n" +
//              "WHERE sender_id NOT IN \n" +
//              "  (SELECT user_id \n" +
//              "   FROM table5 \n" +
//              "   WHERE store_id IN ('agent_store:1', \n" +
//              "                                     'ask:1')) \n" +
//              "   AND to_timestamp(a.time_updated_server/1000)::date >= '2014-05-01' \n" +
//              "   GROUP BY 1,2,3,4 \n" +
//              "   HAVING sum(1) > 500 \n" +
//              "   ORDER BY 1 ASC");
//
//      selectStatement = (Select)statement;
//      tablesNamesFinder = new TablesNamesFinder();
//      tableList = tablesNamesFinder.getTableList(selectStatement);
//
//      tableList.forEach(n->System.out.println(n));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

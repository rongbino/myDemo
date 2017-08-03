package com.sogou.test;

import com.facebook.presto.sql.SqlFormatter;
import com.facebook.presto.sql.parser.SqlParser;
import com.facebook.presto.sql.tree.*;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by rongbin on 2017/4/19.
 */
public class PrestoParseTest {

  private static ArrayList<String> tableList = new ArrayList<>();
  private static List<QualifiedName> tbl = Lists.newArrayList();
  private static Set<String> alias = Sets.newHashSet();

  private final IdentityHashMap<Expression, QualifiedName> resolvedNameReferences = new IdentityHashMap<>();

  public static void main(String[] args) {
    try {
      com.facebook.presto.sql.parser.SqlParser sqlParser = new SqlParser();
//      com.facebook.presto.sql.tree.Query query = (com.facebook.presto.sql.tree.Query) sqlParser.createStatement("WITH\n" + "  t1 AS (SELECT udid FROM db1.dw_sign_orc where cdate=20170326),\n" + "  t2 AS (SELECT a1 FROM db2.orc_spec where cdate=20170328)\n" + "SELECT count(distinct t2.a1)\n" + "FROM t1 \n" + "JOIN t2 ON upper(t1.udid) = upper(t2.a1)");

      com.facebook.presto.sql.tree.Query query = (com.facebook.presto.sql.tree.Query) sqlParser.createStatement("select ptype,pv,uv,ip,click,clickuv,clickip,clickout,clickoutuv,\n" + "               round(click/pv,4) as ctr,\n" + "               round(pv/uv,4),\n" + "               round(click/uv,4),\n" + "               case when ptype='xiaohua2nd' then round(clickuv*100/uv,4) else round(clickuv/uv,4) end,\n" + "               round(clickout/uv,4),\n" + "               case when ptype='xiaohua2nd' then round(clickoutuv*100/uv,4) else round(clickoutuv/uv,4) end,'20170422',ctime\n" + "         from\n" + "               (select count(case when (ptype!='toutiao' and page!='%E6%90%9C%E7%8B%97%E5%A4%B4%E6%9D%A1' and user_action=1) or (ptype='toutiao' and user_action=1) then suid else null end) as pv,\n" + "                       count(distinct case when user_action=1 then suid else null end) as uv,\n" + "                       count(distinct case when user_action=1 then user_ip else null end) as ip,\n" + "                       count(case when user_action=2 then suid else null end) as click,\n" + "                       count(distinct case when user_action=2 then suid else null end) as clickuv,\n" + "\t\t\t\t\t   count(distinct case when user_action=2 then user_ip else null end) as clickip,\n" + "                       (count(case when ((ptype!='mini' and ptype!='mini2' and ptype!='mini3' and ptype!='mini4') and user_action=2 and url like '%http%' and !parse_url(decoder_url(url),'HOST') like '%sogou%') or ((ptype='mini' or ptype='mini2' or ptype='mini3' or ptype='mini4') and user_action=2 and url like '%http%' and !parse_url(decoder_url(url),'HOST') like '%123.sogou%') then suid end))clickout,\n" + "                       (count(distinct case when ((ptype!='mini' and ptype!='mini2' and ptype!='mini3' and ptype!='mini4') and user_action=2 and url like '%http%' and !parse_url(decoder_url(url),'HOST') like '%sogou%') or ((ptype='mini' or ptype='mini2' or ptype='mini3' or ptype='mini4') and user_action=2 and url like '%http%' and !parse_url(decoder_url(url),'HOST') like '%123.sogou%') then suid end))clickoutuv,ptype,ctime \n" + "from dh_sub_forall_5min where cdate=20170422 and ctimes='201704221415' and ctime REGEXP '^20\\\\d{10}$' group by ptype,ctime)\n");
//      com.facebook.presto.sql.tree.Query query = (com.facebook.presto.sql.tree.Query)sqlParser.createStatement("select * from t1");

//      com.facebook.presto.sql.tree.QuerySpecification queryBody = (com.facebook.presto.sql.tree.QuerySpecification)query.getQueryBody();
//
//      System.out.println("SQL: " + query.toString());
//      Optional<Relation> from = queryBody.getFrom();
      //queryBody.getChildren().forEach(n->System.out.println(n.toString()));
//      System.out.println("From = " + from.get());

      PrestoParseTest test = new PrestoParseTest();
      test.print(query);


//      com.facebook.presto.sql.tree.Query query2 = (com.facebook.presto.sql.tree.Query)sqlParser.createStatement("SELECT a.time_updated_server/1000, \n" +
//              "content, \n" +
//              "nick, \n" +
//              "name \n" +
//              "FROM db1.table1 a \n" +
//              "JOIN db2.table2 b ON a.sender_id = b.user_id \n" +
//              "JOIN db3.table3 c ON a.channel_id = c.channel_id \n" +
//              "JOIN db4.table4 d ON c.store_id = d.store_id \n" +
//              "WHERE sender_id NOT IN \n" +
//              "  (SELECT user_id \n" +
//              "   FROM table5) \n" +
////              "   WHERE store_id IN ('agent_store2:1', \n" +
////              "                                     'ask:1')) \n" +
////              "   AND to_timestamp(a.time_updated_server/1000)::date >= '2014-05-01' \n" +
//              "   GROUP BY 1,2,3,4 \n" +
//              "   HAVING sum(1) > 500 \n" +
//              "   ORDER BY 1 ASC");
//      System.out.println();
//      test.print(query2);

      System.out.println();
      System.out.println(tableList);
      System.out.println(tbl);
      System.out.println(alias);

      List<QualifiedName> result = Lists.newArrayList(Iterables.filter(tbl, new Predicate<QualifiedName>() {
        @Override
        public boolean apply(@Nullable QualifiedName qualifiedName) {
          if (alias.contains(qualifiedName.toString())) {
            return false;
          } else {
            return true;
          }
        }
      }));

      System.out.println("*************Final");
      System.out.println(result);

      System.out.println();
      String sql = SqlFormaterTest.formatSql(query, null);
      System.out.println("New formate SQL");
      System.out.println(sql);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void print(Node root) {

    AstVisitor<Void, Integer> printer = new DefaultTraversalVisitor<Void, Integer>() {
      @Override
      protected Void visitNode(Node node, Integer indentLevel) {
        System.out.println("node :" + node);
        return null;
//        throw new UnsupportedOperationException("not yet implemented: " + node);
      }

      @Override
      protected Void visitQuery(Query node, Integer indentLevel) {
        if (node.getWith().isPresent()) {
          With with = (With) node.getWith().get();
          print(indentLevel, "With");
          if (with.isRecursive()) {
            print(indentLevel, "Recursive ");
          }

          indentLevel++;
          Iterator<WithQuery> queries = with.getQueries().iterator();
          while (queries.hasNext()) {
            WithQuery query = queries.next();
            alias.add(query.getName());
            print(indentLevel, query.getName());

            final int tmp = indentLevel + 1;
            Optional<List<String>> ops = query.getColumnNames();
            if (ops.isPresent()) {
              // print the columns name
              ops.get().forEach(a -> print(tmp, a));
            }
            process(new TableSubquery(query.getQuery()), tmp);
          }

        }

        print(indentLevel, "Query ");

        indentLevel++;

        print(indentLevel, "QueryBody");
        process(node.getQueryBody(), indentLevel);
        if (node.getOrderBy().isPresent()) {
          print(indentLevel, "OrderBy");
          process(node.getOrderBy().get(), indentLevel + 1);
        }

        if (node.getLimit().isPresent()) {
          print(indentLevel, "Limit: " + node.getLimit().get());
        }

        return null;
      }

      @Override
      protected Void visitQuerySpecification(QuerySpecification node, Integer indentLevel) {
        print(indentLevel, "QuerySpecification ");

        indentLevel++;

        process(node.getSelect(), indentLevel);

        if (node.getFrom().isPresent()) {
          print(indentLevel, "From");
          process(node.getFrom().get(), indentLevel + 1);
        }

        if (node.getWhere().isPresent()) {
          print(indentLevel, "Where");
          process(node.getWhere().get(), indentLevel + 1);
        }

        if (node.getGroupBy().isPresent()) {
          String distinct = "";
          if (node.getGroupBy().get().isDistinct()) {
            distinct = "[DISTINCT]";
          }
          print(indentLevel, "GroupBy" + distinct);
          for (GroupingElement groupingElement : node.getGroupBy().get().getGroupingElements()) {
            print(indentLevel, "SimpleGroupBy");
            if (groupingElement instanceof SimpleGroupBy) {
              for (Expression column : ((SimpleGroupBy) groupingElement).getColumnExpressions()) {
                process(column, indentLevel + 1);
              }
            } else if (groupingElement instanceof GroupingSets) {
              print(indentLevel + 1, "GroupingSets");
              for (Set<Expression> column : groupingElement.enumerateGroupingSets()) {
                print(indentLevel + 2, "GroupingSet[");
                for (Expression expression : column) {
                  process(expression, indentLevel + 3);
                }
                print(indentLevel + 2, "]");
              }
            } else if (groupingElement instanceof Cube) {
              print(indentLevel + 1, "Cube");
              for (QualifiedName column : ((Cube) groupingElement).getColumns()) {
                print(indentLevel + 1, column.toString());
              }
            } else if (groupingElement instanceof Rollup) {
              print(indentLevel + 1, "Rollup");
              for (QualifiedName column : ((Rollup) groupingElement).getColumns()) {
                print(indentLevel + 1, column.toString());
              }
            }
          }
        }

        if (node.getHaving().isPresent()) {
          print(indentLevel, "Having");
          process(node.getHaving().get(), indentLevel + 1);
        }

        if (node.getOrderBy().isPresent()) {
          print(indentLevel, "OrderBy");
          process(node.getOrderBy().get(), indentLevel + 1);
        }

        if (node.getLimit().isPresent()) {
          print(indentLevel, "Limit: " + node.getLimit().get());
        }

        return null;
      }

      protected Void visitOrderBy(OrderBy node, Integer indentLevel) {
        for (SortItem sortItem : node.getSortItems()) {
          process(sortItem, indentLevel);
        }

        return null;
      }

      @Override
      protected Void visitSelect(Select node, Integer indentLevel) {
        String distinct = "";
        if (node.isDistinct()) {
          distinct = "[DISTINCT]";
        }
        print(indentLevel, "Select" + distinct);

        super.visitSelect(node, indentLevel + 1); // visit children

        return null;
      }

      @Override
      protected Void visitAllColumns(AllColumns node, Integer indent) {
        if (node.getPrefix().isPresent()) {
          print(indent, node.getPrefix() + ".*");
        } else {
          print(indent, "*");
        }

        return null;
      }

      @Override
      protected Void visitSingleColumn(SingleColumn node, Integer indent) {
        if (node.getAlias().isPresent()) {
          print(indent, "Alias: " + node.getAlias().get());
        }

        super.visitSingleColumn(node, indent + 1); // visit children

        return null;
      }

      @Override
      protected Void visitComparisonExpression(ComparisonExpression node, Integer indentLevel) {
        print(indentLevel, node.getType().toString());

        super.visitComparisonExpression(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitArithmeticBinary(ArithmeticBinaryExpression node, Integer indentLevel) {
        print(indentLevel, node.getType().toString());

        super.visitArithmeticBinary(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitLogicalBinaryExpression(LogicalBinaryExpression node, Integer indentLevel) {
        print(indentLevel, node.getType().toString());

        super.visitLogicalBinaryExpression(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitStringLiteral(StringLiteral node, Integer indentLevel) {
        print(indentLevel, "String[" + node.getValue() + "]");
        return null;
      }

      @Override
      protected Void visitBinaryLiteral(BinaryLiteral node, Integer indentLevel) {
        print(indentLevel, "Binary[" + node.toHexString() + "]");
        return null;
      }

      @Override
      protected Void visitBooleanLiteral(BooleanLiteral node, Integer indentLevel) {
        print(indentLevel, "Boolean[" + node.getValue() + "]");
        return null;
      }

      @Override
      protected Void visitLongLiteral(LongLiteral node, Integer indentLevel) {
        print(indentLevel, "Long[" + node.getValue() + "]");
        return null;
      }

      @Override
      protected Void visitLikePredicate(LikePredicate node, Integer indentLevel) {
        print(indentLevel, "LIKE");

        super.visitLikePredicate(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitIdentifier(Identifier node, Integer indentLevel) {
        QualifiedName resolved = resolvedNameReferences.get(node);
        String resolvedName = "";
        if (resolved != null) {
          resolvedName = "=>" + resolved.toString();
        }
        print(indentLevel, "Identifier[" + node.getName() + resolvedName + "]");
        return null;
      }

      @Override
      protected Void visitDereferenceExpression(DereferenceExpression node, Integer indentLevel) {
        QualifiedName resolved = resolvedNameReferences.get(node);
        String resolvedName = "";
        if (resolved != null) {
          resolvedName = "=>" + resolved.toString();
        }
        print(indentLevel, "DereferenceExpression[" + node + resolvedName + "]");
        return null;
      }

      @Override
      protected Void visitFunctionCall(FunctionCall node, Integer indentLevel) {
        String name = Joiner.on('.').join(node.getName().getParts());
        print(indentLevel, "FunctionCall[" + name + "]");

        super.visitFunctionCall(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitTable(Table node, Integer indentLevel) {
        String name = Joiner.on('.').join(node.getName().getParts());
        print(indentLevel, "Table[" + name + "]");

        tbl.add(node.getName());
        tableList.add(name);
        return null;
      }

      @Override
      protected Void visitValues(Values node, Integer indentLevel) {
        print(indentLevel, "Values");

        super.visitValues(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitRow(Row node, Integer indentLevel) {
        print(indentLevel, "Row");

        super.visitRow(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitAliasedRelation(AliasedRelation node, Integer indentLevel) {
        print(indentLevel, "Alias[" + node.getAlias() + "]");

        super.visitAliasedRelation(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitSampledRelation(SampledRelation node, Integer indentLevel) {
        print(indentLevel, "TABLESAMPLE[" + node.getType() + " (" + node.getSamplePercentage() + ")]");

        super.visitSampledRelation(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitTableSubquery(TableSubquery node, Integer indentLevel) {
        print(indentLevel, "SubQuery");

        super.visitTableSubquery(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitInPredicate(InPredicate node, Integer indentLevel) {
        print(indentLevel, "IN");

        super.visitInPredicate(node, indentLevel + 1);

        return null;
      }

      @Override
      protected Void visitSubqueryExpression(SubqueryExpression node, Integer indentLevel) {
        print(indentLevel, "SubQuery");

        super.visitSubqueryExpression(node, indentLevel + 1);

        return null;
      }
    };

    printer.process(root, 0);
  }

  private void print(Integer indentLevel, String value) {
    System.out.println(Strings.repeat(" ", indentLevel) + value);
  }
}

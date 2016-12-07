package com.pgjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by zhengchao on 2016/12/1.
 */
public class Demo {
    private static String[] statementSeq = {
            "truncate persons",
            "insert into persons (id, name) values (5, 'alex5')",
            "insert into persons (id, name) values (6, 'alex6')",
            "select * from persons;"
    };
    private static String[] extendedSeqs = {
            "prepare foo ($1, $2) as insert into persons (id, name) values ($1, $2);",
            "foo(5, 'alex5');",
            "foo(6, 'alex6');"
    };

    private static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private static Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "root");
        props.setProperty("ssl", "false");
    }

    public static void main(String[] args) throws SQLException {
//        execute(statementSeq, "simple");
        executeExtendedQuery();
    }

    private static void execute(String[] queries, String protocol) throws SQLException {
        props.setProperty("preferQueryMode", protocol);

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            for (int i = 0; i < queries.length; ++i) {
                st.execute(queries[i]);
                ResultSet rs = st.getResultSet();

                while (rs != null && rs.next()) {
                    System.out.print("Column 1 returned: ");
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }

                if (rs!=null)rs.close();
            }
            st.close();
        } finally {
            conn.close();
        }
    }

    private static void executeExtendedQuery() throws SQLException {
        props.setProperty("preferQueryMode", "extended");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
            PreparedStatement pstmt = conn.prepareStatement("insert into persons (id, name) values (?, ?);");

            pstmt.setInt(1, 5);
            pstmt.setString(2, "alex5");
            pstmt.addBatch();

            pstmt.setInt(1, 6);
            pstmt.setString(2, "alex6");
            pstmt.addBatch();

            pstmt.setInt(1, 7);
            pstmt.setString(2, "holly1");
            pstmt.addBatch();

            pstmt.executeBatch();



        } finally {
            conn.close();
        }
    }
}

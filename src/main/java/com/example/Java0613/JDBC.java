package com.example.Java0613;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC {
  public static void main(String[] args) {
    // 1. 設定連線屬性
    String DBname = "visco_ased";
    String username = "javademo";
    String password = "root";
    // 2. 設定連線屬性
    Properties prop = new Properties();
    prop.setProperty("DBname", "visco_ased");
    prop.setProperty("username", "javademo");
    prop.setProperty("password", "root");
    System.out.println(prop.getProperty("DBname"));
    System.out.println(prop.getProperty("username"));
    System.out.println(prop.getProperty("password"));

    String statString = "select * from pg_tables";

    try (Connection conn_pg = JDBC.conn_postgresql(DBname, username, password);
        Statement stmt = conn_pg.createStatement();
        ResultSet rs = stmt.executeQuery(statString);) {
      while (rs.next()) {
        System.out.println(rs.getString("tablename")); //getXXXX("欄位名稱")
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
    System.out.println("______________________END______________________");

  }

  public static Connection conn_postgresql(String DBname, String username, String password) throws SQLException, ClassNotFoundException {
    // * JDBC 4,0 後可以不配置驅動
    // * 因為 JDBC 4,0 後只要 MATE-INF > service > java.sql.driver 的結構內容
    // * JDBC 4,0 後可以讓 Java 默認去 MATE-INF > service > java.sql.driver 的結構內容去自動建立 driver 實體
    Class.forName("org.postgresql.Driver");
    // * ===========================================================================================
    String url = "jdbc:postgresql://localhost:5432/" + DBname;
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

}

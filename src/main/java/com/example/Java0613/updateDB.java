package com.example.Java0613;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class updateDB {
  public static void main(String[] args) {
    // * 增刪修範例
    String insertSQL = "insert into example(name, salary, dept_id) values(?, ?, ?)";
    String updateSQL = "update example salary=? where id=?";
    String deleteSQL = "delete from example where id=?";
    String DBname = "visco_ased";
    String username = "javademo";
    String password = "root";
    // * PreparedStatement 可防止使用者自行帶入查詢語法或SQL注入攻擊
    // * 範例不可執行
    try (Connection conn = JDBC.conn_postgresql(DBname, username, password);
        PreparedStatement stmt = conn.prepareStatement("");) {
          System.exit(0);
          // * 對應到問號上
          stmt.setString(1, "Nick");
          stmt.setInt(2, 670000);
          stmt.setInt(3, 3);
          int rowCount = stmt.executeUpdate();
          System.out.printf("影響比數 %d\n", rowCount);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

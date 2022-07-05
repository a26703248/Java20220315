package com.example.Java0607;

import java.io.File;

public class CreateFolder {
  public static void main(String[] args) {
    // File 可以為資料夾目錄或檔案
    // 因為是 Maven 專案所以要從 src 開始
    String path = "java0315/src/main/java/com/example/Java0607/";
    String folderName = "data";
    File file = new File(path + folderName);
    System.out.println(file.exists());
    if(!file.exists()){
      file.mkdir();
      System.out.println("建立成功");
    }else{
      System.out.println("已存在");
    }
  }
}

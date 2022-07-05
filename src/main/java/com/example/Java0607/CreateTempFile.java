package com.example.Java0607;

import java.io.File;
import java.io.IOException;

public class CreateTempFile {
  public static void main(String[] args) throws IOException {
    String path = "./src/main/java/com/example/Java0607/data";
    File folder = new File(path);
    if(folder.isDirectory()){
      File tempFile = File.createTempFile("temp", ".txt", folder);
      System.out.println(tempFile + "建立成功");
      // 呼叫執行檔
      // Runtime.getRuntime().exec("./src/main/java/com/example/Java0607/chrome tw.yahoo.com");
    }
  }
}

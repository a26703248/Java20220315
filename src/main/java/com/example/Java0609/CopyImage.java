package com.example.Java0609;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyImage {
  public static void main(String[] args) {
    String source = "./src/main/java/com/example/Java0609/F-18.jpg";
    String dest = "./src/main/java/com/example/Java0609/backup/F-18.jpg";
    try (FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);) {
          System.out.printf("檔案大小: %d bytes\n", fis.available());
          byte[] buffer = new byte[1];
          while (fis.read(buffer) != -1){
            fos.write(buffer);
          }
          System.out.println("複製完畢");
    } catch (Exception e) {
    }
  }
}

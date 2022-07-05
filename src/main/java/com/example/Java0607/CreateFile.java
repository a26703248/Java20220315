package com.example.Java0607;

import java.io.File;
import java.io.IOException;

public class CreateFile {
  public static void main(String[] args) {
    String path = "./src/main/java/com/example/Java0607";
    String folderName = "/data";
    String fleName = "/new.txt";

    File folder = new File(path + folderName);
    if(!folder.exists()){
      folder.mkdir();
      System.out.println("資料夾建立成功");
    }
    File file = new File(path + folderName + fleName);
    if(!file.exists()){
      try {
        boolean result = file.createNewFile();
        if(result){
          System.out.println("檔案建立成功");
        }else{
          System.out.println("檔案建立失敗");
        }
      } catch (IOException e) {
      }
    }

  }
}

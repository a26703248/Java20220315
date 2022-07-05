package com.example.Java0607;

import java.io.FileReader;

public class FileReaderDemo {
  public static void main(String[] args) {
    try(FileReader fr = new FileReader("./src/main/java/com/example/Java0607/data/new.txt");){
      // 此方法會一直對硬碟做讀取非常無效率
      char[] buffer = new char[1];
      // while(fr.read(buffer) != -1){
      //   System.out.print(buffer[0]);
      // }

      StringBuffer sb = new StringBuffer();
      while(fr.read(buffer) != -1){
        sb.append(buffer);
      }
      System.out.print(sb);
    }catch(Exception e){

    }
  }
}

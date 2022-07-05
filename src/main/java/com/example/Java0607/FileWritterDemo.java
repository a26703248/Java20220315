package com.example.Java0607;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritterDemo {
  public static void main(String[] args) {
    FileWriter fw = null;
    try {
      fw = new FileWriter("./src/main/java/com/example/Java0607/data/new.txt");
      fw.append("Hello Java ");
      fw.append("\n");
      fw.append("\tHello Web 網頁");
      System.out.println("寫入完畢");
    } catch (IOException e) {
      System.out.println(e);
    }finally{
      if(fw != null){
        try {
          fw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }
    }

  }
}

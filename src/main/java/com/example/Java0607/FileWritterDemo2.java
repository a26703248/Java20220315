package com.example.Java0607;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritterDemo2 {
  public static void main(String[] args) {
    // FileWriter(targetPath=>java.lang.String or java.io.File, charset=>java.nio.charset.Charset, append=>boolean)
    try(FileWriter fw = new FileWriter("./src/main/java/com/example/Java0607/data/new.txt", true);){
      fw.append("Hello Java ");
      fw.append("\n");
      fw.append("\tHello Web 網頁");
      System.out.println("寫入完畢");
    } catch (IOException e) {
      System.out.println(e);
    }

  }
}

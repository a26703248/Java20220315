package com.example.Java0609;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
  // 數據持久化(讀取)
  public static void main(String[] args) {
    String path = "src/main/java/com/example/Java0609/data/data.dat";
    try (FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);) {
        oos.writeObject(new Person("Nick", 27));
        oos.flush();
        System.out.println("寫入成功");
    } catch (Exception e) {
      System.out.println("Error" + e);
    }
  }
}

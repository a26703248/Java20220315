package com.example.Java0609;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
  // 數據持久化(寫入)
  public static void main(String[] args) {
    String path = "src/main/java/com/example/Java0609/data/data.dat";
    try (FileInputStream fis = new FileInputStream(path);
      ObjectInputStream ois = new ObjectInputStream(fis);) {
        Object obj = ois.readObject();
        System.out.println(obj);
        Person p1 = (Person)obj;
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    } catch (Exception e) {
      System.out.println("Error" + e);
    }
  }
}

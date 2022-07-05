package com.example.Java0609;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReaderDemo {
  public static void main(String[] args) {
    /*
     * BufferedReader(FileWriter物件, 暫存最大空間(bytes))
     * disk(硬碟) ---> FileReader(讀取) ---> BufferedReader(資料緩衝暫存區) ---> memory (記憶體)
     */
    String path = "./src/main/java/com/example/Java0607/data/new.txt";
    try (FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);) {
      String data = null;
      while ((data = br.readLine()) != null) {
        System.out.println(data);
      }
    } catch (Exception e) {
    }
  }
}

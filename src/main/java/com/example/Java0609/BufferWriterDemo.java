package com.example.Java0609;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferWriterDemo {
  public static void main(String[] args) {
    /*
     * BufferedWriter(FileWriter物件, 暫存最大空間(bytes))
     * memory (記憶體) ---> FileWriter(讀取) ---> BufferedWriter(資料緩衝暫存區) ---> disk(硬碟)
     */
    String dest = "./src/main/java/com/example/Java0609/backup/new.txt";
    String[] rows = { "Java", "11", "SE" };
    try (FileWriter fw = new FileWriter(dest);
        BufferedWriter bw = new BufferedWriter(fw, 8 * 1024);) {
      for (String row : rows) {
        bw.write(row);
        bw.newLine();
      }
    } catch (Exception e) {
    }

  }
}

package com.example.Java0609;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileContent {
  public static void main(String[] args) throws Exception {
    Path path = Paths.get("src/main/java/com/example/Java0609/backup/new.txt");
    // * 讀檔
    // * 1. BufferedReader and FileReader
    try (BufferedReader bf = new BufferedReader(new FileReader(path.toString()));) {
      bf.lines().forEach(System.out::println);
    } catch (Exception e) {
    }

    // * 2. Files.newBufferedReader
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      reader.lines().forEach(System.out::println);
    } catch (Exception e) {
    }

    // * 3. Files.readAllLines
    List<String> content = Files.readAllLines(path);
    content.stream().forEach(System.out::println);

    // * 4. Files.lines
    Files.lines(path).forEach(System.out::println);
  }
}

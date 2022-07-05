package com.example.Java0609;

import java.nio.file.Paths;
import java.nio.file.Path;

public class PathDemo {
  public static void main(String[] args) {
    // 絕對路徑
    Path path = Paths.get("/home/a0909007892/java/java0315/src/main/java/com/example/Java0609/PathDemo.java");
    // 專案路徑
    // Path path = Paths.get("/src/main/java/com/example/Java0609/PathDemo.java");
    System.out.println("getFileName:" + path.getFileName());
    System.out.println("getParent:" + path.getParent());
    System.out.println("getRoot:" + path.getRoot());
    System.out.println("getNameCount:" + path.getNameCount());
    System.out.println("subpath(0, 3):" + path.subpath(0, 3));
    System.out.println("isAbsolute:" + path.isAbsolute());
    System.out.println("toAbsolutePath:" + path.toAbsolutePath());
    System.out.println("toUri:" + path.toUri());
  }
}

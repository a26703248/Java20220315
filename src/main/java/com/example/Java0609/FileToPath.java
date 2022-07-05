package com.example.Java0609;

import java.io.File;
import java.nio.file.Path;

public class FileToPath {
  public static void main(String[] args) {
    File file = new File("src/main/java/com/example/Java0609/backup/new.txt");
    // File -> Files
    Path newFile = file.toPath();

  }
}

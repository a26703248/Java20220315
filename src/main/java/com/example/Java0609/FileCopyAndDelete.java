
package com.example.Java0609;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyAndDelete {
  public static void main(String[] args) throws Exception {
    Path source = Paths.get("src/main/java/com/example/Java0609/backup/network_image.jpg");
    Path dest = Paths.get("src/main/java/com/example/Java0609/foo/network_image.jpg");

    // Files.copy(source, dest);
    Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
    System.out.println("copy down");

    Files.delete(source);
    System.out.println("delete down");


    // Files.move(dest, source, StandardCopyOption.REPLACE_EXISTING);
    // System.out.println("move down");
  }
}

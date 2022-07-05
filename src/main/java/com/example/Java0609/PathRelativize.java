
package com.example.Java0609;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathRelativize {
  public static void main(String[] args) {
    // 移動
    Path p1 = Paths.get("home");
    Path p2 = Paths.get("home/foo/bar");

    Path p1_to_p2 = p1.relativize(p2);
    System.out.println(p1_to_p2);

    p1_to_p2 = p2.relativize(p1);
    System.out.println(p1_to_p2);
  }
}

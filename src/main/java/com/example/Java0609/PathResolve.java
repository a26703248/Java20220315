package com.example.Java0609;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolve {
  public static void main(String[] args) {

    Path p1 = Paths.get("home");
    Path p2 = Paths.get("home/foo/bar");

    p1.resolve(p2);
    System.out.println(p1);

    Path p3 = Paths.get("/src");
    p2.resolve(p3);
    System.out.println(p2);
  }
}

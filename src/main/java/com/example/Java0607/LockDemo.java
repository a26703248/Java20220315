package com.example.Java0607;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.Java0607.Lucky;

public class LockDemo {
  public static void main(String[] args) {
    // ExecutorService service = Executors.newCachedThreadPool();
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.execute(new Lucky("John"));
    service.execute(new Lucky("Mary"));
    service.shutdown();
  }
}

package com.example.Java0607;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo extends Thread{
  private AtomicInteger num = new AtomicInteger();

  public void run(){
    num.incrementAndGet();
    System.out.println(num.get());
  }

  public static void main(String[] args) {
    AtomicIntegerDemo a1 = new AtomicIntegerDemo();
    a1.start();
  }
}

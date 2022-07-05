package com.example.Java0531;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Car extends Thread{
  // 循環屏障
  private CyclicBarrier cb;

  public Car(CyclicBarrier cb) {
    this.cb = cb;
  }

  public void run(){
    String tname = Thread.currentThread().getName();
    System.out.printf("%s 出發了\n", tname);
    try {
      Thread.sleep(new Random().nextInt(5000));
      System.out.printf("%s 到台中了\n", tname);
      cb.await(); // 等待其他執行緒(也可限定等多久)
    } catch (Exception e) {
    }
    System.out.printf("%s 各自回家\n", tname);
  }
}

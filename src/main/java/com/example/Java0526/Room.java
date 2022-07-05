package com.example.Java0526;

import java.util.Random;

public class Room{
  Account account;

  public synchronized void write() throws InterruptedException{
    Random random = new Random();
    String name = Thread.currentThread().getName();
    System.out.printf("%s 填寫病例\n", name);
    Thread.sleep(random.nextInt(1000));
    System.out.printf("%s 填寫病例完畢\n", name);
  }

  public void watch() throws InterruptedException{
    Random random = new Random();
    // 可以針對需要的片段做同步
    // 可以鎖定其他物件
    // synchronized (account){
    synchronized (this){
      String name = Thread.currentThread().getName();
      System.out.printf("%s 進來看診\n", name);
      Thread.sleep(random.nextInt(1000));
      System.out.printf("醫生問 %s 得病況\n", name);
      Thread.sleep(random.nextInt(1000));
      System.out.printf("%s 說明自己的病況\n", name);
      Thread.sleep(random.nextInt(1000));
      System.out.printf("醫生對 %s 進行看診\n", name);
      Thread.sleep(random.nextInt(1000));
      System.out.printf("%s 離開診間\n", name);
    }
  }

}

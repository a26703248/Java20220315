package com.example.Java0531;

import java.util.Date;
import java.util.Random;

public class Lucky implements Runnable{

  @Override
  public void run() {
    System.out.print("Begin=" + new Date() + "------------>");
    Random random = new Random();
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
    }
    System.out.print(random.nextInt(100));
    System.out.println("End=" + new Date());
  }

}

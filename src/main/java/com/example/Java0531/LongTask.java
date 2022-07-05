package com.example.Java0531;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LongTask implements Runnable{

  @Override
  public void run() {
    System.out.println("長任務開始");
    try{
      TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 2);
    }catch(Exception e){
    }
    System.out.println("長任務結束");
  }
}

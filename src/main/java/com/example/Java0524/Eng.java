package com.example.Java0524;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Eng{
  public static void main(String[] args) {
    FutureTask<Integer> task = new FutureTask<Integer>(new Father());
    FutureTask<Integer> task2 = new FutureTask<Integer>(new Father());
    new Thread(task).start();
    new Thread(task2).start();
    try {
      int money = task.get();
      System.out.println(money);
      int money2 = task2.get();
    } catch (Exception e) {
    }
  }
}

class Father  implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    return 50;
  }
}

package com.example.Java0531;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor{

  @Override
  public void execute(Runnable command) {
    System.out.println(command.getClass().getSimpleName());
    Thread t = new Thread(command);
    t.start();
  }
}

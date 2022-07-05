package com.example.Java0531;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyNumber implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    Random random = new Random();
    return random.nextInt(1000);
  }

}

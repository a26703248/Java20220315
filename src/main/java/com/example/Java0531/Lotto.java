package com.example.Java0531;

import java.util.Random;

public class Lotto implements Runnable{

  @Override
  public void run() {
    Random lotto = new Random();
    System.out.println(lotto.nextInt(100));
  }

}

package com.example.Java0531;

import java.util.concurrent.CyclicBarrier;

public class CarCyclicBarrier {
  // 循環屏障
  public static void main(String[] args) {
    int parties = 2;
    Runnable lunch = () -> System.out.println(Thread.currentThread().getName() + "吃午飯");
    /*
    CyclicBarrier(等待數量, 等待倒完後做什麼(最後一個去完成) )
    */
    CyclicBarrier cb = new CyclicBarrier(parties, lunch);
    new Car(cb).start();
    new Car(cb).start();
    new Car(cb).start();
    new Car(cb).start();
  }
}

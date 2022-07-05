package com.example.Java0526;

public class Cookies {
  private boolean empty = true;

  public synchronized void put(int i){
    // 持續偵測盤子是否為空
    while(!empty){
      try {
        wait();
      } catch (InterruptedException e) {
        return;
      }
    }
    System.out.printf("主人放第 %d 塊餅乾\n", i);
    // 放好餅乾盤子不為空
    empty = false;
    // 通知小狗
    notifyAll();
  }

  public synchronized void eat(int i){
    // 持續偵測盤子是否為空
    while(empty){
      try {
        wait();
      } catch (InterruptedException e) {
        return;
      }
    }
    System.out.printf("小狗吃第 %d 塊餅乾\n", i);
    // 吃完了
    empty = true;
    // 通知主人
    notifyAll();
  }
}

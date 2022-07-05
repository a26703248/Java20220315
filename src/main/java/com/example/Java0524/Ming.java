package com.example.Java0524;

public class Ming extends Thread{
  int money = 100;
  private Box box = (money) -> {
    System.out.println("小明有 $" + (this.money + money));
  };

  @Override
  public void run () {
    System.out.println("媽媽在box裡面放50$");
    box.putMoney(50);
  }

  public static void main(String[] args) {
    // 指定裝箱法
    System.out.println("小明要拿零錢");
    Ming ming = new Ming();
    ming.start();
  }
}

interface Box {
  void putMoney (int money);
}

class Mather extends Thread {
  private Box box;

  public Mather(Box box){
    System.out.println("媽媽拿到box");
    this.box = box;
  }

  public void run () {
    System.out.println("媽媽拿到box");
    box.putMoney(50);
  }

}

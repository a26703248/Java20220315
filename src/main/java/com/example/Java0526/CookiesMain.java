package com.example.Java0526;

public class CookiesMain {
  public static void main(String[] args) {
    // 餅乾資源
    Cookies cookies = new Cookies();
    // 工作
    Put put = new Put(cookies);
    Eat eat = new Eat(cookies);
    // 建立執行續
    Thread master = new Thread(put);
    Thread dog = new Thread(eat);
    // 執行
    master.start();
    dog.start();
  }
}

package com.example.Java0526;

public class ATM {
  public static void main(String[] args) {
    Account a1 = new Account(10000);
    Runnable w1 = new Withdraw(a1, 5000);
    Runnable w2 = new Withdraw(a1, 4000);
    Runnable w3 = new Withdraw(a1, 3000);

    Thread t1 = new Thread(w1, "小明");
    Thread t2 = new Thread(w2, "小英");
    Thread t3 = new Thread(w3, "小華");

    t1.start();
    t2.start();
    t3.start();

  }
}

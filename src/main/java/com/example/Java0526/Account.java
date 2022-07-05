package com.example.Java0526;

public class Account {
  private int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  private synchronized void setBalance(int balance){
    this.balance = balance;
  }

  public synchronized void withdraw(int amount) {
    String name = Thread.currentThread().getName();
    System.out.printf("%s 進來提款 $%,d\n", name, amount);

    for(int i=0;i < 99999999;i++);
    if(this.balance >= amount){
      System.out.printf("%s 開始提款 $%,d\n", name, amount);
      System.out.printf("%s 提款 $%,d 成功\n", name, amount);
      setBalance(this.balance -= amount);
    }else{
      System.out.printf("%s 餘額不足\n", name);
      System.out.printf("%s 提款 $%,d 失敗\n", name, amount);
    }
    int last_balance = getBalance();
    System.out.printf("目前帳戶餘額 $%,d\n",last_balance);
  }

}

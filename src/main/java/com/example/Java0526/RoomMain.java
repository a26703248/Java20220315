package com.example.Java0526;

public class RoomMain {
  public static void main(String[] args) {
    Room r1 = new Room();
    Person p1 = new Person(r1, "小明");
    Person p2 = new Person(r1, "小華");
    Person p3 = new Person(r1, "小英");
    Writer w1 = new Writer(r1, "John");
    Writer w2 = new Writer(r1, "Marry");
    Writer w3 = new Writer(r1, "Helen");
    // 去看診
    p1.start();
    p2.start();
    p3.start();
    // 寫資料
    w1.start();
    w2.start();
    w3.start();
  }
}

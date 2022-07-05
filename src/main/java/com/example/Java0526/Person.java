package com.example.Java0526;

public class Person extends Thread{
  public Room room;
  public Person(Room room, String name){
    this.room = room;
    setName(name);
  }

  @Override
  public void run() {
    try {
      this.room.watch();
    } catch (Exception e) {
    }

  }

}

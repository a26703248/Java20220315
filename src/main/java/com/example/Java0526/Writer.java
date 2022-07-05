package com.example.Java0526;


public class Writer extends Thread{

  public Room room;
  public Writer(Room room, String name){
    this.room = room;
    setName(name);
  }
  public void run(){
    try {
      this.room.write();
    } catch (Exception e) {
    }
  }

}

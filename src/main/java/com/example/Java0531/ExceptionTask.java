package com.example.Java0531;

public class ExceptionTask implements Runnable{

  @Override
  public void run() throws RuntimeException{
    System.out.println("錯誤任務");
    throw new RuntimeException("發生錯誤");
  }

}

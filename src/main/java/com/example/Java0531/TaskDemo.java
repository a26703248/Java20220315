package com.example.Java0531;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskDemo {
  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newCachedThreadPool();
    service.submit(new LongTask());
    service.submit(new ShortTask());
    service.submit(new LongTask());
    service.submit(new ExceptionTask());
    service.submit(new LongTask());
    service.submit(new ShortTask());
    service.submit(new ShortTask());

    service.shutdown();
    System.out.println("平滑關閉");
    // 因為還未關閉所以用 while 迴圈防止資料再未完成前繼續下去
    while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
      System.out.println("service 尚未關閉");
    }
    System.out.println("service 已關閉");
  }
}

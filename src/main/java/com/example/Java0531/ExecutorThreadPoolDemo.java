package com.example.Java0531;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorThreadPoolDemo {
  public static void main(String[] args) throws Exception{
    // ExecutorService service = Executors.newCachedThreadPool();
    ExecutorService service = Executors.newFixedThreadPool(2);

    service.submit(new Lotto());
    service.submit(new Lotto());
    service.submit(new Lotto());
    System.out.println("Thread count:" + Thread.activeCount());
    Thread.sleep(3000);
    service.submit(new Lotto());
    System.out.println("Thread count:" + Thread.activeCount());
    Thread.sleep(5000);
    Future future = service.submit(new Lotto());
    // 雖然實作不是 Callable 但不會有錯誤發生，會回傳 null
    System.out.println("Future:" + future.get());
    System.out.println("Thread count:" + Thread.activeCount());
    Thread.sleep(2000);
    Future future1 = service.submit(new MyNumber());
    System.out.println("Future:" + future1.get());

    service.shutdown();
  }
}

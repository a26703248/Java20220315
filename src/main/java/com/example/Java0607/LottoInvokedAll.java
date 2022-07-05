package com.example.Java0607;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LottoInvokedAll {
  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newCachedThreadPool();
    Collection<Callable<Integer>> list = new ArrayList<>();
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    System.out.println("開始搖獎");
    List<Future<Integer>> result = service.invokeAll(list);
    for (Future<Integer> future : result) {
      System.out.println("開出:" + future.get());
    }
    service.shutdown();
  }
}

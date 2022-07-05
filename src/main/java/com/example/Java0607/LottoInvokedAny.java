package com.example.Java0607;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LottoInvokedAny {
  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newCachedThreadPool();
    Collection<Callable<Integer>> list = new ArrayList<>();
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    list.add(new Lotto());
    System.out.println("開始搖獎");
    Integer num = service.invokeAny(list);
    System.out.println("最快開出:" + num);
    service.shutdown();
  }
}

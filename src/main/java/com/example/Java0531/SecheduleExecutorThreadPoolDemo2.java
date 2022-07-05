package com.example.Java0531;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SecheduleExecutorThreadPoolDemo2 {
  public static void main(String[] args) {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    /*

    service.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit.SECONDS)
    Runnable command = 工作
    long initialDelay = 初始延遲
    long period = 週期延遲
    TimeUnit.SECONDS = 單位
    */
    // scheduleWithFixedDelay = 固定延遲
    service.scheduleWithFixedDelay(new Lucky(), 2, 2, TimeUnit.SECONDS);
    // service.scheduleAtFixedRate(new Lucky(), 2, 2, TimeUnit.SECONDS);
  }
}

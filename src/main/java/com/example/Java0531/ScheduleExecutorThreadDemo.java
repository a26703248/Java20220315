package com.example.Java0531;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorThreadDemo {
  public static void main(String[] args) {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.schedule(new Lucky(), 2, TimeUnit.SECONDS);
    service.shutdown();
  }
}

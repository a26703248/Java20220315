package com.example.Java0602;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciMain {
  public static void main(String[] args) {
    int n = 45;
    // 傳統遞迴求解
    Fibonacci fibonacci = new Fibonacci();
    long startTime = System.currentTimeMillis();
    long result = fibonacci.fib(n);
    long endTime = System.currentTimeMillis();
    System.out.printf("傳統遞迴求解第 %d項 = %,d, 花費時間=%d ms\n", n, result, (endTime - startTime));

    // ForkJoin 遞迴求解
    FibonacciTask task = new FibonacciTask(n);
    ForkJoinPool pool = ForkJoinPool.commonPool();
    startTime = System.currentTimeMillis();
    result = pool.invoke(task);
    endTime = System.currentTimeMillis();
    System.out.printf("ForkJoin 遞迴求解第 %d項 = %,d, 花費時間=%d ms\n", n, result, (endTime - startTime));

    // java forloop 遞迴
    long num1 = 0;
    long num2 = 1;
    long sumOfPrevTwo = 0;
    startTime = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      sumOfPrevTwo = num1 + num2;
      num1 = num2;
      num2 = sumOfPrevTwo;
    }
    endTime = System.currentTimeMillis();
    System.out.printf("ForLoop 遞迴求解第 %d項 = %,d, 花費時間=%d ms\n", n, result, (endTime - startTime));
  }
}

class Fibonacci {
  public long fib(int n){
    if(n <= 1){
      return n;
    }
    return fib(n-1) + fib(n-2);
  }
}

class FibonacciTask extends RecursiveTask<Long>{
  private final int THRESHOLD = 30;
  private int n;


  public FibonacciTask(int n) {
    this.n = n;
  }

  @Override
  protected Long compute() {
    // 不超過門檻值時使用傳統方法
    if(n <= THRESHOLD){
      Fibonacci fibonacci = new Fibonacci();
      return fibonacci.fib(this.n);
    }
    // 拆分任務
    FibonacciTask subTask1 = new FibonacciTask(n - 1);
    FibonacciTask subTask2 = new FibonacciTask(n - 2);

    // 執行 Fork
    invokeAll(subTask1, subTask2);

    // 執行 Join
    long subResult1 = subTask1.join();
    long subResult2 = subTask2.join();
    long result = subResult1 + subResult2;
    return result;
  }

}

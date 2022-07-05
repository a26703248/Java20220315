package com.example.Java0602;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTaskMain {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int process = Runtime.getRuntime().availableProcessors();
    System.out.printf("CPU 可使用得內核數量:%d\n", process);
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis();
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    System.out.printf("ForkJoin 解法花費時間: %d 執行結果: %d\n", (endTime - startTime), sum);

    ForkJoinTask<Integer> task = new SumTask(array, 0, array.length);
    startTime = System.currentTimeMillis();
    // commonPool() 動態使用內核數量
    // ForkJoinPool pool = ForkJoinPool.commonPool();
    // new ForkJoinPool 可決定使用內核數量
    ForkJoinPool pool = new ForkJoinPool(process);
    System.out.printf("啟用前內核數量: %d\n", pool.getPoolSize());
    int result = pool.invoke(task);
    System.out.printf("啟用後內核數量: %d\n", pool.getPoolSize());
    System.out.println("total result:" + result);
    endTime = System.currentTimeMillis();
    System.out.printf("ForkJoin解法花費時間: %d 執行結果: %d\n", (endTime - startTime), result);
  }
}

class SumTask extends RecursiveTask<Integer> {
  // 門檻值
  private final int THRESHOLD = 3;
  // 任務數組
  private int[] array;
  // 起訖位置
  private int start, end;


  public SumTask(int[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    // 1. 判斷門檻值,若小於門檻值直接計算
    if((this.end - this.start) <= THRESHOLD){
      int sum = 0;
      for (int i = this.start; i < this.end; i++) {
        sum += array[i];
      }
      return sum;
    }
    // 2. 任務過大,一分為二
    int middle = (this.end + this.start)/2;
    // System.out.printf("start=%d, middle=%d, end=%d\n", start, middle, end);

    // 3. 分裂任務
    SumTask sumTask1 = new SumTask(array, start, middle);
    SumTask sumTask2 = new SumTask(array, middle, end);

    // 4. 運行任務
    invokeAll(sumTask1, sumTask2);
    // 上方API與下方相同
    // sumTask1.fork();
    // sumTask2.fork();

    // 5. 獲得任務結果
    int subTaskResult1 = sumTask1.join();
    int subTaskResult2 = sumTask2.join();
    int result = subTaskResult1 + subTaskResult2;
    // System.out.printf("result: %d + %d ===> %d\n", subTaskResult1, subTaskResult2, result);
    return result;
  }

}

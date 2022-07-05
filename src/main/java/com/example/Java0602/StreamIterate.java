package com.example.Java0602;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterate {
  public static void main(String[] args) {
    long startTime = 0;
    long endTime = 0;
    // Stream.iterate(1, n -> n * 2)
    //       .limit(10)
    //       .forEach(x -> System.out.println(x));

    // Stream.iterate(0, n -> n + 1)
    //       .limit(10)
    //       .filter(x -> x % 2 == 1)
    //       .forEach(x -> System.out.println(x));

    // Java 8 Stream Fibonacci
    // Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
    //       .limit(10)
    //       .forEach(x -> System.out.println(Arrays.toString(x)));

    // startTime = System.currentTimeMillis();
    // Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
    //       .limit(10)
    //       .mapToInt(n -> n[0])
    //       .forEach(x -> System.out.println(x));
    // endTime = System.currentTimeMillis();
    // System.out.printf("未平行 %d ms\n", (endTime - startTime));

    // startTime = System.currentTimeMillis();
    // Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
    //       .parallel()
    //       .limit(45)
    //       .mapToInt(n -> n[0])
    //       .forEach(x -> System.out.println(x));
    // endTime = System.currentTimeMillis();
    // System.out.printf("有平行 %d ms\n", (endTime - startTime));

    startTime = System.currentTimeMillis();
    List<Integer> list = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
          // .parallel()
          .limit(45)
          .mapToInt(n -> n[0]) // 因為集合不可以放 int Stream 資料(IntStream 不可轉為 int)
          .boxed() // 可以藉由 boxed() 轉換
          // .map(n -> n[0])
          .collect(Collectors.toList());
    endTime = System.currentTimeMillis();
    System.out.printf("結果: %s\n花費時間: %d ms\n", list.toString(), (endTime - startTime));
  }
}

package com.way.t2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 李晓君你不过是一个婊子!
 */
public class Demo6 {
    public static void main(String[] args) {
        //固定的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(10);

        ExecutorService threadPool = Executors.newCachedThreadPool();




        for (int i=0;i<100;i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        threadPool.shutdown();

    }
}

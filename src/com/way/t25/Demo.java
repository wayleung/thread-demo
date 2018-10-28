package com.way.t25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 18:47
 * @Description:
 */
public class Demo {
    public void method(Semaphore semaphore){
        //能同时被semaphore个线程访问
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" is run...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //10个内退出了几个  就会进入几个  但真正的只有10个  而ExecutorService是固定只有10个    区分ExecutorService线程池
        semaphore.release();
    }


    public static void main(String[] args) {
        ExecutorService threaPool = Executors.newFixedThreadPool(10);

        Demo demo  = new Demo();

        Semaphore semaphore  =  new Semaphore(10);
        //只有10个线程运行 其他处于等待状态


        while (true) {


//            threaPool.execute(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//
            new Thread(new Runnable() {
                @Override
                public void run() {
                   demo.method(semaphore);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

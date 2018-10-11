package com.way.t5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/11/2018 14:17
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        Singleton s1 =  Singleton.getInstance();
//        Singleton s2 =  Singleton.getInstance();
//        Singleton s3 =  Singleton.getInstance();
//        Singleton s4 =  Singleton.getInstance();
//
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);





//        SingletonLazy s1 =  SingletonLazy.getInstance();
//        SingletonLazy s2 =  SingletonLazy.getInstance();
//        SingletonLazy s3 =  SingletonLazy.getInstance();
//        SingletonLazy s4 =  SingletonLazy.getInstance();
//
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);





        //线程池方式
        ExecutorService threadpool = Executors.newFixedThreadPool(20);

        for (int i= 0 ;i<20;i++){
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" "+SingletonLazy.getInstance());
                }
            });
        }


        threadpool.shutdown();







    }
}

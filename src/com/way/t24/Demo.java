package com.way.t24;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 17:14
 * @Description:
 */
public class Demo {

    public void meeting(CyclicBarrier cyclicBarrier){
        System.out.println(Thread.currentThread().getName()+"到达会议室，等待开会");


        //只有达到10个才会继续执行


//        if(Thread.currentThread().getName().equals("Thread-1")){
//            throw  new RuntimeException();
//        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"发言");
    }

    public static void main(String[] args) {
        Demo demo =  new Demo();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("开始开会。。");
            }
        });

        for (int  i =0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(cyclicBarrier);
                }
            }).start();
        }
    }
}

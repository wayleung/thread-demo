package com.way.t21;/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 00:31
 * @Description:
 */

/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 00:31
 * @Description:
 */
public class Demo {

    public void a(Thread joinThread){
        System.out.println("方法a执行了");
        joinThread.start();
        //////假如注释这段就是 并行执行


        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /////////
        System.out.println("方法a执行完毕");
    }

    public void b( ){
        System.out.println("加塞线程开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕");
    }

    public static void main(String[] args) {
        Demo demo =  new Demo();
        Thread joinThread = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.b();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a(joinThread);
            }
        });

        t2.start();
    }
}

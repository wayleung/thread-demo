package com.way.t15;

/**
 * @Auther: Way Liang
 * @Date: 10/23/2018 23:55
 * @Description:
 */
public class Target2 implements Runnable {

    Demo4 demo;

    public Target2(Demo4 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.getSignal();
    }
}

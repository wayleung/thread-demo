package com.way.t15;

/**
 * @Auther: Way Liang
 * @Date: 10/23/2018 23:55
 * @Description:
 */
public class Target1 implements Runnable {

    Demo4 demo;

    public Target1(Demo4 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.setSignal();
    }
}

package com.way.t3;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/10/2018 14:47
 * @Description:
 */
public class Target implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"...");
        }
    }
}

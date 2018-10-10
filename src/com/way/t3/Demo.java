package com.way.t3;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/10/2018 14:44
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
       Thread t1 = new Thread(new Target());
       Thread t2 = new Thread(new Target());
       Thread t3 = new Thread(new Target());
       Thread t4 = new Thread(new Target());

       t1.setPriority(Thread.MAX_PRIORITY);
       t2.setPriority(Thread.MIN_PRIORITY);
//       t3.setPriority();
//       t4.setPriority();

        t1.start();
        t2.start();
    }
}

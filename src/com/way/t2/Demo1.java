package com.way.t2;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/9/2018 11:29
 * @Description:
 */
public class Demo1 extends Thread {

    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName()+"线程执行了。。。");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Demo1 d1 = new Demo1("first-thread");
        Demo1 d2 = new Demo1("second-thread");

        //守护线程 支持线程  即使线程没执行完毕 主线程执行完毕 也会跟着退出
//        d1.setDaemon(true);
//        d2.setDaemon(true);

        d1.start();
        d2.start();

        //d1.stop();   //不好 其实相当于让线程一直等待
        d1.interrupt();   //通过interrupted（）判断
    }
}

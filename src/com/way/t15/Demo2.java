package com.way.t15;

/**
 * @Auther: Way Liang
 * @Date: 10/22/2018 23:09
 * @Description:
 */
public class Demo2 {
    private volatile int signal;

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public static void main(String[] args) {
        Demo2 demo  = new Demo2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("修改状态的线程执行。。。");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.setSignal(1);
                System.out.println("状态值修改成功。。");
                notify();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                //等待signal为1开始执行 否则不能执行
//                if(demo.getSignal()==1){
//                    System.out.println("模拟代码运行");
//                }
                if (demo.getSignal()!=1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("模拟代码运行");

            }
        }).start();
    }
}

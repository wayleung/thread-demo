package com.way.t1;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/9/2018 10:37
 * @Description:
 */
public class NewThread implements Runnable {
    @Override
    public synchronized void run() {
        while (true){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的线程执行了");
        }

    }

    public static void main(String[] args) {
        NewThread n  = new NewThread();

        //初始化状态
        Thread thread = new Thread(n);//创建线程,并指定线程任务
        //就绪 ready to run
        thread.start();//启动线程

        while (true){
            synchronized (n) {
                System.out.println("主线程执行了");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }
        }
    }
}

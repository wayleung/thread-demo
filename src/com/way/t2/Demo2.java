package com.way.t2;

/**实现runnable接口
 * 作为线程任务存在
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/9/2018 13:58
 * @Description:
 */
public class Demo2 implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("thread is running..");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}

package com.way.t7;

/**volatile 常见场景
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/12/2018 11:43
 * @Description:
 */
public class Demo3 {

    private volatile boolean run = false;

    public static void main(String[] args) {
        Demo3 d =  new Demo3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =1;i<=10;i++) {
                    System.out.println("执行了第"+i+"次");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                d.run = true;
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!d.run){
                    //不执行 自选
                }
                System.out.println("线程执行了");
            }
        }).start();
    }
}

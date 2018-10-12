package com.way.t7;

/**保证可见性的前提
 * 多个线程拿到的是同一把锁 否则是保证不了的
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/12/2018 11:10
 * @Description:
 */
public class Demo {
    private int a = 1;

//    public int getA() {
    public synchronized int getA() {
        return a;
    }

//    public void setA(int a) {
    public synchronized void setA(int a) {

//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.a = a;
    }

    public static void main(String[] args) {
        Demo demo  = new Demo();




        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.setA(10);
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo.getA());
            }
        }).start();

        try {
            ////保证上面先执行。。。。
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终结果："+demo.getA());

    }
}

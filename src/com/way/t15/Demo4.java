package com.way.t15;

/**
 * @Auther: Way Liang
 * @Date: 10/23/2018 23:49
 * @Description:
 */
public class Demo4 {
    private volatile int signal;

//    public synchronized void set () {
//        signal = 1;
//        notifyAll(); // notify方法会随机叫醒一个处于wait状态的线程
//        // notifyAll叫醒所有的处于wait线程，争夺到时间片的线程只有一个
//        System.out.println("叫醒线程叫醒之后休眠开始...");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized int get () {
//        System.out.println(Thread.currentThread().getName() + " 方法执行了...");
//        if(signal != 1) {
//            try {
//                wait();
//                System.out.println("叫醒之后");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
//        return signal;
//    }

//    public int getSignal() {   //wait notify 必须放在synchronized同步块中 不然会报错
    public synchronized int getSignal() {
        System.out.println(Thread.currentThread().getName() + " 方法执行了...");
        if(this.signal!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
        return this.signal;
    }

//    public void setSignal() {   //wait notify 必须放在synchronized同步块中 不然会报错
    public synchronized void setSignal() {
        System.out.println(Thread.currentThread().getName() + " 方法执行了...");
        this.signal = 1;
        notifyAll();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
    }

    public static void main(String[] args) {
        Demo4 demo =  new Demo4();

        Target1 t1 =  new Target1(demo);

        Target2 t2 =  new Target2(demo);

        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t1).start();

    }
}

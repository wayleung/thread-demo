package com.way.t11;


/**实现可重入锁
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/18/2018 11:00
 * @Description:
 */
public class Demo {
    MyAQSLock lock =  new MyAQSLock();

    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo d  = new Demo();

        //如果mylock不是可重入锁的话 会无限期的等待 活跃性问题
        new Thread(()->d.a()).start();
    }
}

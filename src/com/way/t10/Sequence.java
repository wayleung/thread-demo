package com.way.t10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/16/2018 11:47
 * @Description:
 */
public class Sequence {

    private int value;

    MyLock lock =  new MyLock();

    public  int getNext(){
        /*这样是错的 因为lock每次进来都new 了一个对象
        Lock lock =  new ReentrantLock();
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;*/
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }





    public static void main(String[] args) {
        Sequence sequence = new Sequence();

//        单线程不会出问题 但多线程就会
//        while (true) {
//            System.out.println(sequence.getNext());
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();





    }
}

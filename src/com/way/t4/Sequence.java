package com.way.t4;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/10/2018 15:04
 * @Description:
 */
public class Sequence {

    private int value;

//    public int getNext(){
//        return value++;
//    }

    public synchronized int getNext(){
        return value++;
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
                        Thread.sleep(10);
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
                        Thread.sleep(10);
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
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}

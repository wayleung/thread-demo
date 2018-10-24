package com.way.t16;

/**
 * @Auther: Way Liang
 * @Date: 10/24/2018 11:29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();

        Producer producer = new Producer(factory);

        Consumer consumer = new Consumer(factory);


        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();


    }
}

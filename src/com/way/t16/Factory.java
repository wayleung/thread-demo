package com.way.t16;

public class Factory {
    public int count;


    public synchronized void produce() {
        while (this.count>=10){
            try {
                System.out.println("库存已满 生产者等待。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("生产者生产中。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count++;
        System.out.println("生产者生产了，库存"+this.count);
        notifyAll();

    }

    public synchronized void consume() {
        while (this.count <= 0) {
            try {
                System.out.println("已经没有库存 消费者等待。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("消费者消费中。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count--;
        System.out.println("消费者消费了，库存" + this.count);
        notifyAll();


    }


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
package com.way.t16;

public class Producer implements Runnable {

    private Factory factory;

    public Producer(Factory factory) {
        this.factory = factory;
    }



    @Override
    public void run() {
        while (true){
            this.factory.produce();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
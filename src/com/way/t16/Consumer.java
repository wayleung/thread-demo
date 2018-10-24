package com.way.t16;

public class Consumer implements Runnable {

    private Factory factory;

    public Consumer(Factory factory) {
        this.factory = factory;
    }



    @Override
    public void run() {
        while (true) {
            this.factory.consume();
        }
    }
}
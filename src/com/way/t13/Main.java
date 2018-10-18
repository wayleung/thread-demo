package com.way.t13;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/18/2018 16:54
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Demo d =  new Demo();

//        d.put("a",10);
//        d.put("b",20);
//        d.put("c",30);
//        d.put("d",40);
//        d.put("e",50);
//        d.put("f",60);
//        d.put("g",70);
//        d.put("h",80);
//        d.put("i",90);

        //可以观察到写之间是互斥 要等待

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.put("a",10);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.put("b",20);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.put("c",30);
//            }
//        }).start();


        //可以观察读写之间是互斥 要等待
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.put("a",10);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(d.get("a"));
//            }
//        }).start();


        //读读之间不互斥 同时进行
        d.put("a",10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("a"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("a"));
            }
        }).start();







    }
}

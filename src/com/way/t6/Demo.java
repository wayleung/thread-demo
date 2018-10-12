package com.way.t6;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/11/2018 16:30
 * @Description:
 */
public class Demo {
//    public synchronized void a(){
//        System.out.println("a");
//        b();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }

    public synchronized void b() {
        System.out.println("b");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 证明了锁的重入
     */


//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Demo d = new Demo();
//                d.a();
//            }
//        }).start();
//    }

    /**
     * 不同线程拿同一个对象加锁  不能进入 即不能同时进行
     * @param
     */

//    public synchronized void a(){
//        System.out.println("a");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public static void main(String[] args) {
//
//        Demo d = new Demo();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.a();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.b();
//            }
//        }).start();


        /**
         * 不同线程拿不同的对象加锁  自然能够进入 即能同时进行
         * @param
         */
        public synchronized void a(){
            System.out.println("a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



        public static void main(String[] args) {

            Demo d1 = new Demo();
            Demo d2 = new Demo();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    d1.a();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    d2.b();
                }
            }).start();

    }







}

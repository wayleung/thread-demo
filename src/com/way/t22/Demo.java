package com.way.t22;/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 01:27
 * @Description:
 */

import com.way.t5.Main;

/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 01:27
 * @Description:
 */
public class Demo {

//    private ThreadLocal<Integer> count  = new ThreadLocal<>();
    //重写
    private ThreadLocal<Integer> count  = new ThreadLocal<Integer>(){
    @Override
    protected Integer initialValue() {
        return 0;
    }
};

    public int getNext(){
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        Demo demo  =  new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName()+"  "+demo.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName()+"  "+demo.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName()+"  "+demo.getNext());
                }
            }
        }).start();
    }
}

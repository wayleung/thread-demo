package com.way.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 既有返回值又能抛出异常的
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/9/2018 14:24
 * @Description:
 */
public class Demo4 implements Callable<Integer> {

    public static void main(String[] args) {
        Demo4 d = new Demo4();
        //对线程任务的封装
        FutureTask<Integer> task = new FutureTask<>(d);


    }


    @Override
    public Integer call() throws Exception {
        System.out.println("programing....");
        Thread.sleep(3000);
        return 1;
    }
}

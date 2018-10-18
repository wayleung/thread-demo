package com.way.t10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/16/2018 12:52
 * @Description:
 */
public class MyLock implements Lock {

    /**无非是用synchronized
     * 总之，我们可以把API中所说的监视器（monitor）理解成同步锁。想要执行某个对象的notify(), notifyAll(),wait(), wait(long), wait(long, int)方法就必须获取该对象的锁，需要使用synchronized，不然就会抛出IllegalMonitorStateException异常
     *
     */

    //标志位 是否拿到锁
    private boolean isLocked = false;



    @Override
    public synchronized void lock() {
        //第一个进来的不等待 其他等待

        //锁已经被拿了
        if (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //锁起来
        isLocked = true;
    }

    @Override
    public synchronized void unlock() {
        //第一个线程执行完毕 释放锁
        isLocked  = false;
        notify();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }


}

package com.way.t11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/18/2018 13:52
 * @Description:
 */
public class MyAQSLock implements Lock {

    //不用自己实现具体锁的方法 交给辅助器Sync
    private Sync helper =  new Sync();

    /*    应该将子类定义为非公共内部帮助器类，可用它们来实现其封闭类的同步属性.
        类 AbstractQueuedSynchronizer 没有实现任何同步接口。
        而是定义了诸如 acquireInterruptibly(int) 之类的一些方法，在适当的时候可以通过具体的锁和相关同步器来调用它们，以实现其公共方法。
        */
    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            //如果第一个线程进来 可以拿到锁 因此我们可以返回true

            //如果第二个线程进来 拿不到锁 返回false

            //(可重入)如果第二个进来的线程和当前保存的线程是同一个则运行可以拿到锁 但是有代价 要更新状态值

            //如何判断是第一个线程进来还是其他线程进来

            /*
            子类可以维护其他状态字段，
            但只是为了获得同步而只追踪使用 getState()、setState(int) 和 compareAndSetState(int, int) 方法来操作以原子方式更新的 int 值。
             */
            int state = getState();

            Thread t = Thread.currentThread();
            //如果第一个线程进来 可以拿到锁 因此我们可以返回true
            if (state == 0) {
                //不能用setState(arg);  因为会出现线程安全性问题
                if (compareAndSetState(0, arg)) {
                    //设置了当前线程 独占锁？
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if(getExclusiveOwnerThread()  == t){
                //重入 而且没有线程安全性问题
                setState(state+1);
                return true;

            }
            return false;

        }

        @Override
        protected boolean tryRelease(int arg) {
            //锁的获取和释放是一一对应 那么调用此方法的线程一定是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }


            int state = getState() - arg;

            boolean flag = false;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        helper.acquire(1);
    }


    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }


    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }


}

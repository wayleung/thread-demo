package com.way.t19;/**
 * @Auther: Way Liang
 * @Date: 10/26/2018 00:34
 * @Description:
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Way Liang
 * @Date: 10/26/2018 00:34
 * @Description:
 */
public class MyQueue<T> {

    private Object[] obj;

    //数据结构
    private int addIndex;

    private int removeIndex;

    private int queueSize;

    private Lock lock = new ReentrantLock();
    Condition add = lock.newCondition();
    Condition remove = lock.newCondition();

    public MyQueue(int count){
        obj  = new Object[count];
    }

    public void add(T t){
        lock.lock();
        while (queueSize==obj.length){
            try {
                add.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obj[addIndex]=t;
        if (++addIndex == obj.length-1) {
            addIndex = 0;
        }

        queueSize++;
        remove.signal();
        lock.unlock();
    }

    public void remove(){
        lock.lock();
        while (queueSize==0) {
            try {
                remove.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obj[removeIndex] = null;
        if (++removeIndex == obj.length) {
            removeIndex=0;
        }
        queueSize--;
        lock.unlock();
    }

}

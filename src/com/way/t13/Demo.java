package com.way.t13;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/18/2018 16:45
 * @Description:
 */
public class Demo {
    private Map<String, Object> map = new HashMap<>();

    //读写锁实现类
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //分别获取读锁和写锁
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public Object get(String key) {
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+" 读操作在执行。。");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);

        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+" 读操作执行完毕。。");
        }
    }

    public void put(String key, Object value) {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName()+" 写操作在执行。。");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+" 写操作执行完毕。。");
        }
    }
}

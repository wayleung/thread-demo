package com.way.t5;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/11/2018 14:25
 * @Description:
 */
public class SingletonLazy {

    private SingletonLazy() {

    }

    private static volatile SingletonLazy singletonLazy;


    //解决方法 synchronzied  但是在方法加不好 性能降低
    public static synchronized SingletonLazy getInstance() {
        //轻量级锁  自旋锁 相当于while（true） 消耗cpu资源？
        //    public static SingletonLazy getInstance(){
        if (singletonLazy == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            synchronized(SingletonLazy.class){
                //非原子性操作 双重检查加锁
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();//没法完全安全  指令重排序 jvm优化 有这种可能 所以volatile 避免指令重排序
                }
            }

        }
        return singletonLazy;
    }
}

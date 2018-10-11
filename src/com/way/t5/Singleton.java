package com.way.t5;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/11/2018 13:57
 * @Description:
 */
public class Singleton {

    //饿汉式 直接在类创建时便实例化
    private static Singleton instance =  new Singleton();

    //私有化构造方法
    private Singleton(){

    }

    //提供公有的获取实例的方法 而且因为不能new 所以是类的方法
    public static Singleton getInstance(){
        return instance;
    }
}

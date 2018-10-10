package com.way.t4;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/10/2018 15:04
 * @Description:
 */
public class Sequence {

    private int value;

    public int getNext(){
        return value++;
    }

    public static void main(String[] args) {
        new Sequence().getNext();
    }
}

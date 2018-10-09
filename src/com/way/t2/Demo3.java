package com.way.t2;

/**通过匿名内部类启动
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/9/2018 14:14
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) {

        //作为子类继承
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread start...");
            }
        }.start();



        //接口作为参数
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("thread start....");
            }
        }).start();




        //。。。 两种都是用 想一想过程就好了 子类的run方法覆盖了父类的run方法
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("sub");
            }
        }.start();


    }
}

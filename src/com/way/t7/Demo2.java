package com.way.t7;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 10/12/2018 11:23
 * @Description:
 */
public class Demo2 {
//    private int a = 1;
    /*  不加volatile  有可能会出现1
    "C:\Way Liang\jdk\jdk1.8.0_92\bin\java.exe" "-javaagent:C:\Way Liang\idea\lib\idea_rt.jar=51456:C:\Way Liang\idea\bin" -Dfile.encoding=UTF-8 -classpath "C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\charsets.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\deploy.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\access-bridge-64.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\cldrdata.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\dnsns.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\jaccess.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\jfxrt.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\localedata.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\nashorn.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunec.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunjce_provider.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunmscapi.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunpkcs11.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\zipfs.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\javaws.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jce.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jfr.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jfxswt.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jsse.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\management-agent.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\plugin.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\resources.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\rt.jar;C:\Way Liang\personal\Projects\thread-demo\out\production\thread-demo" com.way.t7.Demo
1
最终结果：10

Process finished with exit code 0
     */
    public volatile int a = 1;
/*
"C:\Way Liang\jdk\jdk1.8.0_92\bin\java.exe" "-javaagent:C:\Way Liang\idea\lib\idea_rt.jar=57640:C:\Way Liang\idea\bin" -Dfile.encoding=UTF-8 -classpath "C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\charsets.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\deploy.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\access-bridge-64.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\cldrdata.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\dnsns.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\jaccess.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\jfxrt.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\localedata.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\nashorn.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunec.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunjce_provider.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunmscapi.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\sunpkcs11.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\ext\zipfs.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\javaws.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jce.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jfr.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jfxswt.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\jsse.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\management-agent.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\plugin.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\resources.jar;C:\Way Liang\jdk\jdk1.8.0_92\jre\lib\rt.jar;C:\Way Liang\personal\Projects\thread-demo\out\production\thread-demo" com.way.t7.Demo2
10
最终结果：10

Process finished with exit code 0
 */


    public  int getA() {
        return a;
    }

    public  void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Demo2 demo2  = new Demo2();

//        demo2.a = 10;


        new Thread(new Runnable() {
            @Override
            public void run() {
                demo2.setA(10);
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo2.getA());
            }
        }).start();

        try {
            //保证上面先执行。。
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终结果："+demo2.getA());

    }
}

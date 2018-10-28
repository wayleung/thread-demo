package com.way.t23;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Way Liang
 * @Date: 10/28/2018 14:38
 * @Description:
 */
public class Demo {
    //存储每行的数字总和的数组
    private int[] nums;

    public Demo(int line){
        nums =  new int[line];
    }

    public void calc(String line,int index){
        //切分每行中的数字的值
        String[] numbers =  line.split(",");
        int total = 0;
        for (String num:numbers) {
            total +=Integer.parseInt(num);
        }
        //把计算的结果放到数组中指定的位置
        nums[index] = total;
        System.out.println(Thread.currentThread().getName()+"执行计算任务。。。"+line +"结果为："+total);
    }

    public void sum(){
        System.out.println("汇总线程开始执行");
        int total = 0;
        for (int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        System.out.println("最终结果为："+total);
    }


    public static void main(String[] args) {
        List<String> contents = readFile();
        int lineCount  = contents.size();

        CountDownLatch latch = new CountDownLatch(lineCount);

        Demo demo =  new Demo(lineCount);

        for(int i =0;i<lineCount;i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.calc(contents.get(finalI), finalI);
                }
            }).start();
        }

//        while (Thread.activeCount()>1){
        //为啥我的电脑是2
        while (Thread.activeCount()>2){

        }

        demo.sum();

    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Way Liang\\personal\\Projects\\thread-demo\\src\\com\\way\\t23\\nums.txt"));
            while ((line = br.readLine())!=null){
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;
    }

}

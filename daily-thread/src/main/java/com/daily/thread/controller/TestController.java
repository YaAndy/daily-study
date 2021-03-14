package com.daily.thread.controller;

import com.daily.thread.model.ThreadP1;
import com.daily.thread.model.ThreadP2;

public class TestController {

    public static void main(String[] args) {
        TestController test = new TestController();
//        test.p1Test();
        test.p2Test();


    }

    //2.学习演示运行结果的随机性
    private void p2Test(){
        ThreadP2 p2 = new ThreadP2();
        p2.start();

        System.out.println("JVM启动的main线程，TestController.main()");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main Thread:"+i);
                int time = (int)(Math.random() * 1000); //Math.random() 产生 0~1 之间的随机数
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //1.学习线程创建、启动
    private void p1Test(){
        System.out.println("JVM启动的main线程，TestController.main()");
        //创建线程对象
        ThreadP1 thread = new ThreadP1();

        //启动线程
        thread.start();

        //其后的逻辑代码
        System.out.println("这是 TestController.main() 后边的代码");

        /*
         ps：调用线程的start()来启动线程，启动线程的实质就是请求jvm运行相应的线程，这个线程具体在什么时候运行由线程调度器（Scheduler）决定
         注意：
            start()调用结束并不意味着子线程开始运行，只是告知线程调度器已准备好；
            新开启的线程会执行run()；
            如果开启了多个线程，start（）调用的顺序并不一定就是线程启动的顺序；
            多线程运行结果与 代码执行/调用顺序无关
         */
    }

}

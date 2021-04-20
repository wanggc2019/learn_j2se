package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/15 星期六 16:19
 */

/*
创建线程的第二种方式.使用Runnable接口.
该类中的代码就是对线程要执行的任务的定义.
1：定义了实现Runnable接口
2：重写Runnable接口中的run方法，就是将线程运行的代码放入在run方法中
3：通过Thread类建立线程对象
4：将Runnable接口的子类对象作为实际参数，传递给Thread类构造方法
5：调用Thread类的start方法开启线程，并调用Runable接口子类run方法
为什么要将Runnable接口的子类对象传递给Thread的构造函数，因为自定义的run方法所属对象是Runnable接口的子类对象，
所以要让线程去执行指定对象的run方法

* */
class RunableTest implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<200;i++){
            System.err.println("RunableTest"+i);
        }
    }
}

public class RunnableDemo{
    public static void main(String[] args) {
        RunableTest runableTest = new RunableTest();
        Thread thread = new Thread(runableTest);
        thread.start();
        for (int i=0;i<200;i++){
            System.err.println("RunnableDemo"+i);
        }
    }
}

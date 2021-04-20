package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/15 星期六 11:50
 */
class ThreadDemo2 extends Thread{
    public ThreadDemo2(){

    }

    public ThreadDemo2(String name){
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (i<30){
            i++;
            System.out.println(this.getName()+" "+":i="+i);
            System.out.println(Thread.currentThread().getName()+" "+":i="+i);
            System.out.println(Thread.currentThread() == this);
            System.out.println("getId()"+" "+":id="+super.getId());
            System.out.println("getPriority()"+" "+": Priority ="+ super.getPriority());
        }
    }
}

class ThreadTest{
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2_1 = new ThreadDemo2("线程1");
        ThreadDemo2 threadDemo2_2 = new ThreadDemo2("线程2");
    //    设置线程名
        threadDemo2_1.setName("thread01");
        threadDemo2_2.setName("thread02");
    //    查看sun定义得线程优先级范围
        System.out.println("max:"+Thread.MAX_PRIORITY);
        System.out.println("min:"+Thread.MIN_PRIORITY);
        System.out.println("nor:"+Thread.NORM_PRIORITY);

        threadDemo2_1.start();
        threadDemo2_2.start();
        System.out.println("Hello World");
    }
}
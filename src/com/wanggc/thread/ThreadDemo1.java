package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/15 星期六 10:29
 */

/*
* 多线程的好处：
1.	解决了一个进程里面可以同时运行多个任务（执行路径）。
2.	提供资源的利用率，而不是提供效率。
多线程的弊端:
1.	降低了一个进程里面的线程的执行频率。
2.	对线程进行管理要求额外的 CPU开销。线程的使用会给系统带来上下文切换的额外负担。
3.	公有变量的同时读或写。当多个线程需要对公有变量进行写操作时,后一个线程往往会修改掉前一个线程存放的数据，发生线程安全问题。
4.	线程的死锁。即较长时间的等待或资源竞争以及死锁等多线程症状。

* */
class ThreadDemo1 extends Thread{
    public ThreadDemo1(String name){
        super(name);
    }

    public void print(){
        for (int i=0;i<10;i++){
            try{
                this.sleep(100);//100ms
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this.getName()+" "+i);
        }
    }
    //需要复写run方法，把要执行的任务放在run方法中
    @Override
    public void run() {
        print();
    }

    public static void main(String[] args) {
        //创建线程1
        ThreadDemo1 threadDemo1 = new ThreadDemo1("王国昌");
        //创建线程2
        ThreadDemo1 threadDemo2 = new ThreadDemo1("王大爷");
        //threadDemo1.print();
        //threadDemo2.print();
        //线程的启动使用父类的start()方法
        threadDemo1.start();
        threadDemo2.start();
    }

}
/*
线程的使用细节：
1.	线程的启动使用父类的start()方法
2.	如果线程对象直接调用run()，那么JVN不会当作线程来运行，会认为是普通的方法调用。
3.	线程的启动只能由一次，否则抛出异常
4.	可以直接创建Thread类的对象并启动该线程，但是如果没有重写run()，什么也不执行。
5.	匿名内部类的线程实现方式

线程得状态：
创建：新创建了一个线程对象。
可运行：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取cpu的执行权。
运行：就绪状态的线程获取了CPU执行权，执行程序代码。
阻临时塞: 阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。
死亡：线程执行完它的任务时。

* */
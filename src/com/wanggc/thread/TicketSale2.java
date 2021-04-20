package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/16 星期日 22:37
 */
/*
买票例子使用Runnable接口实现
* */
public class TicketSale2 {
    public static void main(String[] args) {
        MyTicket myTicket = new MyTicket();
        Thread thread1= new Thread(myTicket);
        Thread thread2 = new Thread(myTicket);
        Thread thread3 = new Thread(myTicket);
        Thread thread4 = new Thread(myTicket);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class MyTicket implements Runnable{
    int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                try{
                    Thread.sleep(100);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"窗口@销售："+ ticket+"号票");
                ticket--;
            } else {
                System.out.println("票已买完");
                break;
            }
        }
    }
}

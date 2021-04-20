package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/15 星期六 15:39
 */

//模拟卖票
class TicketSale extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (ticket>100){
            System.out.println("卖到了第"+ticket+"张票");
            ticket--;
        }
    }
}

class TicketSaleTest{
    public static void main(String[] args) {
        TicketSale thread1 = new TicketSale();
        TicketSale thread2 = new TicketSale();
        TicketSale thread3 = new TicketSale();
        TicketSale thread4 = new TicketSale();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

/*
存在问题：这时候启动了四个线程，那么tickets是一个成员变量，也就是在一个线程对象中都维护了属于自己的tickets属性，那么就总共存在了四份。
解决方案一：tickets使用staitc修饰，使每个线程对象都是共享一份属性。
解决方案2：编写一个类实现Runnable接口

* */

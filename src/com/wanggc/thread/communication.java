package com.wanggc.thread;

/**
 * @author wanggc
 * @date 2019/06/17 星期一 16:32
 */

/*
线程间通信其实就是多个线程在操作同一个资源，但操作动作不同
生产者消费者
如果有多个生产者和消费者，一定要使用while循环判断标记，然后在使用notifyAll唤醒，否者容易只用notify容易出现只唤醒本方线程情况，导致程序中的所有线程都在等待。
例如：有一个数据存储空间，划分为两个部分，一部分存储人的姓名，一部分存储性别，我们开启一个线程，不停地想其中存储姓名和性别（生产者），开启另一个线程从数据存储空间中取出数据（消费者）。
	由于是多线程的，就需要考虑，假如生产者刚向数据存储空间中添加了一个人名，还没有来得及添加性别，cpu就切换到了消费者的线程，消费者就会将这个人的姓名和上一个人的性别进行了输出。
还有一种情况是生产者生产了若干次数据，消费者才开始取数据，或者消费者取出数据后，没有等到消费者放入新的数据，消费者又重复的取出自己已经去过的数据。

* */
public class communication {
    public static void main(String[] args) {

        Person person = new Person();
        Producer producer = new Producer(person);
        Consummer consummer = new Consummer(person);
        Thread thread1 = new Thread(producer, "生产者");
        Thread thread2 = new Thread(consummer, "消费者");
        thread1.start();
        thread2.start();
    }
}
// 使用person作为数据存储空间
class Person{
    String name;
    String genger;
    boolean flag = false;

    public synchronized void set(String name,String gender){
        if (flag){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.name = name;
        this.genger = gender;
        flag = true;
        notify();
    }

    public synchronized void read(){
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("name:" + this.name + "----gender:" + this.genger);
        flag = false;
        notify();
    }
}
//生产者
class Producer implements Runnable{
    Person person;

    public Producer(){

    }

    public Producer(Person person){
        this.person = person;
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            //synchronized (person) {
                if (i % 2 == 0) {
                    //person.name = "Jack";
                    //person.genger = "man";
                    person.set("Jack","man");
                } else {
                    //person.name = "Mary";
                    //person.genger = "woman";
                    person.set("Mary","woman");
                }
                i++;
            }
        }
    }
//}

class Consummer implements Runnable{
    Person person;

     public Consummer(){

     }

     public Consummer(Person person){
         this.person = person;
     }
    @Override
    public void run() {
         while (true) {
             //synchronized (person) {
             //    System.out.println("name:" + person.name + "----gender:" + person.genger);
             person.read();
             }
         }
    }
//}

/*
在上述代码中，Producer和Consumer 类的内部都维护了一个Person类型的p成员变量，
通过构造函数进行赋值，在main方法中创建了一个Person对象，将其同时传递给Producer和Consumer对象，
所以Producer和Consumer访问的是同一个Person
* */

/*
wait：告诉当前线程放弃执行权，并放弃监视器（锁）并进入阻塞状态，直到其他线程持有获得执行权，并持有了相同的监视器（锁）并调用notify为止。
notify：唤醒持有同一个监视器（锁）中调用wait的第一个线程，例如，餐馆有空位置后，等候就餐最久的顾客最先入座。注意：被唤醒的线程是进入了可运行状态。等待cpu执行权。
notifyAll：唤醒持有同一监视器中调用wait的所有的线程。

如何解决生产者和消费者的问题？
可以通过设置一个标记，表示数据的（存储空间的状态）例如，当消费者读取了（消费了一次）一次数据之后可以将标记改为false，当生产者生产了一个数据，将标记改为true。
，也就是只有标记为true的时候，消费者才能取走数据，标记为false时候生产者才生产数据。

* */
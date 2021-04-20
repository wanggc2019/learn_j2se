package com.wanggc.singleInstrance;

/**
 * @author wanggc
 * @date 2019/05/28 星期二 22:50
 */
// 4.懒汉式 加同步锁,同步方法，线程安全，不推荐
public class Single3 {
    // 1.再类中创建一个私有的本类对象
    private static Single3 instance;

    // 2.私有化构造方法
    private Single3() {

    }

    // 加同步锁,同步方法，线程安全，不推荐
    public static synchronized Single3 getInstance() {
        if (instance == null) {
            instance = new Single3();
        }
        return instance;
    }
}
/*
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 * */
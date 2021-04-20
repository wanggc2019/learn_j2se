package com.wanggc.singleInstrance;

/**
 * @author wanggc
 * @date 2019/05/28 星期二 22:52
 */

// 5.懒汉式  加同步锁,同步代码块，线程安全，不可用
public class Single4 {
    // 1.再类中创建一个私有的本类对象
    private static Single4 instance;

    // 2.私有化构造方法
    private Single4() {

    }

    // 加同步锁,同步代码块，线程安全，不可用
    public static Single4 getInstance() {
        if (instance == null) {
            synchronized (Single4.class) {
                instance = new Single4();
            }
        }
        return instance;
    }

    /*
     * 这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，
     *假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
     * */
}

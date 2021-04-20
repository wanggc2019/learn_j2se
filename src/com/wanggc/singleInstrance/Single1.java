package com.wanggc.singleInstrance;

/**
 * @author wanggc
 * @date 2019/05/28 星期二 9:49
 */

// 1.饿汉式  静态常量    可用
// 2.饿汉式  静态代码块  可用
class Single1 {
    // 1.再类中创建一个私有的本类对象，
    // 1)静态常量，可用
    private static Single1 instance = new Single1();

/*
    //2)也可用静态代码块,可用
    private static Single1 instance;
    static {
        instance = new Single1();
    }
*/

    // 2.私有化构造方法
    private Single1(){

    }

    // 3.对外提供公有方法获取该对象，该方法通过用类名调用
    public static Single1 getInstance(){
        return instance;
    }
}

/*
1.优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
2.缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
* */

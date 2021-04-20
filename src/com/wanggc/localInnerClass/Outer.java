package com.wanggc.localInnerClass;

/**
 * @author wanggc
 * @date 2019/06/10 星期一 11:04
 */
public class Outer {
    int num = 10;
    // 内部类
    class Inner{
        int num = 20;

    }

    public void method(final int y){
        final int x = 3;
        final int num = 30;
        //局部内部类，定义
        class LocalInner{
            void show(){
                System.out.println("show localInner num:"+ num);
                System.out.println("show outer num:"+Outer.this.num);
                System.out.println("show x:"+ x);
                System.out.println("show y:"+ y);
            }
        }

        new LocalInner().show();
    }
}

class LocalInnerDemo{
    public static void main(String[] args) {
        new Outer().method(5);
    }
}

/*
局部内部类概述：包含在外部类的函数中的内部类称之为局部内部类。
访问：可以在包含局部内部类的方法中直接创建局部内部类的对象调用局部内部类的成员。
注意：局部内部类只能访问所在函数的fanal属性。

* */

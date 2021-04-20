package com.wanggc.innerClass;

/**
 * @author wanggc
 * @date 2019/06/10 星期一 15:56
 */

//
abstract class AnonymousInner {
    //abstract void show();
    abstract void show1();
    abstract void show2();
}

class AnonymousInnerTest{

/*    public void print(){
        new AnonymousInner(){
            public void show(){
                System.out.println("匿名内部类得show方法");
            }
        }.show();
    }*/
    AnonymousInner anonymousInner = new AnonymousInner() {
    @Override
    void show1() {
        System.out.println("匿名内部类show1");
    }

    @Override
    void show2() {
        System.out.println("匿名内部类show2");
    }
    };

    public void print(){
        anonymousInner.show1();
        anonymousInner.show2();
    }
}

/*
匿名内部类：就是没有类名字的内部类。
匿名内部类作用：简化内部类书写。
匿名内部类的前提:必须继承一个父类或者是实现一个接口。
匿名内部类的格式：
	new 父类或者接口(){ 执行代码….};

注意细节：
1.使用匿名内部类时，如果需要调用匿名内部类的两个方法或者两个方法以上。可以使用变量指向该对象。

* */






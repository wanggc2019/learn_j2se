package com.wanggc.polymorphism;

import com.wanggc.inheritance.FinalTest;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 19:28
 */

/*
* 4：如何在多态下，使用父类引用调用子类特有方法。
		1：基本类型转换：
			1：自动：小->大
			2：强制：大->小
		2：类类型转换
			前提：继承，必须有关系
			1：自动：子类转父类
			2：强转：父类转子类
			3：类型转换
				1：Son s=(Son)f
				2：s.method3();

* */
class Father {
    int x = 1;
    static int y =2;

    void eat(){
        System.out.println("开吃");
    }

    static void speak(){
        System.out.println("小头吧吧");
    }

    void method1(){
        System.out.println("这是父类1");
    }

    void method2(){
        System.out.println("这是父类2");
    }
}

class Son extends Father{
    int x =3;
    static int y =4;

    @Override
    void eat(){
        System.out.println("大头儿子很能吃");
    }

    static void speak(){
        System.out.println("大头儿子");
    }

    @Override
    void method1() {
        System.out.println("这是子类1");
    }

    void method3() {
        System.out.println("这是子类3");
    }
}

class Demo{
    public static void main(String[] args) {
        //父类引用字类对象
        Father father = new Son();
        System.out.println(father.x);//1
        System.out.println(father.y);//2

        //父类引用变量指向了子类的对象
        father.eat(); //输出的是字类
        father.speak();//输出的是父类

        father.method1();//子类1
        father.method2();//父类2
        //编译报错，多态弊端，只能用父类指向父类的成员
        //father.method3();

    //    类类型转装
        Son son = (Son) father;
        son.method3();//子类3
    }
}

/*
总结
成员变量：
1：当父类和子类具有相同的非静态成员变量，那么在多态下访问的是父类的成员变量
2：当父类和子类具有相同的静态成员变量，那么在多态下访问的是父类的静态成员变量
 所以：父类和子类有相同的成员变量，多态下访问的是父类的成员变量。

方法：
3：当父类和子类具有相同的非静态方法（就是子类重写父类方法），多态下访问的是子类的成员方法。
4：当父类和子类具有相同的静态方法（就是子类重写父类静态方法），多态下访问的是父类的静态方法。

* */




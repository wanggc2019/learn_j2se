package com.wanggc.Reflection;

import com.wanggc.encapsulation.Calculator;

/**
 * @author wanggc
 * @date 2019/07/02 星期二 20:46
 */

/*
1.1.1.	获取Class对象的三种方式
Java提供了三种方式获取类的字节码
	forName()。forName方法用于加载某个类的字节码到内存中，并使用class对象进行封装
	类名.class
	对象.getClass()

* */

public class GetClassInfo {
    public static void main(String[] args) {
        GetClassInfo getClassInfo = new GetClassInfo();
        try {
            getClassInfo.getClassObject();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getClassObject() throws Exception{
    //    方式1
        Class obj = Class.forName("com.wanggc.encapsulation.Calculator");
        System.out.println("obj:"+obj);
    //    方式2
        Class obj2 = Calculator.class;
        System.out.println("obj:"+obj2);
    //    方式3
        Calculator calculator = new Calculator();
        Class obj3 = calculator.getClass();
        System.out.println("obj3:"+obj3);
    }
}

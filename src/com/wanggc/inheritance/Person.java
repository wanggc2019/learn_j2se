package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/29 星期三 22:26
 */

class Person {
    String name;
    int age;
    static String country = "中国";

    Person(){

    }

    void speak(){
        System.out.println("姓名："+name + "\t"+"年龄："+age+"\t"+":我是人");
    }
}




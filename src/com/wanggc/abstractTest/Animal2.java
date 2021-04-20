package com.wanggc.abstractTest;

/**
 * @author wanggc
 * @date 2019/06/01 星期六 22:20
 */
abstract class Animal2 {
    String color;
    String name;
    //抽象类可以又构造函数
    Animal2(){

    }

    Animal2(String name){
        this.name = name;
    }

    abstract void shout();
}



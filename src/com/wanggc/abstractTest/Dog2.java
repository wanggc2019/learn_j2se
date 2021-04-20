package com.wanggc.abstractTest;

/**
 * @author wanggc
 * @date 2019/06/01 星期六 22:22
 */
public class Dog2 extends Animal2 {
    Dog2(){

    }

    Dog2(String name){
        super(name);
    }

    void shout(){
        System.out.println("汪汪");
    }

}

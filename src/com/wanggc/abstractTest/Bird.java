package com.wanggc.abstractTest;

/**
 * @author wanggc
 * @date 2019/06/01 星期六 22:24
 */
public class Bird extends Animal2 {

    Bird(){

    }

    Bird(String name){
        super(name);
    }

    void  shout(){
        System.out.println("叽叽喳喳");
    }
}

package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/29 星期三 23:09
 */
class Father {
    int x = 1;

    Father(){
        System.out.println("这是父类的无参函数");

    }

    Father(int x){
        this.x = x;
        System.out.println("这是父类的有参函数");
    }

    void speark(){
        System.out.println("我是父亲");
    }

    void eat(){
        System.out.println("吃窝窝头");
    }
}

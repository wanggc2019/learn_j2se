package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/29 星期三 23:10
 */
class Son extends Father{
    int y =2;
    Son(){
        System.out.println("这是子类的无参函数");
    }

    Son(int y){
        this.y = y + x;
        System.out.println("这是子类的有参函数");
    }

    void run(){
        super.speark();
        System.out.println("我是儿子");
    }

    public void eat(){
        System.out.println("来点小菜");
        System.out.println("来点花生");
    }

}

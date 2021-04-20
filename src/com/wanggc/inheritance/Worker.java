package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/29 星期三 22:38
 */
class Worker extends Person{
    Worker(){

    }

    void work(){
        System.out.println("姓名："+ name+"\t"+"年龄："+age+"\t"+":好好工作");
    }
}

package com.wanggc.object;

/**
 * @author wanggc
 * @date 2019/5/24 10:17
 */
class SCar{
    String name = "smart";
    String color = "red";
    int num = 4;
    void run(){
        if (num < 4){
            System.out.println("汽车坏了，赶紧修理");
        }
        else {
            System.out.println(name + ":"+color+":"+num+":跑起来了");
        }
    }

    @Override
    public String toString() {
        return this.name + "-" + this.color;
    }
}






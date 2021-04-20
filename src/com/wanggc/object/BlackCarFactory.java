package com.wanggc.object;

/**
 * @author wanggc
 * @date 2019/5/24 10:19
 */
class BlackCarFactory{
    String name;
    String addr;

    void repairCar(SCar sc){
        sc.num = 3;
        sc.color = "黑色";
        System.out.println("非法改装成功！");
    }
}


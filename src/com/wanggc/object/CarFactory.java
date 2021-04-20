package com.wanggc.object;

/**
 * @author wanggc
 * @date 2019/5/24 10:19
 */
class CarFactory {
    String name;
    String addr;

    void repairCar(SCar sc) {
        sc.num = 4;
        System.out.println("汽车坏了");
    }
}

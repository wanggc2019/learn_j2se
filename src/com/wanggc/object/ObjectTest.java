package com.wanggc.object;

/**
 * @author wanggc
 * @date 2019/5/24 024 10:18
 */
// 面向对象练习

public class ObjectTest {
    public static void main(String[] args){
        BlackCarFactory bcf = new BlackCarFactory();
        bcf.name = "老王修理厂";
        bcf.addr = "胡同口地下市38层";

        //非匿名对象
        //SCar sc = new SCar();
        //sc.run();
        //汽车轮子改为3个
        //sc.num=3;
        //sc.run();

        // 匿名对象1,只使用一次，创建了2个对像
        new SCar().run();
        new SCar().run();

        //匿名对象2，作为实际参数传递
        //SCar sc2 = bcf.repairCar(new SCar());
        //sc2.run();

        //改装
        //bcf.repairCar(sc);
        //取车
        //sc.run();

        //CarFactory cf = new CarFactory();
        //cf.name = "幸福修理厂";
        //cf.addr = "天堂区地狱区上帝大厦a栋6楼503";

        //cf.repairCar(sc);
        //sc.run();

        System.out.println();
        //开发者要对自定义的类重写toString()，对对象做详细的说明
        System.out.println(new SCar().toString());

    }
}


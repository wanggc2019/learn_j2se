package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/06/01 星期六 17:55
 */
public class FinalTest {
    //静态常量
    public static final double PI = 3.14;

    public static double getArea(double r){
        return PI * r * r;
    }

    public static double getLength(double r){
        return PI * r * 2;
    }
}

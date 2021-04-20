package com.wanggc.staticTest2;

/**
 * @author wanggc
 * @date 2019/05/27 星期一 10:12
 */

/*
* 1：static
		1：为了实现对象之间重复属性的数据共享
2：static使用
		1：主要用于修饰类的成员
			1：成员变量
					1：非静态成员变量：需要创建对象来访问
					2：静态成员变量：使用类名直接调用，也可以通过对象访问

* */

public class StaticTest {
    public static void main(String[] args) {
        //1.通过对象.成员来访问静态变量
        //Person5 ps = new Person5("王国昌",20,"男",100000);
        //ps.country = "美国";
        //2.通过直接类名.变量名访问
        String country = Person5.country;
        System.out.println(country);
        //ps.check();

        int[] arr = {3,4,5,2,3,7,4};
        Tools.print(arr);
        Tools.selectSort(arr);
        Tools.print(arr);


    }
}

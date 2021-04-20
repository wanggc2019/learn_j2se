package com.wanggc.unboxing;

/**
 * @author wanggc
 * @date 2019/06/27 星期四 0:28
 */

/*
* 自动装箱：指开发人员可以把一个基本数据类型直接赋给对应的包装类。
自动拆箱：指开发人员可以把一个包装类对象直接赋给对应的基本数据类型。
典型应用：
	List list = new ArrayList();
	list.add(1);
	//list.add(new Integer(1));
	int i=list.get(0);
	//int j = (Integer)list.get(0);

* */
public class BoxingDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        //    基本数据类型-->字符串
        int i = 100;
        String str = 100 + "";
        String string = Integer.toString(i);//100-->"100"
        System.out.println(string);
        //    字符串-->基本数据类型
        String str2 = "123";
        int parseInt = Integer.parseInt(str2);
        System.out.println(parseInt);

        /*
         * JDK5.0后出现了自动装箱和拆箱,JDK5.0以后，简化了定义方式。
         * */

        Integer x = new Integer(5);//装箱
        int intValue = x.intValue();//拆箱
        // 5.0简化书写
        // 自动装箱。new Integer(5);
        //装箱
        Integer y = 5;
        System.out.println(x);
    // 对象加整数,x 进行了自动拆箱,变成了int 型 和5进行加法运算后再将和进行装箱赋给x。
        //拆箱
        y = y +5; //是通过Integer.intValue() 方法进行拆箱
        System.out.println(y);
    }
}

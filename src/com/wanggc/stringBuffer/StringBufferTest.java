package com.wanggc.stringBuffer;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wanggc
 * @date 2019/06/14 星期五 9:36
 */

/*
StringBuffer : 由于String是不可变的，所以导致String对象泛滥，在频繁改变字符串对象的应用中，需要使用可变的字符串缓冲区类。
特点：
1.	默认缓冲区的容量是16。
2.	StringBuffer  ： 线程安全的所有的缓冲区操作方法都是同步的。效率很低。

* */

/*
StringBuilder 是JDK1.5之后提出的，线程不安全，但是效率要高。用法与StringBuffer类似。
* */
public class StringBufferTest {
    public static void main(String[] args) throws Exception{
/*        StringBuffer stringBuffer = new StringBuffer("jack");
        stringBuffer.append(true);
        stringBuffer.append("a");
        //链式编程
        stringBuffer.append(97).append(34.0).append(new char[]{'o','o'});
        //输出缓冲区得文本数据
        System.out.println(stringBuffer.toString());

        stringBuffer = new StringBuffer("jack");
        stringBuffer.insert(2,"hello");
        System.out.println(stringBuffer.toString());

        StringBuilder stringBuilder = new StringBuilder("WangGuoChang");
        stringBuilder.append("-").append(20).append("-").append(001);
        System.out.println(stringBuilder.toString());
        //获取系统属性
        Properties properties = System.getProperties();
        // 输出系统属性
        properties.list(System.out);
        //获取系统名称
        String os_name = System.getProperty("os.name");
        System.out.println(os_name);
        //获取可用的内存数
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());

        Process tim = runtime.exec("D:\\Program Files (x86)\\Tencent\\TIM\\Bin\\TIM.exe");
        Thread.sleep(1000*10);
        tim.destroy();*/

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);//周日 1；。。。。周六 7

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(year + "年" + month+"月" + day + "日"+" "+"周"+week+" "+ hours+":"+minute+":"+second+".");

        //Date 类封装的是系统的当前时间.。但是Date已经过时了，sun推荐使用Calendar类。
        //Calendar: 该类是一个日历的类，封装了年月日时分秒时区。

        Date date = new Date();
        System.out.println(date);
       // 格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E a hh时mm分ss秒");
        System.out.println(simpleDateFormat.format(new Date()));

        //Math：类封装了很多数学的功能。
        System.out.println(Math.PI);
        System.out.println(Math.ceil(12.3));//13
        System.out.println(Math.ceil(12.5));//13
        System.out.println(Math.ceil(-12.3));//-12

        System.out.println(Math.round(12.3));//12
        System.out.println(Math.round(12.5));//13
        System.out.println(Math.round(-12.3));//-12

        //随机数
        System.out.println(Math.random());

    //    生成随机检验码
        Random random = new Random();
        char chs[] = new char[]{'a','b','c','d','3','5','9','你','好','@'};
        StringBuilder rel = new StringBuilder("");
        for (int i=0;i<4;i++){
            rel.append(chs[random.nextInt(chs.length)]);
        }
        System.out.println("校验码是："+ rel.toString());
    }
}

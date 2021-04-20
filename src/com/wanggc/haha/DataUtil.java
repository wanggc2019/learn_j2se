package com.wanggc.haha;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间格式化
 */
public class DataUtil {
    public static void main(String[] args)
    {
        Calendar now = Calendar.getInstance();
        System.out.println("年：" + now.get(Calendar.YEAR));
        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));
        System.out.println("日：" + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + now.get(Calendar.MINUTE));
        System.out.println("秒：" + now.get(Calendar.SECOND));

        Date date = new Date();
        System.out.println(date); //当前时间 Wed Nov 13 23:28:57 CST 2019
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        System.out.println("当前时间：" + sdf.format(date)); //格式化后的时间
        System.out.println("当前时间：" + sdf2.format(date));

        //getToday
        System.out.print("今天的时间是 ");
        System.out.println(DataUtil.getToday("dd"));

        //getYear
        System.out.print("今年是 ");
        System.out.println(DataUtil.getYear("YYYY"));

        //yesterday
        System.out.print("昨天 ");
        System.out.println(DataUtil.yesterday("d"));

        //thismonth
        System.out.print("本月 ");
        System.out.println(DataUtil.getThisMonth("YYYYMM"));

        //上月
        System.out.printf("上月 ");
        System.out.println(DataUtil.getLastMonth("MM"));


    }



    //YYYMMdd 年月日
    public static String getToday(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date date = calendar.getTime();
        String day = sdf.format(date);
        if ("#d".equalsIgnoreCase(pattern)) {
            day = day.replace("0", "");
        }
        return day;
    }

    //YYY 年
    public static String getYear(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date date = calendar.getTime();
        String year = sdf.format(date);
        return year;
    }

    //yesterday
    public static String yesterday(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, -1);
        Date date = calendar.getTime();
        String day = sdf.format(date);
        if ("#d".equalsIgnoreCase(pattern)) {
            day = day.replace("0", "");
        }
        return day;
    }

    //thisMonth
    public static String getThisMonth(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date date = calendar.getTime();
        String month = sdf.format(date);
        return month;
    }

    //lastmonth
    public static String getLastMonth(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, -1);
        Date date = calendar.getTime();
        String month = sdf.format(date);
        return month;
    }

}




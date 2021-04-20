package com.wanggc.staticTest;

/**
 * @author wanggc
 * @date 2019/05/ 星期五 24 14:12
 */

// 封装练习
public class EmployeeDemo {
    public static void main(String[] args) {
        //create an object
        Employee ed = new Employee();
/*

        ed.name = "wgc";
        ed.id = "13205140135";
        ed.gender = "男";

        //调用成员方法
        ed.work();
        System.out.println();

        //传入非法的参数
        ed.gender= "不是男人";
        ed.work();
*/

       //调用公有方法，给成员变量赋值
        ed.setId("13205140135");
        ed.setName("wgc");
        ed.setGender("男");

       // 调用成员方法
        ed.work();

       //获取实例变量的值
        System.out.println(ed.getGender());




    }
}



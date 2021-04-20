package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/30 星期四 22:55
 */
public class Animal {
    //int x = 1;
    //String name;
    private String name;
    private int id;

    public Animal(String name,int id){
        this.name = name;
        this.id = id;
    }

     public void eat(){
         System.out.println(name + "在吃东西");

     }

     public void sleep(){
         System.out.println(name + "在睡觉");
     }

     public void introduction(){
        System.out.println("我是"+ id+ "号"+name +".");
    }
}

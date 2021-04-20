package com.wanggc.constructor;

/**
 * @author wanggc
 * @date 2019/05/25 星期六 15:00
 */
//构造代码块
class Person2 {
    private int id;
    private int age;
    private String name;

    {
        //每个对象创建出来都会执行这里的代码
        cry();
    }

    Person2(){
        //cry();
    }

 /*   Person2(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void cry(){
        System.out.println("哇哇哇。。。。");
    }
}

/*
* 作用
1：给对象进行初始化。对象一建立就运行并且优先于构造函数。
*
2：与构造函数区别
1：构造代码块和构造函数的区别，构造代码块是给所有对象进行统一初始化， 构造函数给对应的对象初始化。
2：构造代码块的作用：它的作用就是将所有构造方法中公共的信息进行抽取。
例如孩子一出生统一哭

* */

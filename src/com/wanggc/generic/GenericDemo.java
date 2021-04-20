package com.wanggc.generic;

import java.lang.String;
import java.util.*;

/**
 * @author wanggc
 * @date 2019/06/25 星期二 23:35
 */

/*
* 当集合中存储的对象类型不同时，那么会导致程序在运行的时候的转型异常
* */

//泛型类
public class GenericDemo {
    public static void main(String[] args) {
        MyInter<String> myInter = new MyInter<String>();
        myInter.print("泛型");

        MyInter2 myInter2 = new MyInter2();
        myInter2.print("只能传字符串");

        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(new Object());
        arrayList.add("string");
        print(arrayList);

    //将集合的泛型设置类String类型，是Object子类
        HashSet<String> hashMap = new HashSet<String>();
        hashMap.add("wgc");
        hashMap.add("jack");
        //由于print方法接收的集合进行了元素限定，只接受限定为Object类型的集合,编译不通过
        print(hashMap);
/*
* 可以把方法的形参的泛型去掉,那么方法中就把集合中的元素当做Object类型处理.
也可以使用使用泛型通配符
* */


    }
    //泛型方法
/*    public <T> T getData(T data){
        return data;
    }*/

    //public static void print(Collection<Object> collection){
        //Iterator<Object> iterator = collection.iterator();
    public static void print(Collection<?> collection){
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

interface Inter<T>{
    void print(T t);
}

// 实现不知为何类型时可以这样定义
class MyInter<T> implements Inter<T>{
    public void print(T t){
        System.out.println("myinter"+ t);
    }
}

//使用接口时明确具体类型
class MyInter2 implements Inter<String>{
    @Override
    public void print(String t) {
        System.out.println("myibter"+ t);
    }
}
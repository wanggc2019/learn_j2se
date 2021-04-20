package com.wanggc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanggc
 * @date 2019/06/20 星期四 22:51
 */

/*
---| Iterable     接口
	      Iterator iterator()
	----| Collection     接口
		------| List      接口 元素可以重复，允许在指定位置插入元素，并通过索
引来访问元素

* */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("计算机原理");
        list.add("操做系统");
        list.add("java语言");
        list.add("毛泽东文选1");
        list.add("网络架构");

        System.out.println("list1="+list);

        // add,在0角标位置添加一本书
        list.add(0,"我是添加的1");
        System.out.println("list1="+list);

        List list2 = new ArrayList();
        list2.add("毛选2");
        list2.add("毛选3");
        System.out.println("list2="+list2);
        // 在list2集合的1角标位置添加list集合元素
        //list2.addAll(1,list);
        boolean addAll = list2.addAll(1,list);
        System.out.println(addAll);
        System.out.println("list2="+list2);

    //    remove
        list.remove(0);
        System.out.println("list1="+list);
    //    alter
        list.set(2,"数学");
        System.out.println(list);
    //    查找元素
        Object get = list.get(list.size() - 1);
        Object get2 = list.get(0);
        System.out.println(get2);
        System.out.println(get);
        // 角标越界
        //list.get(list.size());
    //查找角标,indexOf(Object o) 返回第一次出现的指定元素的角标
        int indexOf = list.indexOf("毛泽东文选1");
        System.out.println(indexOf);
        int indexOf2 = list.indexOf("阁楼");
        System.out.println(indexOf2);// reture -1
        //lastIndexOf 返回最后出现的指定元素的角标
        int indexOf3 = list.lastIndexOf("毛泽东文选1");
        System.out.println(indexOf3);

    }
}

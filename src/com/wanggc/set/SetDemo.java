package com.wanggc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wanggc
 * @date 2019/06/23 星期日 21:53
 */

/*
* set用于存储无序(存入和取出的顺序不一定相同)元素，值不能重复。
* 该集合中没有特有的方法，直接继承自Collection。
---| Itreable      接口 实现该接口可以使用增强for循环
				---| Collection		描述所有集合共性的接口
					---| List接口	    有序，可以重复，有角标的集合
                            ---| ArrayList
                            ---|  LinkedList
					---| Set接口	    无序，不可以重复的集合
                            ---| HashSet  线程不安全，存取速度快。底层是以hash表实现的。
                            ---| TreeSet  红-黑树的数据结构，默认对元素进行自然排序（String）。如果在比较的时候两个对象返回值为0，那么元素重复。

* */
public class SetDemo {
    public static void main(String[] args) {
        Set hs = new HashSet();
        System.out.println("----输出set元素----");
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println();

        hs.add("世界军事"); //重复元素不会添加
        boolean add = hs.add("世界军事");
        System.out.println(add);
        System.out.println(hs);
        System.out.println(hs.size());

        System.out.println("----遍历set----");
        Iterator it = hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
}

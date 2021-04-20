package com.wanggc.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author wanggc
 * @date 2019/06/23 星期日 15:28
 */

/*
Iterator iterator() 返回该集合的迭代器对象
该类主要用于遍历集合对象，该类描述了遍历集合的常见方法
			1：java.lang. Itreable
			 ---| Itreable      接口 实现该接口可以使用增强for循环
				---| Collection		描述所有集合共性的接口
					---| List接口	    可以有重复元素的集合
					---| Set接口	    不可以有重复元素的集合

Iterator接口定义的方法
Itreator	该接口是集合的迭代器接口类，定义了常见的迭代方法
	1：boolean hasNext()
						判断集合中是否有元素，如果有元素可以迭代，就返回true。
	2： E next()
						返回迭代的下一个元素，注意： 如果没有下一个元素时，调用
next元素会抛出NoSuchElementException

	3： void remove()
						从迭代器指向的集合中移除迭代器返回的最后一个元素（可选操
作）。
思考：为什么next方法的返回类型是Object的呢？ 为了可以接收任意类型的对象,那么返回的时候,不知道是什么类型的就定义为object

* */


//迭代器遍历
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("计算机网络");
        list.add("现代操作系统");
        list.add("java编程思想");
        list.add("java核心技术");
        list.add("java语言程序设计");
        System.out.println("----打印list----");
        System.out.println(list);
        System.out.println();

    //    迭代while
        System.out.println("----迭代输出list元素----");
        Iterator it = list.iterator();
        while (it.hasNext()){
            String str = (String) it.next();
            System.out.println(str);
        }
        System.out.println();

    //    迭代 for
        for (Iterator it2=list.iterator();it2.hasNext();){
        //    迭代器的next方法返回值类型是Object，所以要记得类型转换。
            String next = (String) it2.next();
            System.out.println(next);

        }
        System.out.println();

    }
}
/*
*需要取出所有元素时，可以通过循环，java 建议使用for 循环。因为可以对内存进行一下优化。
* */
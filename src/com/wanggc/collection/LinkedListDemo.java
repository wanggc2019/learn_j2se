package com.wanggc.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author wanggc
 * @date 2019/06/21 星期五 23:31
 */
/*
--| Iterable
			  ----| Collection
				 ------| List
				      ---------| ArrayList  底层采用数组实现，默认10。每次增长
60%,（(oldCapacity * 3)/2 + 1） 查询快，增删慢。
				 ---------| LinkedList  底层采用链表实现，增删快，查询慢。

* */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
/*        System.out.println("----添加linklist元素----");
        linkedList.add("西游记");
        linkedList.add("水浒传");
        linkedList.add("三国演义");
        linkedList.add("红楼梦");
        System.out.println(linkedList);
        System.out.println();

        // 迭代输出
        System.out.println("----迭代输出----");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            //String next = (String) iterator.next();
            System.out.println(iterator.next());
        }
        System.out.println();

    //    逆序迭代
        System.out.println("----逆序输出----");
        Iterator dit = linkedList.descendingIterator();
        while (dit.hasNext()){
            System.out.println(dit.next());
        }
        System.out.println();*/

    // m用linklist模拟数据结构，堆栈，队列
    //    堆栈：后进先出，pop(),push()
    //    压栈
        System.out.println("----开始压栈----");
        linkedList.push("西游记");
        linkedList.push("水浒传");
        linkedList.push("三国演义");
        linkedList.push("红楼梦");
        System.out.println(linkedList);

        System.out.println();

    //    出栈
        System.out.println("----开始出栈----");
        String str1 = (String) linkedList.pop();
        System.out.println(str1);
        String str2 = (String) linkedList.pop();
        System.out.println(str2);
        String str3 = (String) linkedList.pop();
        System.out.println(str3);
        String str4 = (String) linkedList.pop();
        System.out.println(str4);

/*        String str5 = (String) linkedList.pop(); //NoSuchElementException
        System.out.println(str5);
*/
        System.out.println(linkedList);//[] 栈已空
        System.out.println();

    //    队列：先进先出，offer(),poll()
    //    入队
        System.out.println("----开始入队----");
        linkedList.offer("西游记");
        linkedList.offer("水浒传");
        linkedList.offer("三国演义");
        linkedList.offer("红楼梦");
        System.out.println(linkedList);
        System.out.println();

    // 出队
        System.out.println("----开始出队----");
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll()); //null
        System.out.println(linkedList);//[]

        System.out.println();
/*
Vector: 描述的是一个线程安全的ArrayList。

ArrayList： 单线程效率高
Vector   ： 多线程安全的，所以效率低

* */
        Vector vector = new Vector();
        vector.addElement("赵");
        vector.addElement("钱");
        vector.addElement("孙");
        vector.addElement("李");
        System.out.println(vector);
        System.out.println(vector.elementAt(2));

        //遍历
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

    }
}

/*
ArrayList 和 LinkedList的存储查找的优缺点：
1、ArrayList 是采用动态数组来存储元素的，它允许直接用下标号来直接查找对应的元素。但是，但是插入元素要涉及数组元素移动及内存的操作。
总结：查找速度快，插入操作慢。
2、LinkedList 是采用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快
总结：查找慢，插入快
问题：有一批数据要存储，要求存储这批数据不能出现重复数据，ArrayList、LinkedList都没法满足需求。解决办法：使用 set集合。

* */

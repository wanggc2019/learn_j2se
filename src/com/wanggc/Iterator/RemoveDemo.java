package com.wanggc.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wanggc
 * @date 2019/06/23 星期日 19:22
 */
public class RemoveDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("ABCD");
        collection.add("EFGH");
        collection.add("LMJK");
        System.out.println(collection);
        System.out.println();

        Iterator iterator = collection.iterator();
        //    清空集合
        System.out.println("----清除集合----");
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(collection);
    }
}
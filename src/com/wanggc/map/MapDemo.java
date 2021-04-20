package com.wanggc.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author wanggc
 * @date 2019/06/23 星期日 22:52
 */

/*
* Map学习体系：
 ---| Map  接口    将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。
			---| HashMap  采用哈希表实现，所以无序
            ---| TreeMapDemo   可以对健进行排序

---|Hashtable:
底层是哈希表数据结构，线程是同步的，不可以存入null键，null值。
效率较低，被HashMap 替代。
---|HashMap:
底层是哈希表数据结构，线程是不同步的，可以存入null键，null值。
要保证键的唯一性，需要覆盖hashCode方法，和equals方法。
---| LinkedHashMap：
该子类基于哈希表又融入了链表。可以Map集合进行增删提高效率。
---|TreeMapDemo:
底层是二叉树数据结构。可以对map集合中的键进行排序。需要使用Comparable或者Comparator 进行比较排序。return 0，来判断键的唯一性。

* */

/*
* 遍历Map的方式：
1、将map 集合中所有的键取出存入set集合。
		Set<K> keySet()   返回所有的key对象的Set集合
                             再通过get方法获取键对应的值。
2、 values() ，获取所有的值.
		Collection<V> values()不能获取到key对象
3、 Map.Entry对象  推荐使用   重点
		Set<Map.Entry<k,v>> entrySet()
将map 集合中的键值映射关系打包成一个对象
Map.Entry对象通过Map.Entry 对象的getKey，
getValue获取其键和值。

* */

//该案例使用了HashMap，建立了学生姓名和年龄之间的映射关系。并试图添加重复的键。
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        System.out.println("----输出map元素----");
        map.put("wgc",23);
        map.put("jack",24);
        map.put("mary",21);
        map.put("jhna",26);
        System.out.println("map:"+map);
        System.out.println();

        // 添加重复的键值（值不同）,会返回集合中原有（重复键）的值
        System.out.println("插入重复值："+map.put("wgc",24));//23

        Map<String,Integer> map1 = new HashMap<String,Integer>();
        map1.put("张三",39);
        map1.put("李四",35);
        map1.put("王五",37);
        System.out.println("map1："+map1);
        System.out.println();

        //从指定映射中将所有映射关系复制到此映射中
        map.putAll(map1);
        System.out.println("map"+map);

    //    删除
        System.out.println("删除："+map.remove("wgc"));
        System.out.println("size:"+map.size());

    //    判断
        System.out.println("判断是否为空："+map.isEmpty());
        System.out.println("判断集合是否包含指定的key："+ map.containsKey("wgc"));
        System.out.println("判断集合是否包含指定的value:"+map.containsValue(26));

    //    遍历Map的方式
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();
        while (it.hasNext()){
            // 返回的是封装了key和value对象的Map.Entry对象
            Map.Entry<String,Integer> entry = it.next();
            // 获取Map.Entry对象中封装的key和value对象
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key:value="+ key+":"+value);
        }
    }
}

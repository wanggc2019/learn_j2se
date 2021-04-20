package com.wanggc.map;

import java.util.*;

/**
 * @author wanggc
 * @date 2019/06/25 星期二 0:38
 */

/*
* 注意：Set的元素不可重复，Map的键不可重复，如果存入重复元素如何处理
Set元素重复元素不能存入add方法返回false
Map的重复健将覆盖旧键，将旧值返回。

* */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Person2,String> treeMap = new TreeMap<Person2,String>(new MyComparator());
        treeMap.put(new Person2("wgc",20),"1001");
        treeMap.put(new Person2("wgc2",22),"1002");
        treeMap.put(new Person2("wgc3",24),"1003");
        treeMap.put(new Person2("wgc4",26),"1004");
        System.out.println(treeMap);

        Set<Map.Entry<Person2,String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<Person2,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Person2,String> next = iterator.next();
            Person2 key = next.getKey();
            String value = next.getValue();
            System.out.println("key:value = "+  key +":" +value);
        }
    }
}

class Person2 implements Comparable<Person2>{
    private String name;
    private int age;

    Person2(){}

    public Person2(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {

        return this.name.hashCode() + age * 37;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person2 p = (Person2) obj;
            return this.name.equals(p.name) && this.age == p.age;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        return "Person@name:" + this.name + " age:" + this.age;
    }

    @Override
    public int compareTo(Person2 o) {
        if (this.age > o.age){
            return 1;
        } else if (this.age < o.age){
            return -1;
        }

        return this.name.compareTo(o.name);
    }
}

class MyComparator implements Comparator<Person2>{
    @Override
    public int compare(Person2 o1, Person2 o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        } else if (o1.getAge() < o2.getAge()){
            return -1;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
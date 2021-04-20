package com.wanggc.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author wanggc
 * @date 2019/06/24 星期一 21:17
 */

/*
* 底层是哈希表数据结构，线程是不同步的，可以存入null键，null值。要保证键的唯一性，需要覆盖hashCode方法，和equals方法。
案例：自定义对象作为Map的键。

* */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Person,String> hashMap = new HashMap<Person,String>();
        hashMap.put(new Person("jack",20),"1001");
        hashMap.put(new Person("rose",21),"1002");
        hashMap.put(new Person("licy",20),"1003");
        hashMap.put(new Person("smith",24),"1004");
        System.out.println("----输出hashmap----");
        System.out.println(hashMap);
        System.out.println("----添加新元素----");
        System.out.println(hashMap.put(new Person("rose",18),"1006"));

        Set<Entry<Person,String>> entrySet = hashMap.entrySet();
        System.out.println("----遍历输出map元素----");
        Iterator<Entry<Person,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Entry<Person,String> next = iterator.next();
            Person key = next.getKey();
            String value = next.getValue();
            System.out.println("key:value= "+key + " : " + value);
        }
    }
}

class Person{
    private String name;
    private int age;

    Person(){}

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(){
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+age * 37;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age ==person.age;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person@name:"+ this.name + "age:" + this.age;
    }
}

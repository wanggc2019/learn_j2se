package com.wanggc.collection;

import java.util.ArrayList;

/**
 * @author wanggc
 * @date 2019/06/21 星期五 1:10
 */

/*
--| Iterable
			  ----| Collection
				 ------| List
				      ---------| ArrayList  底层采用数组实现，默认10。每次增长
60%,（(oldCapacity * 3)/2 + 1） 查询快，增删慢。
				 ---------| LinkedList

* */

//在实际的开发中ArrayList是使用频率最高的一个集合。
public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList arr = new ArrayList();
        Person2 person2 = new Person2("wgc", 20);
        Person2 person2_1 = new Person2("jack", 21);
        Person2 person2_2 = new Person2("smith", 22);

        arr.add(person2);
        arr.add(person2_1);
        arr.add(person2_2);
        System.out.println(arr);

        ArrayList arr2 = new ArrayList();
        for (int i = 0;i<arr.size();i++){
            Object object = arr.get(i);
            Person2 person = (Person2) object;
            if (!arr2.contains(person)){
                arr2.add(person);
            }

        }
        System.out.println(arr2);

    }
}

class Person2 {
    private String name;
    private int age;

    public Person2() {

    }

    public Person2(String name, int age) {

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
        if (!(obj instanceof Person)) {
            return false;
        }
        Person2 p = (Person2) obj;

        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public String toString() {
        return "Person@name:" + this.name + " age:" + this.age;
    }

}

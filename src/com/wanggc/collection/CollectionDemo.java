package com.wanggc.collection;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wanggc
 * @date 2019/06/19 星期三 15:23
 */

/*
存储对象的容器，面向对象语言对事物的体现都是以对象的形式，所以为了方便对多个对象的操作，存储对象，集合是存储对象最常用的一种方式。
集合的出现就是为了持有对象。集合中可以存储任意类型的对象, 而且长度可变。在程序中有可能无法预先知道需要多少个对象,
那么用数组来装对象的话, 长度不好定义, 而集合解决了这样的问题。
* */
public class CollectionDemo {
    public static void main(String[] args) {
        //3：创建集合对象,使用Collection中的List的具体实现类ArrayList
/*
        Collection list = new ArrayList();
        list.add("计算机网络");
        list.add("操做系统");
        list.add("c语言");
        System.out.println(list);

        Collection list2 = new ArrayList();
        list2.add("java技术");
        list2.addAll(list);
        list2.add("java核心思想");
        System.out.println(list2);

        list.remove("计算机网络");
        System.out.println(list);
        boolean remove = list.remove("操做系统");
        System.out.println(remove);

        boolean empty = list.isEmpty();
        System.out.println(empty);
        list.clear();
        boolean empty2 = list.isEmpty();
        System.out.println(empty2);

        int size = list2.size();
        System.out.println(size);
*/

        //集合中添加自定义得对象
        Collection collection = new ArrayList();
        Person person = new Person("wgc",20);
        Person person1 = new Person("zhangsan",21);
        Person person2 = new Person("lisi",22);
        collection.add(person);
        collection.add(person1);
        collection.add(person2);
        System.out.println(collection);

        boolean isEmpty = collection.isEmpty();
        System.out.println(isEmpty);
        int collection_size = collection.size();
        System.out.println(collection_size);
        //contains()判断集合何中是否包含指定对象
        boolean contains = collection.contains(person);
        System.out.println(contains);
        //将指定的对象从集合中删除
        collection.remove(person);
        collection.clear();
        System.out.println(collection);

        Collection collection1 = new ArrayList();
        collection1.add(new Book("java技术",100.00));
        collection1.add(new Book("c语言",80.90));
        System.out.println(collection1);

    }
}

class Person{
    private String name;
    private int age;

    public  Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+ age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age ==person.age;
    }

    @Override
    public String toString() {
        return "Person:name="+name + ",age="+age;
    }
}

class Book{
    private String name;
    private double price;

    public Book(){}

    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(){
        this.price = price;
    }

    @Override
    public int hashCode() {
        return (int)(this.name.hashCode()+price);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)){
            return false;
        }
        Book book = (Book) obj;
        return this.name.equals(book.name) && this.price == book.price;
    }

    @Override
    public String toString() {
        return "Book:name="+name + ",price="+price;
    }
}
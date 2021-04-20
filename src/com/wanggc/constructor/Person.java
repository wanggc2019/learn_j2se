package com.wanggc.constructor;

/**
 * @author wanggc
 * @date 2019/05/25 星期六 13:50
 */
public class Person {
    String name;
    int age;
    String gender;
    int salary;

    //    全参构造方法
    Person(String n, int a) {
        name = n;
        age = a;
    }

    //    无参的构造方法
    Person() {
    }

    Person(String n,int a, String g){
        name = n;
        age = a;
        gender = g;
    }

    Person(String n,int a, String g,int s){
        name = n;
        age = a;
        gender = g;
        salary = s;
    }
//    jvm根据创建对象的参数来选择使用哪个构造方法


    @Override
    public boolean equals(Object obj) {
        Person person = null;
        if (obj instanceof Person){
            person = (Person) obj;
        }
        if (this.name.equals(person.name)){
            return true;
        }
        return false;
    }
}


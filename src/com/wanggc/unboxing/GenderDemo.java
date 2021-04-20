package com.wanggc.unboxing;

/**
 * @author wanggc
 * @date 2019/06/27 星期四 21:19
 */

//枚举类
public class GenderDemo {
    public static void main(String[] args) {
        Gender male = Gender.MALE;
        Gender female = Gender.FEMALE;
        System.out.println(male.getInfo());
        System.out.println(female.getInfo());
    }
}
//枚举类可以声明抽象方法,但是要有具体的枚举值去实现.
enum Gender{
    MALE("男"),FEMALE("女");
    //成员变量
    private String info;
    //构造函数
    private Gender(){

    }
    private Gender(String info){
        this.info = info;
    }
    //成员方法
    public String getInfo(){
        return info;
    }
}
package com.wanggc.polymorphism;

import com.wanggc.abstractTest.Bird;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 22:39
 */

/*
        2：多态可以作为返回值类型。
        获取任意一辆车对象
        1：定义汽车类，有名字和颜色，提供有参和无参构造，有运行的行为。
        2：定义Bmw类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
        3：定义Benz类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
        4：定义Bsj类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
        5：定义静态方法，汽车工厂，随机生产汽车。使用多态定义方法返回值类型。
        1：使用(int)Math.round(Math.random()*2); 生成0-2之间随机数。
        Math 类
        2：使用if else 判断，指定，0,1,2 new 不同汽车 并返回。
        6：调用该方法，发现多态的好处。
*/

class Car {
    String name;
    String color;

    Car(){

    }

    Car(String name,String color){
        this.color = color;
        this.name = name;
    }

    void run(){
        System.out.println("跑跑");
    }
}

class Bmw extends Car{
    Bmw(){

    }

    Bmw(String name,String color){
        super(name,color);
    }

    @Override
    void run() {
        System.out.println("宝马很拉风");
    }

}

class Benz extends Car{
    Benz(){

    }

    Benz(String name,String color){
        super(name,color);
    }

    @Override
    void run() {
        System.out.println("奔驰商务首选");
    }
}

class Bsj extends Car{
    Bsj(){

    }

    Bsj(String name,String color){
        super(name,color);
    }

    @Override
    void run() {
        System.out.println("泡妞首选");
    }
}

class CarTest{
    public static void main(String[] args) {

        int x =0;
        while (x < 100){
            Car car = CarFactory();
            car.run();
            x++;
        }
    }

    /*
    定义静态方法，汽车工厂，随机生产汽车。使用多态定义方法返回值类型。
	使用随机数，0.1.2 if 0 bsj 1 bmw 2 bc
    * */
    public static Car CarFactory(){
        int x = (int) Math.round(Math.random() * 2);

        if (0 == x){
            return new Bmw("宝马x6","红");
        }
        else if (1 == x){
            return new Benz("奔驰","黑色");
        }
        else if (2 == x){
            return new Bsj("保时捷","蓝色");
        }
        else {
            return new Bmw("Smart","红色");
        }
    }
}
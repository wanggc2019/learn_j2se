package com.wanggc.polymorphism;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 21:47
 */

/*
多态练习
	1：多态可以作为形参，接受范围更广的对象，避免函数重载过度使用。
		1：定义功能，根据输出任何图形的面积和周长。
		子类重写了父类的抽象方法，多态下，会执行子类的非静态方法。
	2：多态可以作为返回值类型。
		获取任意一辆车对象
	3：抽象类和接口都可以作为多态中的父类引用类型。

* */
abstract class MyShape {
    public abstract double getArea();

    public abstract double getLen();
}

class Rect extends MyShape{
    double width;
    double heigght;

    Rect(){

    }

    Rect(double width,double heigght){
        this.heigght = heigght;
        this.width = width;
    }

    @Override
    public double getArea(){
        //System.out.println();
        return width * heigght;
    }

    @Override
    public double getLen() {
        return (width + heigght) * 2;
    }
}

class Circle extends MyShape{
    double r;
    public static final double PI = 3.14;

    Circle(){

    }

    Circle(double r){
        this.r = r;
    }

    @Override
    public double getArea() {
        return r * r * PI;
    }

    @Override
    public double getLen() {
        return r * PI * 2;
    }
}

class MyShapeTest{
    public static void main(String[] args) {
        print(new Rect(4,5));
        print(new Circle(4));
    }

    //根据用户传入的图形对象，计算出该图形的面积和周长
    // 1：多态可以作为形参，接受范围更广的对象，避免函数重载过度使用。
    public static void print(MyShape myShape){
        System.out.println(myShape.getArea());
        System.out.println(myShape.getLen());
        System.out.println();
    }
}

package com.wanggc.abstractTest;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 16:30
 */
abstract class MyShape {
    //不写方法体
    abstract double getLen();

    abstract double getArea();

}

class Rect extends MyShape{
    double width;
    double height;

    Rect(){

    }

    Rect(double width,double height){
        this.width = width;
        this.height = height;
    }

    double getLen(){
        return (width + height) * 2;
    }

    double getArea(){
        return width * height;
    }
}

class Cirle extends MyShape{
    double r;
    public static final double PI = 3.14;

    Cirle(){

    }

    Cirle(double r){
        this.r = r;
    }

    double getLen(){
        return 2 * PI * r;
    }

    double getArea(){
        return PI * r * r;
    }
}
class Demo{
    public static void main(String[] args) {
        Rect rect = new Rect(5,5);
        System.out.println(rect.getArea());
        System.out.println(rect.getLen());
        System.out.println();

        Cirle cirle = new Cirle(5);
        System.out.println(cirle.getArea());
        System.out.println(cirle.getLen());
    }
}

/*
6：抽象类的特点
			1：有抽象函数的类，该类一定是抽象类。
			2：抽象类中不一定要有抽象函数。
			3：抽象类不能使用new创建对象
				1：创建对象，使用对象的功能，抽象类的方法，没有方法体。
			4：抽象类主要为了提高代码的复用性，让子类继承来使用。
			5：编译器强制子类实现抽象类父类的未实现的方法。
				1：可以不实现，前提是子类的也要声明为抽象的。
		7：抽象的优点
			1：提高代码复用性
				2：强制子类实现父类中没有实现的功能
			2：提高代码的扩展性，便于后期的代码维护
		8：抽象类不能创建对象，那么抽象类中是否有构造函数？
1：抽象类中一定有构造函数。主要为了初始化抽象类中的属性。通常由子类实现。
		9：final和abstract是否可以同时修饰一个类？
			一定不能同时修饰。
* */

/*
抽象类可以没有抽象方法（java.awt.*的类就是这样子操作的）。
抽象类可以继承普通类与抽象类。
抽象类不能直接使用类名创建实例，但是有构造方法，构造方法是让子类进行初始化。
抽象类一定有构造方法。
abstract与其他修饰符的关系:
	1.final与abstract不能共存:
		final:它的作用  修饰类代表不可以继承  修饰方法不可重写
		abstract修饰类就是用来被继承的，修饰方法就是用来被重写的。

	2.static与abstract不能共存:
	static static修饰的方法可以用类名调用，
		 对于abstract修饰的方法没有具体的方法实现，所有不能直接调用，
		也就是说不可以与static共存。

	3.private与abstract不能共存:
		private修饰的只能在本类中使用，
		abstract方法是用来被子类进行重写的，有矛盾
		所有不能共存.

* */
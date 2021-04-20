package com.wanggc.inheritance;

/**
 * @author wanggc
 * @date 2019/05/29 星期三 22:43
 */
/*
1.单继承
class A
class B extend A
2.多重继承
class A
class B extend A
class C extend B
3.不通类继承同一个父类
class A
class B extend A
class C extend A
4.不支持多继承
class A
class C extend A,B
* */
public class Main {
    public static void main(String[] args) {
        Stduent stduent = new Stduent();
        stduent.name = "王国昌";
        stduent.age = 20;
        stduent.study();
        stduent.speak();
        System.out.println(stduent.country);
        System.out.println(Stduent.country);

        Worker worker = new Worker();
        worker.name = "张三";
        worker.age = 23;
        worker.work();
        worker.speak();
        System.out.println(worker.country);
        System.out.println(Worker.country);

        Son son = new Son(3);
        System.out.println(son.y);
        son.eat();

        Penguin penguin = new Penguin("jack",1);
        penguin.eat();
        penguin.sleep();
        penguin.introduction();

        System.out.println(FinalTest.PI);
        System.out.println(FinalTest.getArea(3.0));
        System.out.println(FinalTest.getLength(4.0));
    }
}

/*
继承细节；
	1：类名的设定，被继承的类称之为父类(基类)，继承的类称之为子类
	2：子类并不能继承父类中所有的成员
        1：父类定义完整的成员 静态成员，非静态，构造方法。静态变量和静态方法都可以通过子类名.父类静态成员的形式调用成功。
		2：所有的私有成员不能继承private修饰的成员。
		3：构造函数不能被继承

	1： 函数名必须相同
	2：参数列表必须相同
    3： 子类重写父类的函数的时候，函数的访问权限必须大于等于父类的函数的访
      问权限否则编译报错
    4：子类重写父类的函数的时候，返回值类型必须是父类函数的返回值类型或该返回值类型的子类。
    不能返回比父类更大的数据类型： 如子类函数返回值类型是Object
* */

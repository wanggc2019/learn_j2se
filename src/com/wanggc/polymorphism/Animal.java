package com.wanggc.polymorphism;

import com.wanggc.inheritance.FinalTest;

/**
 * @author wanggc
 * @date 2019/06/03 星期一 11:12
 */

/*
案例：
	1：定义Animal类颜色成员变量，无参构造，有参构造，run方法
2：定义Dog类， 继承Animal, 定义无参构造，有参构造（使用super调用父类有参构造），Dog的特有方法ProtectHome
3：定义Fish类，继承Animal，定义无参构造，有参构造（使用super调用父类有参构造），Fish特有方法swim
4：定义Bird类，继承Animal，定义无参构造，有参构造（使用super调用父类有参构造），Bird特有方法fly
5：使用多态，Animal a=new Dog();
6：调用Dog的特有方法，ProtectHome
	1：类类型转换，Dog d=(Dog)a;
	2：d.protectHome
7：非多态
	1：Animal a=new Animal();
	2：类类型转换
		Dog d=(Dog)a;
		d.protectHome();
	3：编译通过，运行出现异常
		1：ClassCastException
8：多态例外
	1：Animal  a=new Dog();
	2：类类型转换
		1：Fish f=(Fish)a;
		2：f.fish();
		3：编译通过，运行异常
			1：ClassCastException
		4：虽然是多态，但是鸟不能转为狗，狗不能转为鱼，他们之间没有关系。

* */
class Animal {
    String color;

    Animal(){

    }

     Animal(String color){
        this.color = color;
     }

     void run(){
         System.out.println("跑跑");
     }

}

class Dog extends Animal{
    Dog(){

    }

    Dog(String color){
        super(color);
    }

    @Override
    void run() {
        System.out.println("狗儿跑跑");
    }

    void proteHome(){
        System.out.println("狗会看家");
    }
}

class Fish extends Animal{
    Fish(){

    }

    Fish(String color){
        super(color);
    }

    @Override
    void run() {
        System.out.println("鱼儿水中游");
    }

    void swim(){
        System.out.println("鱼儿会游泳");
    }
}

class Bird extends Animal{

    Bird(){

    }

    Bird(String color){
        super(color);
    }

    @Override
    void run() {
        System.out.println("鸟儿空中飞");
    }

    void fly(){
        System.out.println("鸟儿会飞");
    }
}



class AnimalTest{
    public static void main(String[] args) {
        Animal animal = new Dog();
        //animal.proteHome();
        //正常转换
        Dog dog = (Dog) animal;
        dog.proteHome();

    //    多态例外
    //    编译ok，运行error，会报ClassCastException
/*
        Animal animal1 = new Animal();
        Dog dog1 = (Dog) animal1;//动物是狗
*/

    //    多态例外
    //    编译ok，运行error，会报ClassCastException
/*        Animal dog2 = new Dog();
        Fish fish = (Fish) don2;//狗是鱼
*/

        System.out.println();
        doSomething(new Dog());
        doSomething(new Fish());
        doSomething(new Bird());

    }

    //定义一功能，接收用户传入动物，根据用于传入的具体动物，执行该动物特有的方法
    public static void doSomething(Animal animal){
        if (animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.proteHome();
        }
        else if (animal instanceof Fish){
            Fish fish = (Fish) animal;
            fish.swim();
        }
        else if (animal instanceof Bird){
            Bird bird = (Bird) animal;
            bird.fly();
        }
        else {
            System.out.println("over");
        }
    }

}



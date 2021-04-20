package com.wanggc.Reflection;

import com.wanggc.encapsulation.Calculator;

/**
 * @author wanggc
 * @date 2019/07/02 星期二 21:43
 */
//工厂模式
//    该模式将创建对象的过程放在了一个静态方法中来实现.在实际编程中,如果需要大量的创建对象,该模式是比较理想的.
public class FactoryMode {
    public static void main(String[] args) {
        System.out.println("买宝马");
        Car bmw = CarFactory("BMW");
        bmw.run();
        System.out.println();

        System.out.println("买奔驰");
        Car benz = CarFactory("Benz");
        benz.run();
    }

    public static Car CarFactory(String carName){
        if ("BMW".equals(carName)){
            return new BMW();
        } else if ("Benz".equals(carName)){
            return new Benz();
        } else {
            throw new RuntimeException("车型有误");
        }
    }
}

abstract class Car{
    public abstract void run();
}
class BMW extends Car{
    @Override
    public void run() {
        System.out.println("宝马跑");
    }
}

class Benz extends Car{
    @Override
    public void run() {
        System.out.println("奔驰跑");
    }
}
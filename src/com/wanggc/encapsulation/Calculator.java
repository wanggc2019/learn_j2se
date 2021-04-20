package com.wanggc.encapsulation;

/**
 * @author wanggc
 * @date 2019/05/24 星期五  23:16
 */

// 封装练习2
//Java的三大特性：封装，继承，多态
//    Encapsulation, inheritance, polymorphism
public class Calculator {
    // 1. 查看具体的计算器对象抽取所有计算器具有的共同属性
    public String name = "我的计算器";
    public double num1;
    public double num2;
    public char option;

//   2. 查看具体的计算器对象抽取所有计算器具有的共同功能
//    2.1 定义接受数据的功能函数
    public void init(double a, char op, double b){
        num1 = a;
        option = op;
        num2 = b;
    }

    public void calculate(){

        switch (option){
            case '+':
                System.out.println(name+":"+num1 + "+"+num2+"="+ (num1+num2));
                break;
            case '-':
                System.out.println(name+":"+num1 + "-"+num2+"="+ (num1-num2));
                break;
            case '*':
                System.out.println(name+":"+num1 + "*"+num2+"="+ (num1*num2));
                break;
            case '/': {
                if (num2 != 0) {
                    System.out.println(name + ":" + num1 + "*" + num2 + "/" + (num1 / num2));
                    break;
                } else {
                    System.out.println("除数不能为0");
                }
            }
            case '%': {
                System.out.println(name + ":" + num1 + "%" + num2 + "=" + (num1 % num2));
                break;
            }

            default:
                System.out.println("无效输入，请正经点");
        }
    }

}

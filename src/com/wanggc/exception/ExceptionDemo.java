package com.wanggc.exception;

/**
 * @author wanggc
 * @date 2019/06/10 星期一 17:55
 */

/*
java中可以通过类对这一类不正常的现象进行描述，并封装为对象。
1.	java的异常体系包含在java.lang这个包默认不需要导入。
2.	java异常体系
			|——Throwable  （实现类描述java的错误和异常）
				|——Error （错误）一般不通过代码去处理。
				|——Exceprion （异常）
					|——RuntimeException （运行时异常）
					|——非运行时异常
错误(Error):
它指的是一个合理的应用程序不能截获的严重的问题。大多数都是反常的情况。错误是JVM的一个故障(虽然它可以是任何系统级的服务)。
所以，错误是很难处理的，一般的开发人员(当然不是你)是无法处理这些错误的。比如内存溢出.

2.3	Throwable类
1.	toString() 输出该异常的类名。
2.	getMessage() 输出异常的信息，需要通过构造方法传入异常信息（例如病态信息）。
3.	printStackTrace() 打印栈信息。

程序中得异常处理：
1.自行处理
1.	try{//可能发生异常的代码 }catch(异常类 变量名){//处理}。
2.	案例除法运算的异常处理。
3.	如果没有进行try catch处理，出现异常程序就停止。进行处理后，程序会继续执行。

2.抛出处理
定义一个功能，进行除法运算例如（div(int x,int y)）如果除数为0，进行处理。
功能内部不想处理，或者处理不了。就抛出使用throw new Exception("除数不能为0"); 进行抛出。
抛出后需要在函数上进行声明，告知调用函数者，我有异常，你需要处理如果函数上不进行throws 声明，编译会报错。
例如：未报告的异常 java.lang.Exception；必须对其进行捕捉或声明以便抛出throw  new Exception("除数不能为0");


3.自定义异常

* */
class Father {

}

class Son extends Father {

}

public class ExceptionDemo {

    public static void main(String[] args) {

        System.out.println();
        int[] arr = { 1, 2 };
        arr = null;
        Father f = new Father();
        try {
            div(1, 0, arr, f);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("over");
    }

    //public static void div(int x, int y, int[] arr, Father f){
    // 声明异常，通知方法调用者。
    public static void div(int x, int y, int[] arr, Father f) throws Exception {

        /*try {
            System.out.println(arr[1]);
            System.out.println(x / y);
            Son s = (Son) f;

        } catch (ArithmeticException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("算术异常。。。");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("数组角标越界。。。");
        } catch (NullPointerException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("空指针异常。。。");
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("出错啦");
        }*/

        if (y == 0){
            //throw关键字后面接受的是具体的异常的对象
            throw new Exception("除数为0");
        }
        System.out.println(x/y);
        System.out.println("函数执行完毕");
    }
}

/*
总结
处理异常应该catch异常具体的子类，可以处理的更具体，不要为了简化代码使用异常的父类。
* */

/*
定义一个功能，进行除法运算例如（div(int x,int y)）如果除数为0，进行处理。
功能内部不想处理，或者处理不了。就抛出使用throw new Exception("除数不能为0");
进行抛出。抛出后需要在函数上进行声明，告知调用函数者，我有异常，你需要处理如果函数上不进行throws 声明，编译会报错。
例如：未报告的异常 java.lang.Exception；必须对其进行捕捉或声明以便抛出throw  new Exception("除数不能为0");

* */

/*
throw和throws的区别
1.	相同：都是用于做异常的抛出处理的。
2.	不同点：
1.	使用的位置: throws 使用在函数上，throw使用在函数内
2.	后面接受的内容的个数不同:
1.	throws 后跟的是异常类，可以跟多个，用逗号隔开。
2.	throw 后跟异常对象。

总结
1.	try语句不能单独存在，可以和catch、finally组成 try...catch...finally、try...catch、try...finally三种结构。
2.	catch语句可以有一个或多个，finally语句最多一个，try、catch、finally这三个关键字均不能单独使用。
3.	try、catch、finally三个代码块中变量的作用域分别独立而不能相互访问。如果要在三个块中都可以访问，则需要将变量定义到这些块的外面。
4.	多个catch块时候，Java虚拟机会匹配其中一个异常类或其子类，就执行这个catch块，而不会再执行别的catch块。（子类在上，父类在下）。
5.	throw语句后不允许有紧跟其他语句，因为这些没有机会执行。
6.	如果一个方法调用了另外一个声明抛出异常的方法，那么这个方法要么处理异常，要么声明抛出。

* */
